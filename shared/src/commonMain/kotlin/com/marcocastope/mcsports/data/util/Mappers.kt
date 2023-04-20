package com.marcocastope.mcsports.data.util

import com.marcocastope.mcsports.data.LeagueRemote
import com.marcocastope.mcsports.domain.entities.League

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