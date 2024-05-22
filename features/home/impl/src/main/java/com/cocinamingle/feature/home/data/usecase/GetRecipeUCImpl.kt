package com.cocinamingle.feature.home.data.usecase

import com.cocinamingle.feature.home.domain.repository.RecipeRepository
import com.cocinamingle.feature.home.domain.usecase.GetRecipeUC
import javax.inject.Inject

class GetRecipeUCImpl @Inject constructor(
    private val recipeRepository: RecipeRepository
) : GetRecipeUC {

    override suspend fun invoke(query: String) = recipeRepository.getNewRecipes(query)

}
