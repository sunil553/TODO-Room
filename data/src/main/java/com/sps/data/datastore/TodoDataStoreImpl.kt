package com.sps.data.datastore

import com.sps.data.db.TodoDao
import com.sps.data.db.TodoItem
import com.sps.data.mapper.TodoDomainMapper
import com.sps.domain.entity.TodoItemModel
import javax.inject.Inject

internal class TodoDataStoreImpl @Inject constructor(private val todoDoa: TodoDao
    ) : TodoDataStore {
    override suspend fun getAllTodoItems(): List<TodoItemModel> {
        return TodoDomainMapper.buildDomainMapper(todoItem = todoDoa.getAllTodos())
    }

    override suspend fun insertTodoItem(todoItem: TodoItem) {
        todoDoa.insert(todoItem)
    }
}