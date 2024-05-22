package com.cocinamingle.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface AggregateFeatureEntry : FeatureEntry {

    fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations,
        snackBarAppState: SnackBarAppState,
    )
}