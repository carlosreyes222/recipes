package com.cocinamingle.feature.home.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cocinamingle.feature.home.data.model.RecipeModel
import com.cocinamingle.feature.home.domain.usecase.GetRecipeUC
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val getRecipeUC: GetRecipeUC = mockk()
    private lateinit var viewModel: HomeViewModel
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = HomeViewModel(getRecipeUC, testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given getRecipeUC invoked when searchRecipes updates uiState with loading and success`() =
        testScope.runTest {
            // Given
            val recipes = listOf(mockk<RecipeModel>())
            coEvery { getRecipeUC("pollo") } returns Result.success(recipes)

            // When
            val uiStates = mutableListOf<HomeUiState>()
            val job = launch {
                viewModel.uiState.collect { uiStates.add(it) }
            }

            viewModel.searchRecipes("pollo")

            advanceUntilIdle()

            // Then
            assertEquals(false, uiStates[0].loading)
            assertEquals(true, uiStates[1].loading)
            assertEquals(null, uiStates[1].recipes)
            assertEquals(recipes, uiStates[2].recipes)
            job.cancel()
        }

    @Test
    fun `given a error when searchRecipes updates uiState with loading and failure`() =
        testScope.runTest {
            // Given
            val errorMessage = "Error"
            coEvery { getRecipeUC("pollo") } returns Result.failure(Throwable(errorMessage))

            // When
            val uiStates = mutableListOf<HomeUiState>()
            val job = launch {
                viewModel.uiState.collect { uiStates.add(it) }
            }

            viewModel.searchRecipes("pollo")

            advanceUntilIdle()

            // Then
            assertEquals(false, uiStates[0].loading)
            assertEquals(true, uiStates[1].loading)
            assertEquals(errorMessage, uiStates[2].error)
            job.cancel()
        }
}

