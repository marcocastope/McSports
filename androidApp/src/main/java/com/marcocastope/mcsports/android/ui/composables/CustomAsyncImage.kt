package com.marcocastope.mcsports.android.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.marcocastope.mcsports.android.R

@Composable
fun CustomAsyncImage(imageUrl: String?, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl ?: R.drawable.ic_shield_24)
            .crossfade(true)
            .build(),
        placeholder = painterResource(id = R.drawable.ic_shield_24),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = modifier.size(50.dp)
    )
}