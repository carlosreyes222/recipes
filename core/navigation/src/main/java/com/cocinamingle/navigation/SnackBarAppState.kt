package com.cocinamingle.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SnackBarAppState(
    val snackBarHostState: SnackbarHostState,
    val coroutineScope: CoroutineScope,
) {

    fun showSnackBar(message: String) {
        coroutineScope.launch {
            snackBarHostState.showSnackbar(message)
        }
    }
}

@Composable
fun rememberSnackBarAppState(
    snackBarHostState: SnackbarHostState = SnackbarHostState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) = remember(snackBarHostState, coroutineScope) {
    SnackBarAppState(
        coroutineScope = coroutineScope,
        snackBarHostState = snackBarHostState,
    )
}