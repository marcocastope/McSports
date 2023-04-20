package com.marcocastope.mcsports.data

import com.marcocastope.mcsports.util.Dispatcher
import kotlinx.coroutines.withContext

internal class SportsDataSource(
    private val apiService: SportsApiService,
    private val dispatcher: Dispatcher
) {

    suspend fun getLeagues() = withContext(dispatcher.io) {
        apiService.getLeagues()
    }
}