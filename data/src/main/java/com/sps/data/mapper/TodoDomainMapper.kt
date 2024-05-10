package com.sps.data.mapper

import com.sps.data.db.TodoItem
import com.sps.domain.entity.TodoItemModel

object TodoDomainMapper {

    fun buildDomainMapper(todoItem: List<TodoItem>) : List<TodoItemModel> {
        val todoItemModelList = mutableListOf<TodoItemModel>()
        todoItemModelList.addAll(todoItem.map { TodoItemModel(it.title) })
        return todoItemModelList
    }

}
