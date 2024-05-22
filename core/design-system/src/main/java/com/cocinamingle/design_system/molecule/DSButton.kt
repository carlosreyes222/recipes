package com.cocinamingle.design_system.molecule

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cocinamingle.design_system.theme.CocinaMingleTheme

@Composable
fun DSPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: @Composable () -> Unit = {},
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    FactoryButton(
        modifier = modifier,
        text = text,
        icon = icon,
        onClick = onClick,
        enabled = enabled,
        backgroundColor = CocinaMingleTheme.colors.primaryVariant,
        contentColor = CocinaMingleTheme.colors.onPrimary,
        textColor = if (enabled) CocinaMingleTheme.colors.background else CocinaMingleTheme.colors.contentE,
    )
}

@Composable
@Suppress("LongParameterList")
internal fun FactoryButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: @Composable () -> Unit = {},
    onClick: () -> Unit,
    enabled: Boolean = true,
    contentColor: Color,
    textColor: Color,
    backgroundColor: Color,
    elevation: ButtonElevation = ButtonDefaults.elevatedButtonElevation(CocinaMingleTheme.dimens.elevation.elevation2)
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        shape = RoundedCornerShape(CocinaMingleTheme.dimens.spacing4),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = CocinaMingleTheme.colors.disable,
            disabledContentColor = CocinaMingleTheme.colors.onBackground
        ),
        elevation = elevation
    ) {
        icon()
        DSText(text = text, textStyle = CocinaMingleTheme.typography.bodyMedium, color = textColor)
    }
}

@Preview("Primary Button Enabled- LightTheme")
@Composable
internal fun PreviewPrimaryButtonEnabledLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSPrimaryButton(text = "Primary Button", onClick = {})
        }
    }
}

@Preview("Primary Button Disabled- LightTheme")
@Composable
internal fun PreviewPrimaryButtonLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSPrimaryButton(text = "Primary Button", onClick = {}, enabled = false)
        }
    }
}
