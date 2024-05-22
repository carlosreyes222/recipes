package com.cocinamingle.feature.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import com.cocinamingle.design_system.molecule.DSLoader
import com.cocinamingle.design_system.theme.CocinaMingleTheme
import com.cocinamingle.feature.home.data.model.RecipeModel
import com.cocinamingle.feature.home.ui.organism.RecipeItem
import com.cocinamingle.feature.home.ui.organism.SearchContainer

@Composable
fun HomePage(
    goToRecipeDetail: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state: HomeUiState by viewModel.uiState.collectAsState()
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    lifecycle.addObserver(viewModel)

    Box {

        Scaffold(
            topBar = {
                SearchContainer(
                    actions = SearchContentActions(
                        onSearchByQuery = { viewModel.searchRecipes(it) },
                    ),
                    hints = state.recipes?.map { it.title }?.toSet() ?: setOf()
                )
            },
            content = { innerPadding ->
                if (state.loading && state.recipes.isNullOrEmpty()) DSLoader()
                HomeContainer(innerPadding, state.recipes ?: emptyList(), goToRecipeDetail)

            },
        )
    }
}


@Composable
private fun HomeContainer(
    innerPadding: PaddingValues,
    recipes: List<RecipeModel>,
    goToRecipeDetail: (String) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            top = innerPadding.calculateTopPadding() + CocinaMingleTheme.dimens.spacing8,
            start = CocinaMingleTheme.dimens.spacing4,
            end = CocinaMingleTheme.dimens.spacing4,
            bottom = CocinaMingleTheme.dimens.spacing4
        ),
        horizontalArrangement = Arrangement.spacedBy(CocinaMingleTheme.dimens.spacing4),
        verticalArrangement = Arrangement.spacedBy(CocinaMingleTheme.dimens.spacing4)
    ) {
        items(recipes) { recipe ->
            RecipeItem(recipe, onClick = { goToRecipeDetail(recipe.detailUrl) })
        }
    }
}


@Immutable
data class SearchContentActions(
    val onSearchByQuery: (String) -> Unit,
)