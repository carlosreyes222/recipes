package com.cocinamingle.feature.map.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cocinamingle.design_system.molecule.DSText
import com.cocinamingle.design_system.organism.topbar.DSTopBar
import com.cocinamingle.design_system.theme.CocinaMingleTheme
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapPage(
    lat: Double,
    log: Double,
    title: String,
    onBack: () -> Unit
) {

    Column {
        DSTopBar(
            title = {
                DSText(
                    text = stringResource(id = com.cocinamingle.design_system.R.string.app_name),
                    textStyle = CocinaMingleTheme.typography.titleSmall,
                    color = CocinaMingleTheme.colors.contentE
                )
            },
            centerTitle = true,
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.Outlined.ArrowBack, "back")
                }
            }
        )

        MapPositionWidget(
            latitude = lat,
            longitude = log,
            mapMarketInfo = MapMarketInfo(title),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun MapPositionWidget(
    latitude: Double,
    longitude: Double,
    mapMarketInfo: MapMarketInfo,
    modifier: Modifier = Modifier,
    properties: MapProperties = MapProperties(
        mapType = MapType.NORMAL,
        isTrafficEnabled = false
    )
) {
    val marker = LatLng(latitude, longitude)
    val cameraState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(marker, 8f)
    }

    LaunchedEffect(marker) {
        cameraState.animate(CameraUpdateFactory.newLatLngZoom(marker, 8f))
    }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraState,
        properties = properties
    ) {
        Marker(
            state = MarkerState(position = marker),
            title = mapMarketInfo.title,
            snippet = mapMarketInfo.snippet,
            draggable = false
        )
    }
}

@Immutable
data class MapMarketInfo(val title: String, val snippet: String? = null)
