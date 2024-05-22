package com.cocinamingle.feature.home.data.repository

import com.cocinamingle.feature.home.data.datasource.RecipeApi
import com.cocinamingle.feature.home.data.model.RecipeModel
import com.cocinamingle.feature.home.data.model.toRecipeModel
import com.cocinamingle.feature.home.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val remoteApi: RecipeApi
) : RecipeRepository {

    override suspend fun getNewRecipes(query: String): Result<List<RecipeModel>> {
        return try {
            val call = remoteApi.getNewRecipes(query)
            if (call.isSuccessful) {
                val response = call.body() ?: throw Throwable("")
                Result.success(response.recipes.map { it.toRecipeModel() })
            } else {
                Result.failure(
                    Throwable(
                        call.errorBody()?.charStream().toString()
                    )
                )
            }
        } catch (e: Exception) {
            Result.failure(Throwable(e.message ?: "Error de conexión"))
        }
    }
}