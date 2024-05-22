package com.cocinamingle.feature.home.data.datasource

import com.cocinamingle.feature.home.data.model.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("v2/")
    suspend fun getNewRecipes(@Query("q") query: String): Response<RecipeResponse>
}