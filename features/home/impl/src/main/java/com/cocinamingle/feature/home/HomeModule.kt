package com.cocinamingle.feature.home

import com.cocinamingle.feature.home.data.datasource.RecipeApi
import com.cocinamingle.feature.home.data.repository.RecipeRepositoryImpl
import com.cocinamingle.feature.home.data.usecase.GetRecipeUCImpl
import com.cocinamingle.feature.home.domain.repository.RecipeRepository
import com.cocinamingle.feature.home.domain.usecase.GetRecipeUC
import com.cocinamingle.navigation.FeatureEntry
import com.cocinamingle.navigation.FeatureEntryKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {

    @Binds
    @IntoMap
    @Singleton
    @FeatureEntryKey(HomeEntry::class)
    abstract fun bindHomeEntry(impl: HomeEntryImpl): FeatureEntry

    @Binds
    @Singleton
    abstract fun bindRecipeRepository(impl: RecipeRepositoryImpl): RecipeRepository

    @Binds
    @Singleton
    abstract fun bindGetRecipeUC(impl: GetRecipeUCImpl): GetRecipeUC


}

@Module
@InstallIn(SingletonComponent::class)
class HomeModuleApi {

    @Provides
    @Singleton
    fun provideRecipeApi(retrofit: Retrofit): RecipeApi {
        return retrofit.create(RecipeApi::class.java)
    }
}