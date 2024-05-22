package com.cocinamingle.feature.map.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.cocinamingle.feature.map.api.MapEntry
import com.cocinamingle.feature.map.api.MapEntry.Companion.KEY_LAT
import com.cocinamingle.feature.map.api.MapEntry.Companion.KEY_LON
import com.cocinamingle.feature.map.api.MapEntry.Companion.KEY_TITLE
import com.cocinamingle.feature.map.impl.ui.MapPage
import com.cocinamingle.navigation.Destinations
import com.cocinamingle.navigation.SnackBarAppState
import javax.inject.Inject

class MapEntryImpl @Inject constructor() : MapEntry {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
        snackBarAppState: SnackBarAppState
    ) {
        MapPage(
            lat = backStackEntry.arguments?.getString(KEY_LAT)?.toDouble() ?: 0.0,
            log = backStackEntry.arguments?.getString(KEY_LON)?.toDouble() ?: 0.0,
            title = backStackEntry.arguments?.getString(KEY_TITLE).orEmpty(),
            onBack = {
                navController.popBackStack()
            },
        )
    }
}