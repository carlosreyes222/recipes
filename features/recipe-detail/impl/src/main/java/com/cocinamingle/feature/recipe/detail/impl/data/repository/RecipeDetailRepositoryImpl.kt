package com.cocinamingle.feature.recipe.detail.impl.data.repository

import com.cocinamingle.feature.recipe.detail.impl.data.datasource.RecipeDetailApi
import com.cocinamingle.feature.recipe.detail.impl.data.model.Coordinate
import com.cocinamingle.feature.recipe.detail.impl.data.model.RecipeDetailModel
import com.cocinamingle.feature.recipe.detail.impl.data.model.toRecipeDetailModel
import com.cocinamingle.feature.recipe.detail.impl.domain.repository.RecipeDetailRepository
import javax.inject.Inject
import kotlin.random.Random

class RecipeDetailRepositoryImpl @Inject constructor(
    private val remoteApi: RecipeDetailApi
) : RecipeDetailRepository {

    override suspend fun getRecipeDetail(url: String): Result<RecipeDetailModel> {
        return try {
            val call = remoteApi.getRecipeDetail(url)
            if (call.isSuccessful) {
                val response = call.body() ?: throw Throwable("")

                Result.success(
                    response.recipe.toRecipeDetailModel(
                        getRandomSouthAmericanCapitalCoordinate()
                    )
                )
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

    private fun getRandomSouthAmericanCapitalCoordinate(): Coordinate {
        val capitals = listOf(
            "Buenos Aires" to Coordinate(-34.6037, -58.3816),
            "Brasilia" to Coordinate(-15.8267, -47.9218),
            "Santiago" to Coordinate(-33.4489, -70.6693),
            "Bogotá" to Coordinate(4.7110, -74.0721),
            "Quito" to Coordinate(-0.1807, -78.4678),
            "Georgetown" to Coordinate(6.8013, -58.1551),
            "Asunción" to Coordinate(-25.2637, -57.5759),
            "Lima" to Coordinate(-12.0464, -77.0428),
            "Paramaribo" to Coordinate(5.8520, -55.2038),
            "Montevideo" to Coordinate(-34.9011, -56.1645),
            "Caracas" to Coordinate(10.4806, -66.9036),
            "La Paz" to Coordinate(-16.5000, -68.1500)
        )

        val randomIndex = Random.nextInt(capitals.size)
        return capitals[randomIndex].second
    }
}