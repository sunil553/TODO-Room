package com.sps.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Deprecated
 *
 */
@HiltViewModel
class SplashViewModel  @Inject constructor() : ViewModel(){

    private val splashFlow = MutableStateFlow(true)
    val _splashFlow = splashFlow.asStateFlow()

    init {
        isSplashFlow()
    }

     fun isSplashFlow() {
        viewModelScope.launch {
            splashFlow.emit(true)
        }
    }
}