package com.cocinamingle.feature.home.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cocina.mingle.features.home.impl.R
import com.cocinamingle.design_system.molecule.DSAsyncImage
import com.cocinamingle.design_system.molecule.DSCard
import com.cocinamingle.design_system.molecule.DSText
import com.cocinamingle.design_system.theme.CocinaMingleTheme
import com.cocinamingle.feature.home.data.model.RecipeModel

@Composable
internal fun RecipeItem(recipe: RecipeModel, onClick: () -> Unit) {
    DSCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(CocinaMingleTheme.dimens.viewSize.viewSize250)
            .padding(CocinaMingleTheme.dimens.spacing6)
            .clickable(onClick = onClick),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            DSAsyncImage(
                imageUrl = recipe.image,
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(1.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.6f))
                    .padding(CocinaMingleTheme.dimens.spacing6),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                DSText(
                    text = recipe.title,
                    textStyle = CocinaMingleTheme.typography.bodyMedium,
                    color = CocinaMingleTheme.colors.contentE,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(CocinaMingleTheme.dimens.spacing4))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(CocinaMingleTheme.dimens.viewSize.viewSize10),
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        tint = CocinaMingleTheme.colors.contentD
                    )
                    Spacer(modifier = Modifier.width(CocinaMingleTheme.dimens.spacing2))
                    DSText(
                        text = stringResource(id = R.string.recipe_calories, recipe.calories),
                        textStyle = CocinaMingleTheme.typography.labelMedium,
                        color = CocinaMingleTheme.colors.contentD,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(CocinaMingleTheme.dimens.spacing2))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(CocinaMingleTheme.dimens.viewSize.viewSize10),
                        imageVector = Icons.Default.List,
                        contentDescription = null,
                        tint = CocinaMingleTheme.colors.contentD
                    )
                    Spacer(modifier = Modifier.width(CocinaMingleTheme.dimens.spacing2))
                    DSText(
                        text = stringResource(
                            id = R.string.recipe_ingredients,
                            recipe.ingredientsQuantity
                        ),
                        textStyle = CocinaMingleTheme.typography.labelMedium,
                        color = CocinaMingleTheme.colors.contentD,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}