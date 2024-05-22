package com.cocinamingle.design_system.organism.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cocinamingle.design_system.molecule.DSText
import com.cocinamingle.design_system.theme.CocinaMingleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSTopBar(
    title: (@Composable () -> Unit),
    modifier: Modifier = Modifier,
    centerTitle: Boolean = false,
    actions: @Composable RowScope.() -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
    backgroundColor: Color = CocinaMingleTheme.colors.primary,
    contentColor: Color = CocinaMingleTheme.colors.contentE,
) {
    val topBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = backgroundColor,
        titleContentColor = contentColor,
        actionIconContentColor = contentColor,
        navigationIconContentColor = contentColor,
        scrolledContainerColor = backgroundColor
    )

    if (centerTitle) {
        CenterAlignedTopAppBar(
            title = title,
            modifier = modifier,
            colors = topBarColors,
            actions = actions,
            navigationIcon = navigationIcon
        )
    } else {
        TopAppBar(
            title = title,
            modifier = modifier,
            colors = topBarColors,
            actions = actions,
            navigationIcon = navigationIcon
        )
    }
}

@Preview("TopBar without icons")
@Composable
internal fun PreviewTopBarWithoutIcons() {
    CocinaMingleTheme(darkTheme = false) {
        DSTopBar(
            title = {
                DSText(
                    text = "This is a nice title",
                    textStyle = CocinaMingleTheme.typography.labelLarge,
                    color = CocinaMingleTheme.colors.contentB,
                )
            }
        )
    }
}

@Preview("TopBar with center icon")
@Composable
internal fun PreviewTopBarWithCenterIcon() {
    CocinaMingleTheme(darkTheme = false) {
        DSTopBar(
            title = {
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.Person, "shopping_cart")
                }
            },
            centerTitle = true
        )
    }
}

@Preview("TopBar with navigationIcon and actions")
@Composable
internal fun PreviewTopBarWithIcons() {
    CocinaMingleTheme(darkTheme = false) {
        DSTopBar(
            title = {
                DSText(
                    text = "This is a nice title",
                    textStyle = CocinaMingleTheme.typography.labelLarge,
                )
            },
            centerTitle = true,
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.ArrowBack, "back")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.ShoppingCart, "shopping_cart")
                }
            }
        )
    }
}