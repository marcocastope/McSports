package com.marcocastope.mcsports.di

import com.marcocastope.mcsports.data.SportsApiService
import com.marcocastope.mcsports.data.SportsDataSource
import com.marcocastope.mcsports.data.repository.SportsRepositoryImpl
import com.marcocastope.mcsports.domain.repository.SportsRepository
import com.marcocastope.mcsports.domain.usecases.GetLeaguesUseCase
import com.marcocastope.mcsports.domain.usecases.GetLivesScoreUseCase
import com.marcocastope.mcsports.domain.usecases.GetMatchesUseCase
import com.marcocastope.mcsports.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { SportsDataSource(get(), get()) }
    factory { SportsApiService() }
}

private val ioModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<SportsRepository> { SportsRepositoryImpl(get()) }
    factory { GetLeaguesUseCase() }
    factory { GetLivesScoreUseCase() }
    factory { GetMatchesUseCase() }
}

fun getSharedModules() = listOf(dataModule, ioModule, domainModule)