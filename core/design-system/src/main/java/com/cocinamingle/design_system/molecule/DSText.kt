package com.cocinamingle.design_system.molecule

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cocinamingle.design_system.theme.CocinaMingleTheme

@Composable
fun DSText(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    color: Color = CocinaMingleTheme.colors.onPrimary,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
    softWrap: Boolean = true,
    overflow: TextOverflow = TextOverflow.Clip
) {
    DSText(
        text = AnnotatedString(text),
        color = color,
        modifier = modifier,
        textStyle = textStyle,
        maxLines = maxLines,
        textDecoration = textDecoration,
        textAlign = textAlign,
        softWrap = softWrap,
        overflow = overflow
    )
}

@Composable
fun DSText(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    color: Color = CocinaMingleTheme.colors.onPrimary,
    textStyle: TextStyle,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
    softWrap: Boolean = true,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = textStyle,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
    )
}

@Preview("DisplayLarge - LightTheme")
@Composable
internal fun PreviewDisplayLargeLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Display Large", textStyle = CocinaMingleTheme.typography.displayLarge)
        }
    }
}

@Preview("Display Medium - LightTheme")
@Composable
internal fun PreviewDisplayMediumLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Display Medium", textStyle = CocinaMingleTheme.typography.displayMedium)
        }
    }
}

@Preview("Display Small - LightTheme")
@Composable
internal fun PreviewDisplaySmallLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Display Small", textStyle = CocinaMingleTheme.typography.displaySmall)
        }
    }
}

@Preview("Headline Large - LightTheme")
@Composable
internal fun PreviewHeadlineLargeLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Headline Large", textStyle = CocinaMingleTheme.typography.headlineLarge)
        }
    }
}

@Preview("Headline Medium - LightTheme")
@Composable
internal fun PreviewHeadlineMediumLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Headline Medium", textStyle = CocinaMingleTheme.typography.headlineMedium)
        }
    }
}

@Preview("Headline Small - LightTheme")
@Composable
internal fun PreviewHeadlineSmallLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Headline Small", textStyle = CocinaMingleTheme.typography.headlineSmall)
        }
    }
}

@Preview("Title Large - LightTheme")
@Composable
internal fun PreviewTitleLargeLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Title Large", textStyle = CocinaMingleTheme.typography.titleLarge)
        }
    }
}

@Preview("Title Medium - LightTheme")
@Composable
internal fun PreviewTitleMediumLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Title Medium", textStyle = CocinaMingleTheme.typography.titleMedium)
        }
    }
}

@Preview("Title Small - LightTheme")
@Composable
internal fun PreviewTitleSmallLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Title Small", textStyle = CocinaMingleTheme.typography.titleSmall)
        }
    }
}

@Preview("Body Large - LightTheme")
@Composable
internal fun PreviewBodyLargeLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Body Large", textStyle = CocinaMingleTheme.typography.bodyLarge)
        }
    }
}

@Preview("Body Medium - LightTheme")
@Composable
internal fun PreviewBodyMediumLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Body Medium", textStyle = CocinaMingleTheme.typography.bodyMedium)
        }
    }
}

@Preview("Label Large - LightTheme")
@Composable
internal fun PreviewLabelLargeLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Label Large", textStyle = CocinaMingleTheme.typography.labelLarge)
        }
    }
}

@Preview("Label Medium - LightTheme")
@Composable
internal fun PreviewLabelMediumLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Label Medium", textStyle = CocinaMingleTheme.typography.labelMedium)
        }
    }
}

@Preview("Label Small - LightTheme")
@Composable
internal fun PreviewLabelSmallLight() {
    CocinaMingleTheme(darkTheme = false) {
        Surface {
            DSText(text = "Label Small", textStyle = CocinaMingleTheme.typography.labelMedium)
        }
    }
}