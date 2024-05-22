package com.cocinamingle.feature.recipe.detail.impl.data.repository


import com.cocinamingle.feature.recipe.detail.impl.data.datasource.RecipeDetailApi
import com.cocinamingle.feature.recipe.detail.impl.data.model.Recipe
import com.cocinamingle.feature.recipe.detail.impl.data.model.RecipeDetailResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class RecipeDetailRepositoryImplTest {

    private lateinit var remoteApi: RecipeDetailApi
    private lateinit var recipeDetailRepository: RecipeDetailRepositoryImpl

    @Before
    fun setUp() {
        remoteApi = mockk()
        recipeDetailRepository = RecipeDetailRepositoryImpl(remoteApi)
    }

    @Test
    fun `given a valid url when calling getRecipeDetail then call is successful`() = runBlocking {
        // Given
        val url = "https://example.com/recipe"
        val recipeDetail = mockk<Recipe>()
        val recipeDetailResponse = RecipeDetailResponse(
            recipe = recipeDetail
        )
        coEvery { remoteApi.getRecipeDetail(url) } returns Response.success(recipeDetailResponse)

        // When
        recipeDetailRepository.getRecipeDetail(url)

        // Then
        coVerify { remoteApi.getRecipeDetail(url) }
    }


    @Test
    fun `given a valid url when calling getRecipeDetail then returns failure when api call is unsuccessful`() =
        runBlocking {
            // Given
            val url = "https://example.com/recipe"

            val errorBody = mockk<okhttp3.ResponseBody>(relaxed = true)
            val errorResponse: Response<RecipeDetailResponse> = Response.error(404, errorBody)

            coEvery { remoteApi.getRecipeDetail(url) } returns errorResponse

            // When
            val result = recipeDetailRepository.getRecipeDetail(url)

            // Then
            assertTrue(result.isFailure)
            assertEquals(errorBody.charStream().toString(), result.exceptionOrNull()?.message)
            coVerify { remoteApi.getRecipeDetail(url) }
        }

    @Test
    fun `given a valid url when calling getRecipeDetail then returns failure when api call throws an exception`() =
        runBlocking {
            // Given
            val url = "https://example.com/recipe"
            val exceptionMessage = "Network error"
            coEvery { remoteApi.getRecipeDetail(url) } throws Exception(exceptionMessage)

            // When
            val result = recipeDetailRepository.getRecipeDetail(url)

            // Then
            assertTrue(result.isFailure)
            assertEquals("Network error", result.exceptionOrNull()?.message)
            coVerify { remoteApi.getRecipeDetail(url) }
        }
}
