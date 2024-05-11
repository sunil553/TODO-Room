package com.sps.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sps.domain.entity.TodoItemModel
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

    private val _uiState : MutableStateFlow<List<TodoItemModel>> = MutableStateFlow(arrayListOf())
    //    expose state to view
    val uiState: StateFlow<List<TodoItemModel>> = _uiState




    sealed class UiStates{
        data class ShowLoading(val loading : Boolean) : UiStates()
        data class Success(val data : List<TodoItemModel>) : UiStates()

    }

    init {
        getAllTodo()
    }

    fun insertTodo(title : String){
        viewModelScope.launch {
            insertTodoUseCase.invoke(title)
        }
    }
     fun getAllTodo(){
        viewModelScope.launch {
            UiStates.ShowLoading(true)
            getAllTodoUseCase.invoke().collect{ data ->
                _uiState.value = data
            }
        }
    }
}