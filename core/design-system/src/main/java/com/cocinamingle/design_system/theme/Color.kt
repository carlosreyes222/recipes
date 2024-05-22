package com.cocinamingle.design_system.theme

import androidx.compose.ui.graphics.Color

internal val LightColorScheme = CocinaMingleLightColors()

class CocinaMingleLightColors : CocinaMingleCoreColor()

@Suppress("LongParameterList")
abstract class CocinaMingleColor(
    val info: Color,
    val error: Color,
    val success: Color,
    val warning: Color,
    val primary: Color,
    val onPrimary: Color,
    val primaryVariant: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryVariant: Color,
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryVariant: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val disable: Color,
    val contentA: Color,
    val contentB: Color,
    val contentC: Color,
    val contentD: Color,
    val contentE: Color,
)

object Tokens {

    const val PRIMARY = 0xffFF6347
    const val SECONDARY = 0xFFFFD700
    const val TERTIARY = 0xFF32CD32
    const val PRIMARY_VARIANT = 0xffFF4500
    const val SECONDARY_VARIANT = 0xFFFFC700
    const val TERTIARY_VARIANT = 0xFF228B22
    const val BACKGROUND = 0xFFFFFFFF
    const val SURFACE = 0xffF5F5F5
    const val ON_SURFACE = 0xFF000000
    const val INFO = 0xff1E90FF
    const val ERROR = 0xFFFF4500
    const val SUCCESS = 0xff32CD32
    const val WARNING = 0xFFFFA500
    const val DISABLED = 0xFFA9A9A9

    const val NEUTRAL_10 = 0xFFF0F0F0
    const val NEUTRAL_20 = 0xffD3D3D3
    const val NEUTRAL_30 = 0xffA9A9A9
    const val NEUTRAL_50 = 0xFF696969
    const val NEUTRAL_100 = 0xff000000
}

open class CocinaMingleCoreColor : CocinaMingleColor(
    info = Color(Tokens.INFO),
    error = Color(Tokens.ERROR),
    success = Color(Tokens.SUCCESS),
    warning = Color(Tokens.WARNING),
    primary = Color(Tokens.PRIMARY),
    onPrimary = Color(Tokens.NEUTRAL_100),
    primaryVariant = Color(Tokens.PRIMARY_VARIANT),
    secondary = Color(Tokens.SECONDARY),
    onSecondary = Color(Tokens.NEUTRAL_20),
    secondaryVariant = Color(Tokens.SECONDARY_VARIANT),
    tertiary = Color(Tokens.TERTIARY),
    onTertiary = Color(Tokens.NEUTRAL_20),
    tertiaryVariant = Color(Tokens.TERTIARY_VARIANT),
    background = Color(Tokens.BACKGROUND),
    onBackground = Color(Tokens.NEUTRAL_100),
    surface = Color(Tokens.SURFACE),
    onSurface = Color(Tokens.ON_SURFACE),
    disable = Color(Tokens.DISABLED),
    contentA = Color(Tokens.NEUTRAL_100),
    contentB = Color(Tokens.NEUTRAL_50),
    contentC = Color(Tokens.NEUTRAL_30),
    contentD = Color(Tokens.NEUTRAL_20),
    contentE = Color(Tokens.NEUTRAL_10),
)
