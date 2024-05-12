package com.sps.data.mapper

import com.sps.data.db.TodoItem
import com.sps.domain.entity.TodoUiItemModel

object TodoDomainMapper {

    fun buildDomainMapper(todoItem: List<TodoItem>) : List<TodoUiItemModel> {
        val todoUiItemModelList = mutableListOf<TodoUiItemModel>()
        todoUiItemModelList.addAll(todoItem.map { TodoUiItemModel(it.title) })
        return todoUiItemModelList
    }

}
