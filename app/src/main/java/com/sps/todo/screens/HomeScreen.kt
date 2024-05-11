package com.sps.todo.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.sps.domain.entity.TodoItemModel
import com.sps.todo.R
import com.sps.todo.navigation.AppEventListener
import com.sps.todo.navigation.Screen
import com.sps.todo.viewmodel.TodoViewModel


/**
 * initial launch screen that display all items available in DB
 *
 */
@Composable
fun MainScreen(navController: NavController) {
    val viewModel: TodoViewModel = hiltViewModel()
    Scaffold(
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.title),
            )
        }, floatingActionButton = { AppFloatingActionButton(navController) }
    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            AppEventListener {
                when (it) {
                    Lifecycle.Event.ON_RESUME -> {
                        viewModel.getAllTodo()
                    } else -> {

                    }

                }
            }
            val collectAsState = viewModel.uiState.collectAsState()
            if (collectAsState.value.isEmpty()){
                ShowTodoText()
            } else {
                TodoList(collectAsState.value)
            }

        }
    }

}

/**
 * shows this text if no items are in the list
 *
 */
@Composable
fun ShowTodoText() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.description),
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center),
                textAlign = TextAlign.Center
            )
        }
    }

}

/**
 * displays all  items in the lazy column
 *
 * @param todoList
 */
@Composable
fun TodoList(todoList : List<TodoItemModel> ) {
    LazyColumn {
        itemsIndexed(items = todoList) {index, item ->
            TodoItemUI(item)
        }
    }
}

/**
 * renders list view
 *
 * @param todoModel
 */
@Composable
fun TodoItemUI(todoModel: TodoItemModel){
    Card(modifier = Modifier
        .padding(9.dp)
        .fillMaxWidth(),
        border = BorderStroke(0.1.dp, Color.Black)
    ) {
        Surface {
            Row {
                Column(verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight()
                        .weight(0.4f)) {
                    TodoItemTextMedium(todoModel.item)
                }
            }
        }

    }

}

@Composable
fun TodoItemTextMedium(name : String) {
    Text(text = name,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(2.dp))

}



@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppToolbar(toolbarTitle : String) {
    TopAppBar(title = {
        NormalTextComponent(value = toolbarTitle)
    } , colors =
    TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer))
}

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 20.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.black),
        textAlign = TextAlign.Center
    )
}


@Composable
fun AppFloatingActionButton(navController: NavController) {
    androidx.compose.material3.FloatingActionButton(
        onClick = { navController.navigate(Screen.AddTodoScreen.route) },
        shape = MaterialTheme.shapes.extraSmall,
        containerColor = Color.LightGray
    ) {
        Icon(Icons.Filled.Add,"")
    }


}

@Composable
fun SimpleCircularProgressComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        CircularProgressIndicator(
            modifier = Modifier.padding(16.dp),
            color = colorResource(id = R.color.black),
            strokeWidth = Dp(value = 4F)
        )
    }
}
