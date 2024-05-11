package com.sps.todo.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sps.domain.entity.TodoItemModel
import com.sps.domain.usecase.GetAllTodoUseCase
import com.sps.domain.usecase.InsertTodoUseCase
import com.sps.todo.TestCoroutineRule
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class TodoViewModelTest {
    private lateinit var sut: TodoViewModel

    private val getAllTodoUseCase = mock<GetAllTodoUseCase>()
    private val insertTodoUseCase = mock<InsertTodoUseCase>()
    private val todoUiItemModel = mock<TodoItemModel>()


    @get:Rule
    val testCoroutineRule = TestCoroutineRule()


    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        sut = TodoViewModel(
            getAllTodoUseCase,
            insertTodoUseCase
        )
    }

    @Test
    fun `verify get all todo is inserted `(): Unit = runTest {
        val expectedTodoList = listOf(todoUiItemModel)
        whenever(getAllTodoUseCase()).doReturn(flow { emit( expectedTodoList)})
        sut.getAllTodo()
        verify(getAllTodoUseCase).invoke()
        Assert.assertNotNull(sut.uiState.value)
        Assert.assertEquals(expectedTodoList,sut.uiState.value)
    }

    @Test
    fun `verify insert todo`() = runTest {
        val title = "test"
        sut.insertTodo(title)
        verify(insertTodoUseCase).invoke(title)
    }
    @Test
    fun `verify error is not inserted todo`() = runTest {
        val title = "Error"
        sut.insertTodo(title)
        Assert.assertTrue(sut.errorMessage.value)
    }

}