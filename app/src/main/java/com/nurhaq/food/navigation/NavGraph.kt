package com.nurhaq.food.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.nurhaq.food.ui.pages.auth.*


@OptIn(ExperimentalFoundationApi::class)
@ExperimentalAnimationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.CompleteProfile.route
    ) {
        composable(
            route = Screen.Splash.route
        ){
            PageSplashScreen(navController)
        }
        composable(
            route = Screen.FirstOnboarding.route,
            enterTransition = {
                when (initialState.destination.route) {
                    Screen.SecondOnboarding.route ->
                        slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(800))
                    else -> null
                }
            },
//            exitTransition = {
//                when (initialState.destination.route) {
//                    Screen.SecondOnboarding.route ->
//                        slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(800))
//                    else -> null
//                }
//            },
//            popEnterTransition = {
//                when (initialState.destination.route) {
//                    Screen.SecondOnboarding.route ->
//                        slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(800))
//                    else -> null
//                }
//            },
//            popExitTransition = {
//                when (initialState.destination.route) {
//                    Screen.SecondOnboarding.route ->
//                        slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(800))
//                    else -> null
//                }
//            }
        ){
            PageFirstOnboarding(navController)
        }
        composable(
            route = Screen.SecondOnboarding.route,
            enterTransition = {
                when(initialState.destination.route){
                    Screen.FirstOnboarding.route ->
                        slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(800))
                    else -> null
                }
            }
        ){
            PageSecondOnboarding(navController)
        }
        composable(
            route = Screen.Login.route
        ){
            PageLogin(navController)
        }
        composable(
            route = Screen.Register.route
        ){
            PageRegister(navController)
        }
        composable(
            route = Screen.CompleteProfile.route
        ){
            PageCompleteProfile(navController)
        }
    }
}