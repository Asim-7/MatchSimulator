package com.miniclip.matchsimulator.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miniclip.matchsimulator.data.repository.UpdateMatchAndStandingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResetEventViewModel @Inject constructor(
    private val useCase: UpdateMatchAndStandingsUseCase
) : ViewModel() {
    fun restAll() {
        viewModelScope.launch {
            useCase.resetAll()
        }
    }
}