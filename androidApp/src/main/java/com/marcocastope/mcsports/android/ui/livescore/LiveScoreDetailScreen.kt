package com.marcocastope.mcsports.android.ui.livescore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcocastope.mcsports.android.ui.composables.MatchDetailCard
import com.marcocastope.mcsports.domain.entities.LiveScore
import org.koin.androidx.compose.koinViewModel

typealias OnBackPressed = () -> Unit

@Composable
fun LiveScoreDetailScreen(
    viewModel: LiveScoreViewModel = koinViewModel(),
    matchId: String?,
    onBackPressed: OnBackPressed
) {
    viewModel.getLiveScoreDetail(matchId ?: "")

    val liveScore = viewModel.detailUiState.liveScore

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = liveScore?.let { Arrangement.Top } ?: Arrangement.Center

    ) {
        liveScore?.let {
            TopDetails(leagueName = it.leagueName ?: "", onBackPressed)
            MatchDetailCard(liveScore = it)
            StatisticContent(
                liveScore = it,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
            )
        } ?: run {
            CircularProgressIndicator(
                color = Color.Green,
                strokeWidth = 5.dp
            )
        }
    }
}

@Composable
fun TopDetails(leagueName: String, onBackPressed: OnBackPressed) {
    Box(
        Modifier
            .padding(bottom = 32.dp)
            .height(56.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {
            IconButton(onClick = { onBackPressed() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 48.dp, end = 16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = leagueName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W700,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun StatisticContent(liveScore: LiveScore, modifier: Modifier = Modifier) {
    Card(shape = RoundedCornerShape(20.dp), elevation = 10.dp, modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = "Statistics Match", fontWeight = FontWeight.W500, fontSize = 14.sp)
            liveScore.statistics.forEach {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = it.home,
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp
                    )
                    Text(
                        text = it.type,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF797979)
                    )
                    Text(
                        text = it.away,
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TopDetailsPreview() {
    TopDetails(leagueName = "Ligue 1") {
        
    }
}
