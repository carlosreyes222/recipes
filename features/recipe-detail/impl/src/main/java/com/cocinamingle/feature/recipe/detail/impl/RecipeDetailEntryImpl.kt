package com.cocinamingle.feature.recipe.detail.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.cocinamingle.feature.map.api.MapEntry
import com.cocinamingle.feature.map.api.getRoute
import com.cocinamingle.feature.recipe.detail.api.RecipeDetailEntry
import com.cocinamingle.feature.recipe.detail.api.RecipeDetailEntry.Companion.KEY_URL_DETAIL
import com.cocinamingle.feature.recipe.detail.impl.ui.RecipeDetailPage
import com.cocinamingle.navigation.Destinations
import com.cocinamingle.navigation.SnackBarAppState
import com.cocinamingle.navigation.entry
import javax.inject.Inject

class RecipeDetailEntryImpl @Inject constructor() : RecipeDetailEntry {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
        snackBarAppState: SnackBarAppState
    ) {
        RecipeDetailPage(
            urlDetail = backStackEntry.arguments?.getString(KEY_URL_DETAIL) ?: "",
            onBack = {
                navController.popBackStack()
            },
            goToMap = { title, lat, lon ->
                navController.navigate(destinations.entry<MapEntry>().getRoute(title, lat, lon))
            }
        )
    }
}