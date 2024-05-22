package com.cocinamingle.design_system.molecule

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.cocinamingle.design_system.R
import com.cocinamingle.design_system.theme.CocinaMingleTheme
import kotlinx.coroutines.Dispatchers

@Composable
@Suppress("LongParameterList")
fun DSAsyncImage(
    imageUrl: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = 0.dp,
    borderSize: Dp? = null,
    borderColor: Color? = null,
    contentScale: ContentScale = ContentScale.Fit,
    @DrawableRes placeholderRes: Int = R.drawable.ic_not_image,
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .dispatcher(Dispatchers.IO)
            .build(),
        contentScale = contentScale
    )

    // If there's an error state when loading the image.
    if (painter.state is AsyncImagePainter.State.Error || painter.state is AsyncImagePainter.State.Empty) {
        ErrorBoxImage(
            drawableResId = placeholderRes,
            elevation = elevation,
            contentDescription = contentDescription,
            shape = shape,
            modifier = modifier,
            borderColor = borderColor,
            borderSize = borderSize
        )
    } else {
        // The image is successful loaded.
        Surface(
            modifier = modifier,
            shape = shape,
            shadowElevation = elevation,
            border = if (borderSize != null && borderColor != null) {
                BorderStroke(borderSize, color = borderColor)
            } else {
                null
            }
        ) {
            Image(
                modifier = Modifier.clip(shape),
                painter = painter,
                contentDescription = contentDescription,
                contentScale = contentScale
            )
        }

    }
}

@Composable
private fun ErrorBoxImage(
    @DrawableRes drawableResId: Int,
    elevation: Dp,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    borderSize: Dp? = null,
    borderColor: Color? = null,
) {
    Surface(
        modifier = modifier,
        color = CocinaMingleTheme.colors.background,
        shape = shape,
        shadowElevation = elevation,
        border = if (borderSize != null && borderColor != null) {
            BorderStroke(borderSize, color = borderColor)
        } else {
            null
        }
    ) {
        Image(
            modifier = Modifier.padding(CocinaMingleTheme.dimens.spacing3),
            painter = painterResource(id = drawableResId),
            contentDescription = contentDescription
        )
    }
}

@Preview
@Composable
fun PreviewDSAsyncImageError() {
    CocinaMingleTheme {
        DSAsyncImage(
            modifier = Modifier.size(CocinaMingleTheme.dimens.viewSize.viewSize152),
            imageUrl = "no-valid-url",
            shape = RoundedCornerShape(8.dp),
            contentDescription = null
        )
    }
}