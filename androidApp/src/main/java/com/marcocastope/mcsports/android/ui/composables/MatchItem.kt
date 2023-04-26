package com.marcocastope.mcsports.android.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.marcocastope.mcsports.android.data.DataMock
import com.marcocastope.mcsports.domain.entities.Match

@Composable
fun MatchItem(match: Match, leagueSelected: (Match) -> Unit) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(vertical = 19.dp, horizontal = 14.dp)
        ) {
            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                val (itemRight, itemLeft, itemCenter) = createRefs()
                TeamItemRow(
                    teamLogo = match.homeTeamLogo,
                    teamName = match.homeTeam,
                    isEnd = false,
                    modifier = Modifier.constrainAs(itemRight) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    })
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.constrainAs(itemCenter) {
                        centerVerticallyTo(parent)
                        centerHorizontallyTo(parent)
                    }) {
                    MatchCustomText(text = match.date ?: "")
                    MatchCustomText(text = match.time ?: "")
                }
                TeamItemRow(
                    teamLogo = match.awayTeamLogo,
                    teamName = match.awayTeam,
                    isEnd = true,
                    modifier = Modifier.constrainAs(itemLeft) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    })
            }
        }
    }
}

@Composable
fun TeamItemRow(
    teamLogo: String?,
    teamName: String?,
    isEnd: Boolean,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier = modifier) {
        val (image, text) = createRefs()
        CustomAsyncImage(
            imageUrl = teamLogo,
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .constrainAs(image) {
                    centerHorizontallyTo(parent)
                }
        )
        MatchCustomNameTeam(text = teamName ?: "", isEnd, modifier = Modifier.constrainAs(text) {
            if (isEnd) start.linkTo(image.end) else end.linkTo(image.start)
            centerVerticallyTo(image)
        })
    }
}

@Preview
@Composable
fun LeagueItemPreview() {
    MatchItem(match = DataMock.match, leagueSelected = {})
}