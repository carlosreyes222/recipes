package com.cocinamingle.feature.home.ui

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cocinamingle.feature.home.data.model.RecipeModel
import com.cocinamingle.feature.home.domain.usecase.GetRecipeUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRecipeUC: GetRecipeUC,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel(), DefaultLifecycleObserver {

    private var searchJob: Job? = null

    private val _uiState: MutableStateFlow<HomeUiState> =
        MutableStateFlow(HomeUiState())

    val uiState: StateFlow<HomeUiState>
        get() = _uiState

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        if (uiState.value.recipes == null) {
            searchRecipes("pollo")
        }
    }

    fun searchRecipes(query: String) {
        searchJob?.cancel()
        _uiState.update { it.copy(loading = true) }
        searchJob = viewModelScope.launch(ioDispatcher) {
            delay(500)
            val response = getRecipeUC(query)
            if (response.isSuccess) {
                _uiState.update {
                    it.copy(
                        recipes = response.getOrNull(),
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

    override fun onCleared() {
        super.onCleared()
        searchJob?.cancel()
        searchJob = null
    }
}

data class HomeUiState(
    var recipes: List<RecipeModel>? = null,
    var error: String? = null,
    var loading: Boolean = false,
)