package com.sps.todo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sps.todo.R
import com.sps.todo.viewmodel.TodoViewModel

@Composable
fun AddToScreen(navController: NavController){
    val viewModel: TodoViewModel = hiltViewModel()
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding()){
        OutlinedTextField(
            maxLines = 1,
            value = text,
            label = { Text(text = stringResource(id = R.string.add_screen_description)) },
            onValueChange = {
                text = it
            }
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Button(
            onClick = {
                viewModel.insertTodo(text.text)
                navController.navigateUp()
            } )
        {
            Text(text = stringResource(id = R.string.add_todo))
        }
    }

}

