package com.marcocastope.mcsports.domain.usecases

import com.marcocastope.mcsports.domain.entities.LiveScore
import com.marcocastope.mcsports.domain.repository.SportsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetLivesScoreUseCase : KoinComponent {
    private val repository: SportsRepository by inject()

    suspend operator fun invoke(): List<LiveScore> {
        return repository.getLivesScore()
    }
}