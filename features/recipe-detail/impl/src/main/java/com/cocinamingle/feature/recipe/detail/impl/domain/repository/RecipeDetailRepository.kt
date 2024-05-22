package com.cocinamingle.feature.recipe.detail.impl.domain.repository

import com.cocinamingle.feature.recipe.detail.impl.data.model.RecipeDetailModel

interface RecipeDetailRepository {

    suspend fun getRecipeDetail(url: String): Result<RecipeDetailModel>
}