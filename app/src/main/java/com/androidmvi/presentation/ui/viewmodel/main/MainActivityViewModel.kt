package com.androidmvi.presentation.ui.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidmvi.domain.usecase.main.MainActivityUseCase
import com.androidmvi.presentation.ui.intent.main.MainActivityIntent
import com.androidmvi.presentation.ui.viewstate.main.MainActivityState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainUseCase: MainActivityUseCase) :
    ViewModel() {

    private val _state = MutableLiveData<MainActivityState>()
    val state: LiveData<MainActivityState> = _state

    // We run our process in the background thread
    fun processIntent(intent: MainActivityIntent) {
        viewModelScope.launch(Dispatchers.Default) {
            val newState = mainUseCase.processIntent(intent)
            _state.postValue(newState)
        }
    }
}
