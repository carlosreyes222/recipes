package com.cocinamingle.design_system.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class Dimensions(
    val spacing1: Dp,
    val spacing2: Dp,
    val spacing3: Dp,
    val spacing4: Dp,
    val spacing5: Dp,
    val spacing6: Dp,
    val spacing8: Dp,
    val viewSize: ViewSize,
    val elevation: Elevation
)

@Immutable
class ViewSize(
    val viewSize10: Dp,
    val viewSize20: Dp,
    val viewSize32: Dp,
    val viewSize100: Dp,
    val viewSize152: Dp,
    val viewSize250: Dp,
    val viewSize300: Dp,
    val viewSize400: Dp,
)

@Immutable
class Elevation(
    val elevation0: Dp,
    val elevation1: Dp,
    val elevation2: Dp,
    val elevation3: Dp,
    val elevation4: Dp,
)

internal val defaultElevation = Elevation(
    elevation0 = 0.dp,
    elevation1 = 2.dp,
    elevation2 = 4.dp,
    elevation3 = 6.dp,
    elevation4 = 8.dp,
)

internal val defaultViewSize = ViewSize(
    viewSize10 = 10.dp,
    viewSize20 = 20.dp,
    viewSize32 = 32.dp,
    viewSize100 = 100.dp,
    viewSize152 = 152.dp,
    viewSize250 = 250.dp,
    viewSize300 = 300.dp,
    viewSize400 = 400.dp,
)


internal val defaultDimensions = Dimensions(
    spacing1 = 2.dp,
    spacing2 = 4.dp,
    spacing3 = 6.dp,
    spacing4 = 8.dp,
    spacing5 = 10.dp,
    spacing6 = 12.dp,
    spacing8 = 16.dp,
    viewSize = defaultViewSize,
    elevation = defaultElevation
)
