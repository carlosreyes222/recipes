package com.cocina.mingle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.cocinamingle.design_system.theme.CocinaMingleTheme
import com.cocinamingle.feature.home.HomeEntry
import com.cocinamingle.feature.map.api.MapEntry
import com.cocinamingle.feature.recipe.detail.api.RecipeDetailEntry
import com.cocinamingle.navigation.AppNavRoute
import com.cocinamingle.navigation.Destinations
import com.cocinamingle.navigation.SnackBarAppState
import com.cocinamingle.navigation.entry
import com.cocinamingle.navigation.rememberSnackBarAppState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var destinations: Destinations

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val snackBarAppState: SnackBarAppState = rememberSnackBarAppState()

            CocinaMingleTheme {
                Box {
                    NavHost(
                        navController = navController,
                        startDestination = AppNavRoute.HOME.route,
                    ) {
                        with(destinations.entry<HomeEntry>()) {
                            composable(navController, destinations, snackBarAppState)
                        }
                        with(destinations.entry<RecipeDetailEntry>()) {
                            composable(navController, destinations, snackBarAppState)
                        }
                        with(destinations.entry<MapEntry>()) {
                            composable(navController, destinations, snackBarAppState)
                        }
                    }
                }
            }
        }
    }
}
