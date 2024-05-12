package com.sps.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sps.domain.entity.TodoUiItemModel
import com.sps.domain.usecase.GetAllTodoUseCase
import com.sps.domain.usecase.InsertTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getAllTodoUseCase: GetAllTodoUseCase,
    private val insertTodoUseCase: InsertTodoUseCase
) : ViewModel() {

    private val _uiState : MutableStateFlow<List<TodoUiItemModel>> = MutableStateFlow(arrayListOf())
    //    expose state to view
    val uiState: StateFlow<List<TodoUiItemModel>> = _uiState


    private val _errorMessage : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val errorMessage: StateFlow<Boolean> = _errorMessage


    init {
        getAllTodo()
    }

    fun insertTodo(title : String) {
        viewModelScope.launch {
            if (title == "Error") {
                _errorMessage.value = true
            } else {
                insertTodoUseCase(title)
            }
        }

    }
    fun getAllTodo(){
        viewModelScope.launch {
            getAllTodoUseCase().collect{ data ->
                _uiState.emit(data)
            }
        }
    }
}