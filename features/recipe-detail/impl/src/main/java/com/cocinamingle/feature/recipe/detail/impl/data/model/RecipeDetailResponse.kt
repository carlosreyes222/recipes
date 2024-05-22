package com.cocinamingle.feature.recipe.detail.impl.data.model

import com.google.gson.annotations.SerializedName

data class RecipeDetailResponse(
    @SerializedName("recipe") val recipe: Recipe
)

data class Recipe(
    @SerializedName("uri") val uri: String,
    @SerializedName("label") val label: String,
    @SerializedName("image") val image: String,
    @SerializedName("images") val images: Images,
    @SerializedName("source") val source: String,
    @SerializedName("url") val url: String,
    @SerializedName("shareAs") val shareAs: String,
    @SerializedName("yield") val yield: Double,
    @SerializedName("dietLabels") val dietLabels: List<String>,
    @SerializedName("healthLabels") val healthLabels: List<String>,
    @SerializedName("cautions") val cautions: List<String>,
    @SerializedName("ingredientLines") val ingredientLines: List<String>,
    @SerializedName("ingredients") val ingredients: List<Ingredient>,
    @SerializedName("calories") val calories: Double,
    @SerializedName("totalCO2Emissions") val totalCO2Emissions: Double,
    @SerializedName("co2EmissionsClass") val co2EmissionsClass: String,
    @SerializedName("totalWeight") val totalWeight: Double,
    @SerializedName("totalTime") val totalTime: Double,
    @SerializedName("cuisineType") val cuisineType: List<String>,
    @SerializedName("mealType") val mealType: List<String>,
    @SerializedName("dishType") val dishType: List<String>,
    @SerializedName("totalNutrients") val totalNutrients: TotalNutrients,
    @SerializedName("totalDaily") val totalDaily: TotalDaily,
    @SerializedName("digest") val digest: List<Digest>
)

data class Images(
    @SerializedName("THUMBNAIL") val thumbnail: ImageDetails,
    @SerializedName("SMALL") val small: ImageDetails,
    @SerializedName("REGULAR") val regular: ImageDetails,
    @SerializedName("LARGE") val large: ImageDetails
)

data class ImageDetails(
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int
)

data class Ingredient(
    @SerializedName("text") val text: String,
    @SerializedName("quantity") val quantity: Double,
    @SerializedName("measure") val measure: String?,
    @SerializedName("food") val food: String,
    @SerializedName("weight") val weight: Double,
    @SerializedName("foodCategory") val foodCategory: String?,
    @SerializedName("foodId") val foodId: String,
    @SerializedName("image") val image: String?
)

data class TotalNutrients(
    @SerializedName("ENERC_KCAL") val energy: Nutrient,
    @SerializedName("FAT") val fat: Nutrient,
    @SerializedName("FASAT") val saturatedFat: Nutrient,
    @SerializedName("FATRN") val transFat: Nutrient,
    @SerializedName("FAMS") val monounsaturatedFat: Nutrient,
    @SerializedName("FAPU") val polyunsaturatedFat: Nutrient,
    @SerializedName("CHOCDF") val carbs: Nutrient,
    @SerializedName("CHOCDF.net") val netCarbs: Nutrient,
    @SerializedName("FIBTG") val fiber: Nutrient,
    @SerializedName("SUGAR") val sugars: Nutrient,
    @SerializedName("PROCNT") val protein: Nutrient,
    @SerializedName("CHOLE") val cholesterol: Nutrient,
    @SerializedName("NA") val sodium: Nutrient,
    @SerializedName("CA") val calcium: Nutrient,
    @SerializedName("MG") val magnesium: Nutrient,
    @SerializedName("K") val potassium: Nutrient,
    @SerializedName("FE") val iron: Nutrient,
    @SerializedName("ZN") val zinc: Nutrient,
    @SerializedName("P") val phosphorus: Nutrient,
    @SerializedName("VITA_RAE") val vitaminA: Nutrient,
    @SerializedName("VITC") val vitaminC: Nutrient,
    @SerializedName("THIA") val thiamin: Nutrient,
    @SerializedName("RIBF") val riboflavin: Nutrient,
    @SerializedName("NIA") val niacin: Nutrient,
    @SerializedName("VITB6A") val vitaminB6: Nutrient,
    @SerializedName("FOLDFE") val folate: Nutrient,
    @SerializedName("FOLFD") val folateFood: Nutrient,
    @SerializedName("FOLAC") val folicAcid: Nutrient,
    @SerializedName("VITB12") val vitaminB12: Nutrient,
    @SerializedName("VITD") val vitaminD: Nutrient,
    @SerializedName("TOCPHA") val vitaminE: Nutrient,
    @SerializedName("VITK1") val vitaminK: Nutrient,
    @SerializedName("Sugar.alcohol") val sugarAlcohol: Nutrient,
    @SerializedName("WATER") val water: Nutrient
)

data class Nutrient(
    @SerializedName("label") val label: String,
    @SerializedName("quantity") val quantity: Double,
    @SerializedName("unit") val unit: String
)

data class TotalDaily(
    @SerializedName("ENERC_KCAL") val energy: DailyNutrient,
    @SerializedName("FAT") val fat: DailyNutrient,
    @SerializedName("FASAT") val saturatedFat: DailyNutrient,
    @SerializedName("CHOCDF") val carbs: DailyNutrient,
    @SerializedName("FIBTG") val fiber: DailyNutrient,
    @SerializedName("PROCNT") val protein: DailyNutrient,
    @SerializedName("CHOLE") val cholesterol: DailyNutrient,
    @SerializedName("NA") val sodium: DailyNutrient,
    @SerializedName("CA") val calcium: DailyNutrient,
    @SerializedName("MG") val magnesium: DailyNutrient,
    @SerializedName("K") val potassium: DailyNutrient,
    @SerializedName("FE") val iron: DailyNutrient,
    @SerializedName("ZN") val zinc: DailyNutrient,
    @SerializedName("P") val phosphorus: DailyNutrient,
    @SerializedName("VITA_RAE") val vitaminA: DailyNutrient,
    @SerializedName("VITC") val vitaminC: DailyNutrient,
    @SerializedName("THIA") val thiamin: DailyNutrient,
    @SerializedName("RIBF") val riboflavin: DailyNutrient,
    @SerializedName("NIA") val niacin: DailyNutrient,
    @SerializedName("VITB6A") val vitaminB6: DailyNutrient,
    @SerializedName("FOLDFE") val folate: DailyNutrient,
    @SerializedName("VITB12") val vitaminB12: DailyNutrient,
    @SerializedName("VITD") val vitaminD: DailyNutrient,
    @SerializedName("TOCPHA") val vitaminE: DailyNutrient,
    @SerializedName("VITK1") val vitaminK: DailyNutrient
)

data class DailyNutrient(
    @SerializedName("label") val label: String,
    @SerializedName("quantity") val quantity: Double,
    @SerializedName("unit") val unit: String
)

data class Digest(
    @SerializedName("label") val label: String,
    @SerializedName("tag") val tag: String,
    @SerializedName("schemaOrgTag") val schemaOrgTag: String?,
    @SerializedName("total") val total: Double,
    @SerializedName("hasRDI") val hasRDI: Boolean,
    @SerializedName("daily") val daily: Double,
    @SerializedName("unit") val unit: String,
    @SerializedName("sub") val sub: List<SubDigest>?
)

data class SubDigest(
    @SerializedName("label") val label: String,
    @SerializedName("tag") val tag: String,
    @SerializedName("schemaOrgTag") val schemaOrgTag: String?,
    @SerializedName("total") val total: Double,
    @SerializedName("hasRDI") val hasRDI: Boolean,
    @SerializedName("daily") val daily: Double,
    @SerializedName("unit") val unit: String
)

data class Links(
    @SerializedName("self") val self: Link
)

data class Link(
    @SerializedName("href") val href: String,
    @SerializedName("title") val title: String
)
