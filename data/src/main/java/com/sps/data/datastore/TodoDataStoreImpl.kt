package com.sps.data.datastore

import com.sps.data.db.TodoDao
import com.sps.data.db.TodoItem
import com.sps.data.mapper.TodoDomainMapper
import com.sps.domain.entity.TodoItemModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class TodoDataStoreImpl @Inject constructor(private val todoDoa: TodoDao
    ) : TodoDataStore {
    override suspend fun getAllTodoItems(): List<TodoItemModel> {
        return withContext(Dispatchers.IO){
             TodoDomainMapper.buildDomainMapper(todoItem = todoDoa.getAllTodos())
        }
    }

    override suspend fun insertTodoItem(todoItem: TodoItem) {
        return withContext(Dispatchers.IO) {
            todoDoa.insert(todoItem)
        }
    }
}