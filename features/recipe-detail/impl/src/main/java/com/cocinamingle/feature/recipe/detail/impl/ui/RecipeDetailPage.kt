package com.cocinamingle.feature.recipe.detail.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.cocina.mingle.features.recipe.detail.impl.R
import com.cocinamingle.design_system.molecule.DSAsyncImage
import com.cocinamingle.design_system.molecule.DSLoader
import com.cocinamingle.design_system.molecule.DSPrimaryButton
import com.cocinamingle.design_system.molecule.DSTag
import com.cocinamingle.design_system.molecule.DSText
import com.cocinamingle.design_system.template.scaffold.DSTopBarScaffold
import com.cocinamingle.design_system.theme.CocinaMingleTheme
import com.cocinamingle.feature.recipe.detail.impl.data.model.RecipeDetailModel

@Composable
fun RecipeDetailPage(
    urlDetail: String,
    onBack: () -> Unit,
    goToMap: (title: String, Double, Double) -> Unit,
    viewModel: RecipeDetailViewModel = hiltViewModel()
) {
    val state: RecipeDetailUiState by viewModel.uiState.collectAsState()
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    lifecycle.addObserver(viewModel)

    LaunchedEffect(urlDetail) {
        viewModel.getRecipeDetail(urlDetail)
    }

    Box {
        if (state.loading) DSLoader()
        DSTopBarScaffold(
            topBarNavigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.Outlined.ArrowBack, "back")
                }
            },
            title = {
                DSText(
                    text = stringResource(id = com.cocinamingle.design_system.R.string.app_name),
                    textStyle = CocinaMingleTheme.typography.titleSmall,
                    color = CocinaMingleTheme.colors.contentE
                )
            },
            topBarCenterTitle = true,
            content = { innerPadding ->
                RecipeDetailContainer(
                    Modifier.padding(top = innerPadding.calculateTopPadding()),
                    state.recipe,
                    goToMap
                )
            }
        )
    }
}

@Composable
private fun RecipeDetailContainer(
    modifier: Modifier,
    recipe: RecipeDetailModel?,
    goToMap: (title: String, Double, Double) -> Unit
) {
    Column(modifier = modifier) {
        recipe?.let {
            RecipeDetailContent(
                recipe = it,
                goToMap = goToMap
            )
        }
    }
}

@Composable
private fun RecipeDetailContent(
    recipe: RecipeDetailModel,
    goToMap: (title: String, Double, Double) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(CocinaMingleTheme.dimens.spacing4)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        DSText(
            modifier = Modifier.padding(CocinaMingleTheme.dimens.spacing2),
            text = recipe.title,
            textStyle = CocinaMingleTheme.typography.titleMedium,
            color = CocinaMingleTheme.colors.contentB,
            textAlign = TextAlign.Center
        )

        DSAsyncImage(
            modifier = Modifier.size(CocinaMingleTheme.dimens.viewSize.viewSize152),
            imageUrl = recipe.image,
            shape = RoundedCornerShape(CocinaMingleTheme.dimens.spacing4),
            contentDescription = recipe.title,
        )

        Spacer(modifier = Modifier.height(CocinaMingleTheme.dimens.spacing4))

        DSTag(tag = stringResource(id = R.string.recipe_detail_calories, recipe.calories))

        DSPrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = CocinaMingleTheme.dimens.spacing4),

            text = stringResource(id = R.string.recipe_detail_see_map),
            onClick = {
                goToMap.invoke(
                    recipe.title,
                    recipe.coordinate.latitude,
                    recipe.coordinate.longitude
                )
            })
        RecipeIngredients(recipe)
    }
}

@Composable
private fun RecipeIngredients(recipe: RecipeDetailModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = CocinaMingleTheme.dimens.spacing8)
    ) {
        HorizontalDivider(Modifier.padding(vertical = CocinaMingleTheme.dimens.spacing4))

        DSText(
            modifier = Modifier.padding(vertical = CocinaMingleTheme.dimens.spacing4),
            text = stringResource(
                id = R.string.recipe_detail_ingredients,
                recipe.ingredientLines.size
            ),
            textStyle = CocinaMingleTheme.typography.bodyMedium,
            color = CocinaMingleTheme.colors.contentB,
            textAlign = TextAlign.Center
        )

        recipe.ingredientLines.forEach { ingredient ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = CocinaMingleTheme.dimens.spacing2)
            ) {
                Box(
                    modifier = Modifier
                        .size(CocinaMingleTheme.dimens.spacing4)
                        .background(CocinaMingleTheme.colors.contentA, shape = CircleShape)
                        .padding(end = CocinaMingleTheme.dimens.spacing2)
                )

                DSText(
                    text = ingredient,
                    textStyle = CocinaMingleTheme.typography.labelSmall,
                    color = CocinaMingleTheme.colors.contentC,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = CocinaMingleTheme.dimens.spacing4)
                )
            }
        }
    }

}