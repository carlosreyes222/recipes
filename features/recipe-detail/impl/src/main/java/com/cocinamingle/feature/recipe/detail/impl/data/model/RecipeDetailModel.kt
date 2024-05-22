package com.cocinamingle.feature.recipe.detail.impl.data.model

data class RecipeDetailModel(
    val image: String,
    val title: String,
    val ingredientLines: List<String>,
    val calories: Double,
    val coordinate: Coordinate,
)

fun Recipe.toRecipeDetailModel(coordinate: Coordinate): RecipeDetailModel {
    return RecipeDetailModel(
        image = images.thumbnail.url,
        title = label,
        ingredientLines = ingredientLines,
        calories = calories,
        coordinate = coordinate,
    )
}

data class Coordinate(val latitude: Double, val longitude: Double)
