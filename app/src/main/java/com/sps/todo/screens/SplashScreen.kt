package com.sps.todo.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.sps.todo.R
import com.sps.todo.extention.navigateTo
import com.sps.todo.navigation.Screen

@Composable
fun LoadSplashScreen(navController : NavController) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition = composition,
        progress = {
            progress
        },
    )
    if (progress == 1.0f) {
        navController.navigateTo(Screen.HomeScreen.route, toRoute = Screen.LoadSplashScreen.route , true)
    }

}