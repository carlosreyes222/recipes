package com.cocinamingle.feature.recipe.detail.impl.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cocinamingle.feature.recipe.detail.impl.data.model.RecipeDetailModel
import com.cocinamingle.feature.recipe.detail.impl.domain.usecase.GetRecipeDetailUC
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeDetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val getRecipeDetailUC: GetRecipeDetailUC = mockk()
    private lateinit var viewModel: RecipeDetailViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = RecipeDetailViewModel(getRecipeDetailUC, testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getRecipeDetail updates uiState with loading and success`() = runTest {
        // Given
        val url = "http://example.com/recipe"
        val recipeDetail = mockk<RecipeDetailModel>()
        coEvery { getRecipeDetailUC(url) } returns Result.success(recipeDetail)

        // When
        viewModel.getRecipeDetail(url)

        // Then
        val state = viewModel.uiState.first()
        assertEquals(false, state.loading)

        advanceUntilIdle()

        val finalState = viewModel.uiState.first()
        assertEquals(recipeDetail, finalState.recipe)
        assertEquals(false, finalState.loading)
        assertNull(finalState.error)
    }

    @Test
    fun `getRecipeDetail updates uiState with loading and failure`() = runTest {
        // Given
        val url = "http://example.com/recipe"
        val errorMessage = "Error"
        coEvery { getRecipeDetailUC(url) } returns Result.failure(Throwable(errorMessage))

        // When
        viewModel.getRecipeDetail(url)

        // Then
        val state = viewModel.uiState.first()
        assertEquals(false, state.loading)

        advanceUntilIdle()

        val finalState = viewModel.uiState.first()
        assertNull(finalState.recipe)
        assertEquals(false, finalState.loading)
        assertEquals(errorMessage, finalState.error)
    }
}

