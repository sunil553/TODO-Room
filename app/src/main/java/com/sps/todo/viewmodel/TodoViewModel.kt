package com.sps.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sps.domain.usecase.GetAllTodoUseCase
import com.sps.domain.usecase.InsertTodoUseCase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getAllTodoUseCase: GetAllTodoUseCase,
    private val insertTodoUseCase: InsertTodoUseCase
) : ViewModel() {


    fun insertTodo(title : String){
        viewModelScope.launch {
            insertTodoUseCase.invoke(title)
        }
    }
    fun getAllTodo(){
        viewModelScope.launch {
            getAllTodoUseCase.invoke()
        }
    }
}