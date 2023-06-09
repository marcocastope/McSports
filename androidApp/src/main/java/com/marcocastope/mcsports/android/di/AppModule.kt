package com.marcocastope.mcsports.android.di

import com.marcocastope.mcsports.android.ui.home.HomeViewModel
import com.marcocastope.mcsports.android.ui.livescore.LiveScoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { LiveScoreViewModel(get()) }
}