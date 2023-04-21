package com.marcocastope.mcsports.data.util

import com.marcocastope.mcsports.data.LeagueRemote
import com.marcocastope.mcsports.data.LiveScoreRemote
import com.marcocastope.mcsports.domain.entities.League
import com.marcocastope.mcsports.domain.entities.LiveScore

internal fun LeagueRemote.toLeague(): League {
    return League(
        id = leagueKey,
        name = leagueName,
        countryID = countryKey,
        countryName = countryName,
        leagueLogo = leagueLogo,
        countryLogo = countryLogo
    )
}

internal fun LiveScoreRemote.toLiveScore(): LiveScore {
    return LiveScore(
        id = eventKey,
        date = eventDate,
        time = eventTime,
        homeTeam = homeTeam,
        awayTeam = awayTeam,
        homeTeamLogo = homeTeamLogo,
        awayTeamLogo = awayTeamLogo,
        leagueLogo = leagueLogo,
        leagueName = leagueName,
        leagueRound = leagueRound,
        finalResult = eventFinalResult
    )
}