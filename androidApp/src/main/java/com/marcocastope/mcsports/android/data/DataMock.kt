package com.marcocastope.mcsports.android.data

import com.marcocastope.mcsports.domain.entities.League
import com.marcocastope.mcsports.domain.entities.LiveScore
import com.marcocastope.mcsports.domain.entities.Match

object DataMock {

    val liveScore = LiveScore(
        1212,
        "2023-04-20",
        "21:00",
        "AS Roma",
        "Leicester",
        "https:\\/\\/apiv2.allsportsapi.com\\/logo\\/139_roma.jpg",
        "https:\\/\\/apiv2.allsportsapi.com\\/logo\\/168_feyenoord.jpg",
        null,
        "UEFA Europa League",
        "Quarter-finals",
        "2 - 2",
        "1",
        "Nacional",
        statistics = listOf()
    )

    val league = League(
        "1",
        "Roma",
        "4",
        "Italy",
        "https:\\/\\/apiv2.allsportsapi.com\\/logo\\/logo_leagues\\/302_la-liga.png",
        "https://apiv2.allsportsapi.com/logo/logo_country/5_italy.png"
    )

    val match = Match(
        "1",
        "12-12-12",
        "20:30",
        "AS Roma",
        "Leicester",
        "3 - 1",
        "https:\\/\\/apiv2.allsportsapi.com\\/logo\\/139_roma.jpg",
        "https:\\/\\/apiv2.allsportsapi.com\\/logo\\/168_feyenoord.jpg",
    )

    val leagues = listOf(
        League(
            "1",
            "Serie Bdasdasdasdasdadadad",
            "4",
            "Italy",
            "https://storage.googleapis.com/order_now_store_bucket/product-list/product_1.png",
            "https://apiv2.allsportsapi.com/logo/logo_country/5_italy.png"
        ),
        League(
            "2",
            "Serie A",
            "4",
            "Italy",
            "https://apiv2.allsportsapi.com/logo/logo_leagues/302_la-liga.png",
            "https://apiv2.allsportsapi.com/logo/logo_country/5_italy.png"
        ),

    )
}