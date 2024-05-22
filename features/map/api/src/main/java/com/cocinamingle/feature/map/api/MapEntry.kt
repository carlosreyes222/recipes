package com.cocinamingle.feature.map.api

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.cocinamingle.feature.map.api.MapEntry.Companion.KEY_LAT
import com.cocinamingle.feature.map.api.MapEntry.Companion.KEY_LON
import com.cocinamingle.feature.map.api.MapEntry.Companion.KEY_TITLE
import com.cocinamingle.navigation.AppNavRoute
import com.cocinamingle.navigation.ComposableFeatureEntry

interface MapEntry : ComposableFeatureEntry {

    override val featureRoute: String
        get() = AppNavRoute.MAP.route + "?$KEY_LAT_ARG={$KEY_LAT}&$KEY_LON_ARG={$KEY_LON}&$KEY_TITLE_ARG={$KEY_TITLE}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(KEY_LON) { type = NavType.StringType },
            navArgument(KEY_LAT) { type = NavType.StringType },
            navArgument(KEY_TITLE) { type = NavType.StringType }
        )

    companion object {
        const val KEY_LON_ARG = "key_lon_arg"
        const val KEY_LON = "key_lon"
        const val KEY_LAT_ARG = "key_lat_arg"
        const val KEY_LAT = "key_lat"
        const val KEY_TITLE_ARG = "key_title_arg"
        const val KEY_TITLE = "key_title"
    }
}

fun MapEntry.getRoute(title: String, lat: Double, lon: Double): String {
    return featureRoute
        .replace(
            oldValue = "{${KEY_TITLE}}",
            newValue = title
        ).replace(
            oldValue = "{${KEY_LAT}}",
            newValue = lat.toString()
        ).replace(
            oldValue = "{${KEY_LON}}",
            newValue = lon.toString()
        )
}