package com.miniclip.matchsimulator.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miniclip.matchsimulator.data.repository.UpdateMatchAndStandingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FullScreenViewModel @Inject constructor(
    private val useCase: UpdateMatchAndStandingsUseCase
) : ViewModel() {

    // Used to show a loader above the app content
    val showLoader: StateFlow<Boolean> = useCase.showLoader

    fun hideLoaderAndHandleMatch() {
        viewModelScope.launch {
            useCase.hideLoaderAndHandleMatch()
        }
    }
}