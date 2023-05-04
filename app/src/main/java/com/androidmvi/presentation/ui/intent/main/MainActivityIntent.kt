package com.androidmvi.presentation.ui.intent.main

// Here we define all our user intents
sealed class MainActivityIntent {
    object LoadData : MainActivityIntent()
    object FinishLoading : MainActivityIntent()
}
