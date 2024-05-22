package com.cocinamingle.navigation

inline fun <reified T : FeatureEntry> Destinations.entry(): T =
    findOrNull() ?: error("Unable to find '${T::class.java} destination.")

inline fun <reified T : FeatureEntry> Destinations.findOrNull(): T? =
    this[T::class.java] as? T
