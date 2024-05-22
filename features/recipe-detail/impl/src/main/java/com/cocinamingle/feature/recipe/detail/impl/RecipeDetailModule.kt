package com.cocinamingle.feature.recipe.detail.impl

import com.cocinamingle.feature.recipe.detail.api.RecipeDetailEntry
import com.cocinamingle.feature.recipe.detail.impl.data.datasource.RecipeDetailApi
import com.cocinamingle.feature.recipe.detail.impl.data.repository.RecipeDetailRepositoryImpl
import com.cocinamingle.feature.recipe.detail.impl.data.usecase.GetRecipeDetailUCImpl
import com.cocinamingle.feature.recipe.detail.impl.domain.repository.RecipeDetailRepository
import com.cocinamingle.feature.recipe.detail.impl.domain.usecase.GetRecipeDetailUC
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
abstract class RecipeDetailModule {

    @Binds
    @IntoMap
    @Singleton
    @FeatureEntryKey(RecipeDetailEntry::class)
    abstract fun bindRecipeDetailEntry(impl: RecipeDetailEntryImpl): FeatureEntry

    @Binds
    @Singleton
    abstract fun bindRecipeDetailRepository(impl: RecipeDetailRepositoryImpl): RecipeDetailRepository

    @Binds
    @Singleton
    abstract fun bindGetRecipeDetailUC(impl: GetRecipeDetailUCImpl): GetRecipeDetailUC

}

@Module
@InstallIn(SingletonComponent::class)
class RecipeDetailModuleApi {

    @Provides
    @Singleton
    fun provideRecipeDetailApi(retrofit: Retrofit): RecipeDetailApi {
        return retrofit.create(RecipeDetailApi::class.java)
    }
}