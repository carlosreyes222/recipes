package com.cocinamingle.feature.home.data.usecase

import com.cocinamingle.feature.home.data.model.RecipeModel
import com.cocinamingle.feature.home.domain.repository.RecipeRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetRecipeUCImplTest {

    private lateinit var recipeRepository: RecipeRepository
    private lateinit var getRecipeUC: GetRecipeUCImpl

    @Before
    fun setUp() {
        recipeRepository = mockk()
        getRecipeUC = GetRecipeUCImpl(recipeRepository)
    }

    @Test
    fun `given a valid query invoke when repository returns success then returns data`() =
        runBlocking {
            // Given
            val query = "chicken"
            val recipes = listOf(RecipeModel("recipe1", "url1", 1, 100.0, ""))
            val result: Result<List<RecipeModel>> = Result.success(recipes)

            coEvery { recipeRepository.getNewRecipes(query) } returns result

            // When
            val actualResult = getRecipeUC.invoke(query)

            // Then
            assertTrue(actualResult.isSuccess)
            assertEquals(recipes, actualResult.getOrNull())
            coVerify { recipeRepository.getNewRecipes(query) }
        }

    @Test
    fun `given a valid query invoke then returns failure result repository then returns failure`() =
        runBlocking {
            // Given
            val query = "chicken"
            val errorMessage = "Error fetching recipes"
            val result: Result<List<RecipeModel>> = Result.failure(Throwable(errorMessage))

            coEvery { recipeRepository.getNewRecipes(query) } returns result

            // When
            val actualResult = getRecipeUC.invoke(query)

            // Then
            assertTrue(actualResult.isFailure)
            assertEquals(errorMessage, actualResult.exceptionOrNull()?.message)
            coVerify { recipeRepository.getNewRecipes(query) }
        }
}
