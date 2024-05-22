package com.cocinamingle.feature.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.cocinamingle.feature.home.ui.HomePage
import com.cocinamingle.navigation.AppNavRoute
import com.cocinamingle.navigation.Destinations
import com.cocinamingle.navigation.SnackBarAppState
import javax.inject.Inject

class HomeEntryImpl @Inject constructor() : HomeEntry {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
        snackBarAppState: SnackBarAppState
    ) {
        HomePage(
            goToRecipeDetail = { url ->
                navController.navigate(
                    AppNavRoute.RECIPE_DETAIL.route + "?$KEY_URL_DETAIL_ARG={$KEY_URL_DETAIL}".replace(
                        oldValue = "{$KEY_URL_DETAIL}",
                        newValue = url
                    )
                )
            }
        )
    }

    companion object {
        const val KEY_URL_DETAIL_ARG = "url_detail_arg"
        const val KEY_URL_DETAIL = "url_detail"
    }
}