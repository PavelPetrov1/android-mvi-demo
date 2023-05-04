package com.androidmvi.presentation.ui.viewstate.main

// Here we define the state that should be handled after and intent has been fired
sealed class MainActivityState {
    object ShowLoading : MainActivityState()

    // We could also pass data here and use it in the activity
    object HideLoadingDialog : MainActivityState()
}
