package com.marcocastope.mcsports.android.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MatchCustomText(text: String) {
    Text(text = text, fontWeight = FontWeight.W500, fontSize = 10.sp)
}

@Composable
fun MatchCustomNameTeam(text: String, isEnd: Boolean, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.W500,
        textAlign = if (isEnd) TextAlign.Start else TextAlign.End,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontSize = 12.sp,
        modifier = modifier
            .padding(top = 2.5.dp)
            .width(70.dp)
    )
}

@Composable
fun CustomProgressIndicator() {
    CircularProgressIndicator(color = Color(0xff226cfe), strokeWidth = 5.dp)
}