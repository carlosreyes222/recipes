package com.cocinamingle.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.TextUnit
import com.cocinamingle.design_system.R

private val OpenSansFont = FontFamily(
    Font(R.font.opensans_regular , FontWeight.Normal),
    Font(R.font.opensans_bold, FontWeight.Bold),
    Font(R.font.opensans_extrabold, FontWeight.ExtraBold),
)

val Typography = Typography(
    titleLarge = getTextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = getTextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
    ),
    titleSmall = getTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    bodyLarge = getTextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = getTextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    ),
    bodySmall = getTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    ),
    labelLarge = getTextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    ),
    labelMedium = getTextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    labelSmall = getTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),

)

private fun getTextStyle(
    fontSize: TextUnit,
    fontWeight: FontWeight,
    lineHeight: TextUnit = 0.0.sp,
    letterSpacing: TextUnit = 0.0.sp,
): TextStyle {
    return TextStyle(
        fontWeight = fontWeight,
        fontSize = fontSize,
        fontFamily = OpenSansFont,
        letterSpacing = letterSpacing,
        lineHeight = lineHeight
    )
}