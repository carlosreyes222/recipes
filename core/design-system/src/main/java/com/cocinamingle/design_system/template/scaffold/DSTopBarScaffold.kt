package com.cocinamingle.design_system.template.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.cocinamingle.design_system.molecule.DSText
import com.cocinamingle.design_system.organism.topbar.DSTopBar
import com.cocinamingle.design_system.theme.CocinaMingleTheme

@Composable
fun DSTopBarScaffold(
    content: @Composable (PaddingValues) -> Unit,
    modifier: Modifier = Modifier,
    topBarCenterTitle: Boolean = false,
    title: (@Composable () -> Unit)? = null,
    topBarActions: @Composable RowScope.() -> Unit = {},
    topBarNavigationIcon: @Composable (() -> Unit)? = null,
    bottomBarContent: @Composable () -> Unit = {},
    snackBarHostState: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    backgroundColor: Color = CocinaMingleTheme.colors.primary,
) {
    Scaffold(
        topBar = {
            if (title != null) {
                DSTopBar(
                    title = title,
                    actions = topBarActions,
                    centerTitle = topBarCenterTitle,
                    navigationIcon = topBarNavigationIcon ?: {},
                    backgroundColor = backgroundColor
                )
            }
        },
        content = content,
        modifier = modifier,
        bottomBar = bottomBarContent,
        snackbarHost = snackBarHostState,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition
    )
}

@Preview("Scaffold without bottom bar")
@Composable
private fun PreviewDSTopBarScaffold() {
    CocinaMingleTheme(darkTheme = false) {
        DSTopBarScaffold(
            title = {
                DSText(
                    text = "CocinaMingle",
                    textStyle = CocinaMingleTheme.typography.labelMedium,
                )
            },
            topBarCenterTitle = true,
            topBarNavigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.ArrowBack, "back")
                }
            },
            topBarActions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.ShoppingCart, "shopping_cart")
                }
            },
            content = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    DSText(
                        text = "This a content body",
                        color = CocinaMingleTheme.colors.contentB,
                        textStyle = CocinaMingleTheme.typography.labelMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    }
}

@Preview("Scaffold with bottom bar")
@Composable
private fun PreviewDSTopBarScaffoldWithBottomBar() {
    CocinaMingleTheme(darkTheme = false) {
        DSTopBarScaffold(
            title = {
                DSText(
                    text = "CocinaMingle",
                    textStyle = CocinaMingleTheme.typography.labelMedium,
                )
            },
            topBarCenterTitle = true,
            content = {},
            bottomBarContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(CocinaMingleTheme.dimens.viewSize.viewSize32)
                        .background(CocinaMingleTheme.colors.secondaryVariant)
                ) {}
            }
        )
    }
}