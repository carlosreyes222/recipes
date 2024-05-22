package com.cocinamingle.design_system.molecule

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.cocinamingle.design_system.theme.CocinaMingleTheme

@Composable
fun DSInfoWidget(
    modifier: Modifier = Modifier,
    infoText: String,
    backGroundColor: Color = CocinaMingleTheme.colors.info,
    iconColor: Color = Color.Blue,
    icon: ImageVector = Icons.Outlined.Info,
    elevation: Dp = CocinaMingleTheme.dimens.elevation.elevation0
) {
    DSCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(CocinaMingleTheme.dimens.spacing4),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation,
        ),
        colors = CardDefaults.cardColors(
            containerColor = backGroundColor,
            contentColor = CocinaMingleTheme.colors.contentB,
            disabledContentColor = CocinaMingleTheme.colors.onPrimary,
            disabledContainerColor = CocinaMingleTheme.colors.disable
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CocinaMingleTheme.dimens.spacing4),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = iconColor,
                modifier = Modifier.size(CocinaMingleTheme.dimens.viewSize.viewSize20)
            )
            Spacer(modifier = Modifier.width(CocinaMingleTheme.dimens.spacing4))
            DSText(
                text = infoText,
                textStyle = CocinaMingleTheme.typography.labelMedium,
                color = CocinaMingleTheme.colors.contentB
            )
        }
    }
}