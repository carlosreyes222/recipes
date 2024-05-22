package com.cocinamingle.feature.home.data.repository

import com.cocinamingle.feature.home.data.datasource.RecipeApi
import com.cocinamingle.feature.home.data.model.Hit
import com.cocinamingle.feature.home.data.model.Recipe
import com.cocinamingle.feature.home.data.model.RecipeResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class RecipeRepositoryImplTest {

    private lateinit var remoteApi: RecipeApi
    private lateinit var repository: RecipeRepositoryImpl

    @Before
    fun setUp() {
        remoteApi = mockk()
        repository = RecipeRepositoryImpl(remoteApi)
    }

    @Test
    fun `given a query when response is successful and not null then it returns success result`() =
        runBlocking {
            // Given
            val query = "chicken"
            val recipeResponse = mockk<RecipeResponse>()
            val hit = mockk<Hit>()
            val recipe = mockk<Recipe>()
            val response: Response<RecipeResponse> = Response.success(200, recipeResponse)
            every { recipe.label } returns "recipe1"
            every { recipe.image } returns "image"
            every { recipe.ingredients.size } returns 1
            every { recipe.calories } returns 100.0
            every { hit.links.self.href } returns "url"
            every { hit.recipe } returns recipe
            every { recipeResponse.recipes } returns listOf(hit)

            coEvery { remoteApi.getNewRecipes(query) } returns response

            // When
            val result = repository.getNewRecipes(query)

            // Then
            //  assertEquals(1, result.getOrNull()?.size)
            assertEquals("recipe1", result.getOrNull()?.first()?.title)
            coVerify { remoteApi.getNewRecipes(query) }
        }

    @Test
    fun `given a query when response is failure result then getNewRecipes is not successful`() =
        runBlocking {
            // Given
            val query = "chicken"
            val errorBody = mockk<okhttp3.ResponseBody>(relaxed = true)
            val errorResponse: Response<RecipeResponse> = Response.error(404, errorBody)

            coEvery { remoteApi.getNewRecipes(query) } returns errorResponse

            // When
            val result = repository.getNewRecipes(query)

            // Then
            assertTrue(result.isFailure)
            assertEquals(errorBody.charStream().toString(), result.exceptionOrNull()?.message)
            coVerify { remoteApi.getNewRecipes(query) }
        }

    @Test
    fun `given a query when exception is thrown then returns failure result exception`() =
        runBlocking {
            // Given
            val query = "chicken"
            val errorMessage = "Network error"

            coEvery { remoteApi.getNewRecipes(query) } throws Exception(errorMessage)

            // When
            val result = repository.getNewRecipes(query)

            // Then
            assertTrue(result.isFailure)
            assertEquals(errorMessage, result.exceptionOrNull()?.message)
            coVerify { remoteApi.getNewRecipes(query) }
        }
}

