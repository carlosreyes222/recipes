package com.cocinamingle.feature.home.domain.repository

import com.cocinamingle.feature.home.data.model.RecipeModel

interface RecipeRepository {
    suspend fun getNewRecipes(query: String): Result<List<RecipeModel>>
}