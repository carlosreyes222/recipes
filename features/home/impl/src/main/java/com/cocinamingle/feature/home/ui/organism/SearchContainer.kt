package com.cocinamingle.feature.home.ui.organism

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.cocina.mingle.features.home.impl.R
import com.cocinamingle.design_system.molecule.DSLoader
import com.cocinamingle.design_system.molecule.DSText
import com.cocinamingle.design_system.theme.CocinaMingleTheme
import com.cocinamingle.feature.home.ui.SearchContentActions


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchContainer(
    actions: SearchContentActions,
    hints: Set<String>
) {
    var query by remember { mutableStateOf("") }
    var activeSearch by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = CocinaMingleTheme.dimens.spacing8)
            .height(CocinaMingleTheme.dimens.viewSize.viewSize400.takeIf { activeSearch }
                ?: CocinaMingleTheme.dimens.viewSize.viewSize100)
    ) {
        SearchBar(
            colors = SearchBarDefaults.colors(
                containerColor = CocinaMingleTheme.colors.contentE,
            ),
            modifier = Modifier
                .fillMaxWidth(),
            query = query,
            onQueryChange = {
                query = it
                actions.onSearchByQuery(it)
            },
            onSearch = {
                activeSearch = false
                actions.onSearchByQuery(it)
            },
            active = activeSearch,
            onActiveChange = {
                activeSearch = it
            },
            placeholder = {
                DSText(
                    text = stringResource(id = R.string.recipe_search_hint),
                    textStyle = CocinaMingleTheme.typography.bodySmall
                )
            },
            leadingIcon = {
                val icon = when {
                    query.isEmpty() -> Icons.Default.Search
                    else -> Icons.Default.ArrowBack
                }

                AnimatedVisibility(
                    visible = activeSearch,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Icon(
                        modifier = Modifier.clickable {
                            if (query.isNotEmpty()) {
                                query = ""
                            } else {
                                activeSearch = false
                            }
                        },
                        imageVector = icon,
                        contentDescription = null
                    )
                }
            },
            trailingIcon = {
                val icon = when {
                    query.isNotEmpty() -> Icons.Default.Clear
                    else -> null
                }
                if (icon != null) {
                    AnimatedVisibility(
                        visible = activeSearch,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Icon(
                            modifier = Modifier.clickable {
                                if (query.isNotEmpty()) {
                                    query = ""
                                } else {
                                    activeSearch = false
                                }
                            },
                            imageVector = icon,
                            contentDescription = null
                        )
                    }
                }
            }
        ) {
            hints.forEach { hint ->
                Column(
                    modifier = Modifier
                        .padding(CocinaMingleTheme.dimens.spacing4)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    DSText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(CocinaMingleTheme.dimens.spacing4)
                            .clickable {
                                activeSearch = false
                                actions.onSearchByQuery(hint)
                            },
                        text = hint,
                        textStyle = CocinaMingleTheme.typography.labelMedium,
                        color = CocinaMingleTheme.colors.contentC,
                        textAlign = TextAlign.Start
                    )
                    HorizontalDivider()
                }
            }
            if (hints.isEmpty()) {
                DSLoader()
            }
        }
    }
}