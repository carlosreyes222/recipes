package com.cocinamingle.feature.home

import com.cocinamingle.navigation.AppNavRoute
import com.cocinamingle.navigation.ComposableFeatureEntry

interface HomeEntry : ComposableFeatureEntry {

    override val featureRoute: String
        get() = AppNavRoute.HOME.route
}