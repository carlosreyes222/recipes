package com.cocinamingle.feature.recipe.detail.impl.data.datasource


import com.cocinamingle.feature.recipe.detail.impl.data.model.RecipeDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface RecipeDetailApi {

    @GET
    suspend fun getRecipeDetail(@Url url: String): Response<RecipeDetailResponse>
}