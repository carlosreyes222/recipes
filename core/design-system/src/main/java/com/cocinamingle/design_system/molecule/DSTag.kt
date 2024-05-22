package com.cocinamingle.design_system.molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.cocinamingle.design_system.theme.CocinaMingleTheme

@Composable
fun DSTag(
    tag: String,
    modifier: Modifier = Modifier,
    textColor: Color = CocinaMingleTheme.colors.contentE,
    textStyle: TextStyle = CocinaMingleTheme.typography.labelSmall,
    borderColor: Color = CocinaMingleTheme.colors.disable,
    backgroundColor: Color = CocinaMingleTheme.colors.info,
    shadowElevation: Dp = CocinaMingleTheme.dimens.elevation.elevation1,
    roundedCornerPercentage: Int = 40
) {
    DSText(
        text = tag,
        color = textColor,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textStyle = textStyle,
        modifier = modifier
            .shadow(shadowElevation, shape = RoundedCornerShape(roundedCornerPercentage))
            .border(
                CocinaMingleTheme.dimens.spacing1,
                shape = RoundedCornerShape(roundedCornerPercentage),
                color = borderColor
            )
            .background(backgroundColor, shape = RoundedCornerShape(roundedCornerPercentage))
            .padding(
                horizontal = CocinaMingleTheme.dimens.spacing5,
                vertical = CocinaMingleTheme.dimens.spacing2
            ),
        textAlign = TextAlign.Center
    )
}