package com.marcocastope.mcsports.android.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.marcocastope.mcsports.android.R
import com.marcocastope.mcsports.android.data.DataMock
import com.marcocastope.mcsports.domain.entities.LiveScore
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(paddingValues: PaddingValues, viewModel: HomeViewModel = koinViewModel()) {
    HomeSection(title = "Live Matches", paddingValues) {
        if (viewModel.homeUiState.loading)
            Box(
                modifier = Modifier
                    .height(190.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.Green, strokeWidth = 5.dp)
            }
        else
            LiveMatchesSection(livesScore = viewModel.homeUiState.livesScore) {}
    }
}

@Composable
fun HomeSection(title: String, paddingValues: PaddingValues, content: @Composable () -> Unit) {
    Column(modifier = Modifier.padding(start = 16.dp, top = 32.dp)) {
        Text(
            text = title,
            fontWeight = FontWeight.W700,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        content()
    }
}

@Composable
fun LiveMatchesSection(livesScore: List<LiveScore>, livesScoreSelection: (LiveScore) -> Unit) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(livesScore) {
                LiveMatchItem(liveScore = it, liveScoreSelection = livesScoreSelection)
            }
        })
}

@Composable
fun LiveMatchItem(liveScore: LiveScore, liveScoreSelection: (LiveScore) -> Unit) {
    Card(
        modifier = Modifier.size(290.dp, 190.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.Green.copy(alpha = 0.3f)
            ) {
                Text(
                    text = liveScore.leagueName ?: "",
                    fontWeight = FontWeight.W400,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(5.dp)
                )
            }

            Text(
                text = liveScore.leagueRound ?: "",
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                text = liveScore.date ?: "",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
            )

            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (teamHome, score, teamAway) = createRefs()

                TeamItem(liveScore.homeTeam, imageUrl = liveScore.homeTeamLogo, modifier = Modifier
                    .padding(start = 16.dp)
                    .constrainAs(teamHome) {
                        start.linkTo(parent.start)
                        centerVerticallyTo(parent)
                    })

                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .constrainAs(score) {
                            top.linkTo(teamHome.top)
                            centerHorizontallyTo(parent)
                        }, horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = liveScore.finalResult ?: "",
                        color = Color.Black,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.W600
                    )
                }

                TeamItem(liveScore.awayTeam,
                    imageUrl = liveScore.awayTeamLogo ?: "",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .constrainAs(teamAway) {
                            end.linkTo(parent.end)
                            centerVerticallyTo(parent)
                        })
            }
        }
    }
}

@Composable
fun TeamItem(teamName: String, imageUrl: String?, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl ?: R.drawable.ic_shield_24)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.ic_shield_24),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )

        Text(
            text = teamName,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.width(100.dp)
        )

        Text(
            text = "Home",
            fontWeight = FontWeight.W500,
            fontSize = 10.sp,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
        )
    }
}

@Preview
@Composable
fun HomeSectionPreview() {
    LiveMatchItem(
        liveScore = DataMock.liveScore, liveScoreSelection = {})
}