package com.cocinamingle.design_system.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

internal val LocalAppColors = staticCompositionLocalOf<CocinaMingleColor> {
    LightColorScheme
}

internal val LocalAppDimens = staticCompositionLocalOf {
    defaultDimensions
}

internal val LocalAppTypography = compositionLocalOf<Typography> {
    error("No typography provided, make sure to wrap all usages in CocinaMingleTheme")
}

@Composable
fun CocinaMingleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        else -> getColorScheme()
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val colors = LightColorScheme
    val typography = Typography

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides typography
    ) {
        MaterialTheme(
            colorScheme = getColorScheme(),
            typography = Typography,
            content = content
        )
    }
}

@Composable
internal fun getColorScheme(): ColorScheme {
    return lightColorScheme(
        primary = CocinaMingleTheme.colors.primary,
        secondary = CocinaMingleTheme.colors.secondary,
        background = CocinaMingleTheme.colors.background,
        onBackground = CocinaMingleTheme.colors.onBackground,
        surface = CocinaMingleTheme.colors.surface,
        onSurface = CocinaMingleTheme.colors.onSurface,
        error = CocinaMingleTheme.colors.error,
        onError = CocinaMingleTheme.colors.error.copy(alpha = 0.5F),
        onPrimary = CocinaMingleTheme.colors.onPrimary,
        onSecondary = CocinaMingleTheme.colors.onSecondary,
    )
}


object CocinaMingleTheme {
    val colors: CocinaMingleColor
        @Composable
        get() = LocalAppColors.current

    val dimens: Dimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalAppDimens.current

    val typography: Typography
        @Composable
        get() = LocalAppTypography.current
}