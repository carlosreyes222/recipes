package com.cocinamingle.feature.recipe.detail.impl.ui

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cocinamingle.feature.recipe.detail.impl.data.model.RecipeDetailModel
import com.cocinamingle.feature.recipe.detail.impl.domain.usecase.GetRecipeDetailUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val getRecipeDetailUC: GetRecipeDetailUC,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel(), DefaultLifecycleObserver {

    private val _uiState: MutableStateFlow<RecipeDetailUiState> =
        MutableStateFlow(RecipeDetailUiState())

    val uiState: StateFlow<RecipeDetailUiState>
        get() = _uiState


    fun getRecipeDetail(url: String) = viewModelScope.launch(ioDispatcher) {
        _uiState.update { it.copy(loading = true) }
        val response = getRecipeDetailUC(url)
        if (response.isSuccess) {
            _uiState.update {
                it.copy(
                    recipe = response.getOrNull(),
                    loading = false
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    error = response.exceptionOrNull()?.message,
                    loading = false
                )
            }
        }
    }

}

data class RecipeDetailUiState(
    var recipe: RecipeDetailModel? = null,
    var error: String? = null,
    var loading: Boolean = false,
)