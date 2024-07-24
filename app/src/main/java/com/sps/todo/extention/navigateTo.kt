package com.sps.todo.extention

import androidx.navigation.NavController

fun NavController.navigateTo(fromRoute : String, toRoute : String, isInclusive : Boolean) {
    this.navigate(fromRoute){
        popUpTo(route = toRoute) { inclusive = isInclusive }
    }
}

