package com.sps.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sps.todo.screens.AddToScreen
import com.sps.todo.screens.LoadSplashScreen
import com.sps.todo.screens.MainScreen

/**
 * define navigation to be routed
 *
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoadSplashScreen.route) {
        composable(route = Screen.LoadSplashScreen.route){
            LoadSplashScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            MainScreen(navController)
        }
        composable(route = Screen.AddTodoScreen.route){
            AddToScreen(navController = navController)
        }
    }
}

/**
 * define navigation routes
 *
 * @property route
 */
sealed class Screen(val route : String) {
    data object AddTodoScreen : Screen("add_screen")
    data object HomeScreen : Screen("home_screen")
    data object LoadSplashScreen : Screen("splash_screen")

}

/**
 * Custom Event LifeCycle Event Listener
 *
 * @param OnEvent
 */
@Composable
fun AppEventListener(OnEvent : (event : Lifecycle.Event) -> Unit){
    val eventHandler = rememberUpdatedState(newValue = OnEvent)
    val lifecycleOwner =  rememberUpdatedState(newValue = LocalLifecycleOwner.current)
    DisposableEffect(lifecycleOwner.value) {
        val lifecycle = lifecycleOwner.value.lifecycle

        val observer = LifecycleEventObserver{source, event ->
            eventHandler.value(event)
        }
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
}