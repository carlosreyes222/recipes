package com.cocinamingle.feature.map.impl

import com.cocinamingle.feature.map.api.MapEntry
import com.cocinamingle.navigation.FeatureEntry
import com.cocinamingle.navigation.FeatureEntryKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapModule {

    @Binds
    @IntoMap
    @Singleton
    @FeatureEntryKey(MapEntry::class)
    abstract fun bindMapEntry(impl: MapEntryImpl): FeatureEntry
}
