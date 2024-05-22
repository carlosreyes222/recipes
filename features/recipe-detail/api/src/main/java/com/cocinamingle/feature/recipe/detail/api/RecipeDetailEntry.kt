package com.cocinamingle.feature.recipe.detail.api

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.cocinamingle.navigation.AppNavRoute
import com.cocinamingle.navigation.ComposableFeatureEntry

interface RecipeDetailEntry : ComposableFeatureEntry {

    override val featureRoute: String
        get() = AppNavRoute.RECIPE_DETAIL.route + "?$KEY_URL_DETAIL_ARG={$KEY_URL_DETAIL}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(KEY_URL_DETAIL) { type = NavType.StringType }
        )
    companion object {
        const val KEY_URL_DETAIL_ARG = "url_detail_arg"
        const val KEY_URL_DETAIL = "url_detail"
    }
}