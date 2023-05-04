package com.androidmvi.domain.usecase.main

import com.androidmvi.presentation.ui.intent.main.MainActivityIntent
import com.androidmvi.presentation.ui.viewstate.main.MainActivityState
import javax.inject.Inject

// We implement our business logic here and return the value
class MainActivityUseCase @Inject constructor() {
    fun processIntent(intent: MainActivityIntent): MainActivityState {
        return when (intent) {
            is MainActivityIntent.LoadData -> { MainActivityState.ShowLoading }
            is MainActivityIntent.FinishLoading -> { MainActivityState.HideLoadingDialog }
        }
    }
}
