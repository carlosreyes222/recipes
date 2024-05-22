package com.cocinamingle.feature.recipe.detail.impl.data.usecase

import com.cocinamingle.feature.recipe.detail.impl.data.model.RecipeDetailModel
import com.cocinamingle.feature.recipe.detail.impl.domain.repository.RecipeDetailRepository
import com.cocinamingle.feature.recipe.detail.impl.domain.usecase.GetRecipeDetailUC
import javax.inject.Inject

class GetRecipeDetailUCImpl @Inject constructor(
    private val recipeDetailRepository: RecipeDetailRepository
) : GetRecipeDetailUC {

    override suspend fun invoke(url: String): Result<RecipeDetailModel> {
        return recipeDetailRepository.getRecipeDetail(url)
    }
}