package com.marcocastope.mcsports.android.ui.home

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.marcocastope.mcsports.android.R
import com.marcocastope.mcsports.android.data.DataMock
import com.marcocastope.mcsports.android.ui.composables.CustomAsyncImage
import com.marcocastope.mcsports.android.ui.composables.MatchItem
import com.marcocastope.mcsports.domain.entities.LiveScore
import com.marcocastope.mcsports.domain.entities.Match

@Composable
fun HomeScreen(paddingValues: PaddingValues, state: HomeUiState) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        item {
            HomeSection(title = "Live Matches") {
                if (state.loading)
                    Box(
                        modifier = Modifier
                            .height(190.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = Color.Green, strokeWidth = 5.dp)
                    }
                else
                    LiveMatchesSection(livesScore = state.livesScore) {}
            }
        }

        item {
            HomeSection(title = "Matches") {}
        }
        matches(matches = state.matches, matchSelection = {})
    }
}

@Composable
fun HomeSection(title: String, content: @Composable () -> Unit) {
    Column(modifier = Modifier.padding(top = 32.dp)) {
        Text(
            text = title,
            fontWeight = FontWeight.W700,
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 16.dp, bottom = 10.dp)
        )
        content()
    }
}

@Composable
fun LiveMatchesSection(livesScore: List<LiveScore>, livesScoreSelection: (LiveScore) -> Unit) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
        content = {
            items(livesScore) {
                LiveMatchItem(liveScore = it, liveScoreSelection = livesScoreSelection)
            }
        })
}

@Composable
fun MatchesSection(matches: List<Match>, matchSelection: (Match) -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(matches) {
                MatchItem(match = it, leagueSelected = matchSelection)
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xff03ff89))
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = liveScore.leagueName ?: "",
                    fontWeight = FontWeight.W400,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.width(200.dp)
                )

                if (liveScore.eventLive.contains("1")) {
                    val scaling = rememberInfiniteTransition()
                    val scale by scaling.animateFloat(
                        initialValue = 1f,
                        targetValue = 1.5f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(1000),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xFFFF2928))
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_circle_24),
                            contentDescription = "",
                            modifier = Modifier
                                .scale(scale = scale)
                                .padding(end = 2.dp)
                                .size(10.dp)
                        )
                        Text(
                            text = "Live",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500
                        )
                    }
                }
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
        CustomAsyncImage(imageUrl = imageUrl)

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

private fun LazyListScope.matches(matches: List<Match>, matchSelection: (Match) -> Unit) {
    items(matches) {
        MatchItem(match = it, leagueSelected = matchSelection)
    }
}

@Preview
@Composable
fun HomeSectionPreview() {
    LiveMatchItem(
        liveScore = DataMock.liveScore, liveScoreSelection = {})
}