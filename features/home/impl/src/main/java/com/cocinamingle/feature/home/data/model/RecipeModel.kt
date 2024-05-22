package com.cocinamingle.feature.home.data.model

data class RecipeModel(
    val image: String,
    val title: String,
    val ingredientsQuantity: Int,
    val calories: Double,
    val detailUrl: String
)

fun Hit.toRecipeModel(): RecipeModel {
    return RecipeModel(
        image = recipe.image,
        title = recipe.label,
        ingredientsQuantity = recipe.ingredients.size,
        calories = recipe.calories,
        detailUrl = links.self.href
    )
}