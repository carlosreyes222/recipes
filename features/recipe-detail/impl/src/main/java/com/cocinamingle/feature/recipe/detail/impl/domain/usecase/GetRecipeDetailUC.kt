package com.cocinamingle.feature.recipe.detail.impl.domain.usecase

import com.cocinamingle.feature.recipe.detail.impl.data.model.RecipeDetailModel


interface GetRecipeDetailUC {
    suspend operator fun invoke(url: String): Result<RecipeDetailModel>
}