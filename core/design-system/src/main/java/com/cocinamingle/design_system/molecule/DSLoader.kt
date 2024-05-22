package com.cocinamingle.design_system.molecule

import androidx.annotation.RawRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.cocinamingle.design_system.R
import com.cocinamingle.design_system.theme.CocinaMingleTheme

@Composable
fun DSLoader(
    modifier: Modifier = Modifier,
    alpha: Float = 0.8f,
    @RawRes resId: Int = R.raw.lottie_loader,
    backgroundColor: Color = CocinaMingleTheme.colors.contentE,
) {
    DSBaseLoader(
        modifier = modifier.fillMaxSize(),
        resId = resId,
        alpha = alpha,
        backgroundColor = backgroundColor,
    )
}

@Composable
fun DSBaseLoader(
    modifier: Modifier = Modifier,
    alpha: Float = 0.8f,
    @RawRes resId: Int,
    backgroundColor: Color = CocinaMingleTheme.colors.contentE,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(resId))

    Box(
        modifier = modifier
            .clickable(false) { /* Nothing */ }
            .background(backgroundColor.copy(alpha = alpha)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .clickable(false) { /* Nothing */ }
                .background(backgroundColor.copy(alpha = alpha)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                modifier = Modifier.size(CocinaMingleTheme.dimens.viewSize.viewSize300),
                composition = composition,
                iterations = LottieConstants.IterateForever,
            )
        }

    }
}

