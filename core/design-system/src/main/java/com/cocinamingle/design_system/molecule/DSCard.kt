package com.cocinamingle.design_system.molecule

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.cocinamingle.design_system.theme.CocinaMingleTheme

@Composable
fun DSCard(
    modifier: Modifier,
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(
        containerColor = CocinaMingleTheme.colors.background,
        contentColor = CocinaMingleTheme.colors.contentB,
        disabledContentColor = CocinaMingleTheme.colors.onPrimary,
        disabledContainerColor = CocinaMingleTheme.colors.contentD
    ),
    elevation: CardElevation = CardDefaults.cardElevation(
        defaultElevation = CocinaMingleTheme.dimens.elevation.elevation3,
    ),
    border: BorderStroke? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        content = content
    )
}