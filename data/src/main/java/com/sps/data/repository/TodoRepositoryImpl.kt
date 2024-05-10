package com.sps.data.repository

import com.sps.data.datastore.TodoDataStore
import com.sps.data.db.TodoItem
import com.sps.domain.entity.TodoItemModel
import com.sps.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class TodoRepositoryImpl @Inject constructor(private val dataStore: TodoDataStore) : TodoRepository{

    override suspend fun getAllTodos(): Flow<List<TodoItemModel>>  = flow { dataStore.getAllTodoItems() }

    override suspend fun insertTodoItem(itemName: String)  = dataStore.insertTodoItem(TodoItem(title = itemName))
}