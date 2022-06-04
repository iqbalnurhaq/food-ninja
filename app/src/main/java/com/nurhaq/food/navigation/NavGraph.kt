package com.nurhaq.food.navigation

import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nurhaq.food.ui.pages.auth.PageFirstOnboarding
import com.nurhaq.food.ui.pages.auth.PageLogin
import com.nurhaq.food.ui.pages.auth.PageSecondOnboarding
import com.nurhaq.food.ui.pages.auth.PageSplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination =Screen.Login.route
    ) {
        composable(
            route = Screen.Splash.route
        ){
            PageSplashScreen(navController)
        }
        composable(
            route = Screen.FirstOnboarding.route
        ){
            PageFirstOnboarding(navController)
        }
        composable(
            route = Screen.SecondOnboarding.route
        ){
            PageSecondOnboarding(navController)
        }
        composable(
            route = Screen.Login.route
        ){
            PageLogin(navController)
        }
    }
}