package com.sps.domain

import com.sps.domain.entity.TodoItemModel
import com.sps.domain.repository.TodoRepository
import com.sps.domain.usecase.GetAllTodoUseCase
import com.sps.domain.usecase.GetAllTodoUseCaseImpl
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GetAllTodoUseCaseImplTest {

    private lateinit var sut: GetAllTodoUseCaseImpl

    private val todoRepository = mock<TodoRepository>()

    private val todoUiItemModel = mock<TodoItemModel>()

    @Before
    fun setup() {
        sut = GetAllTodoUseCaseImpl(
            todoRepository
        )
    }

    @Test
    fun `verify get all todo is invoke`() = runTest {
        val expectedTodoList = listOf(todoUiItemModel)
        whenever(todoRepository.getAllTodos()).doReturn(flow { emit( expectedTodoList)})
        sut.invoke()
        verify(todoRepository).getAllTodos()

    }
}