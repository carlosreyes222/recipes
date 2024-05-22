package com.cocinamingle.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

interface ComposableFeatureEntry : FeatureEntry {

    fun NavGraphBuilder.composable(
        navController: NavHostController,
        destinations: Destinations,
        snackBarAppState: SnackBarAppState,
    ) {
        composable(
            route = featureRoute,
            arguments = arguments,
            content = { backStackEntry ->
                Composable(
                    navController,
                    destinations,
                    backStackEntry,
                    snackBarAppState
                )
            }
        )
    }

    @Composable
    fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
        snackBarAppState: SnackBarAppState,
    )
}
