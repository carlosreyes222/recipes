package com.cocinamingle.feature.home.domain.usecase

import com.cocinamingle.feature.home.data.model.RecipeModel

interface GetRecipeUC {
    suspend operator fun invoke(query: String): Result<List<RecipeModel>>
}