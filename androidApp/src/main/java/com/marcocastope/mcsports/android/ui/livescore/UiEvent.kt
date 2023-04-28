package com.marcocastope.mcsports.android.ui.livescore

sealed class UiEvent{
    data class OnIdChange(val id: String) : UiEvent()
    object CardClicked : UiEvent()
}
