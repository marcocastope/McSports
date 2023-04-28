package com.marcocastope.mcsports.android.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcocastope.mcsports.android.data.DataMock
import com.marcocastope.mcsports.android.ui.home.TeamItem
import com.marcocastope.mcsports.domain.entities.LiveScore

@Composable
fun MatchDetailCard(liveScore: LiveScore) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = 2.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = liveScore.eventStadium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 10.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TeamItem(teamName = liveScore.homeTeam, imageUrl = liveScore.homeTeamLogo)
                Text(
                    text = "2 - 2",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(top = 5.dp)
                )
                TeamItem(teamName = liveScore.awayTeam, imageUrl = liveScore.awayTeamLogo)
            }
        }
    }
}

@Preview
@Composable
fun MatchDetailCardPreview() {
    MatchDetailCard(liveScore = DataMock.liveScore)
}