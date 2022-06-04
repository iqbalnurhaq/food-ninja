package com.nurhaq.food.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object FirstOnboarding: Screen("first_onboarding")
    object SecondOnboarding: Screen("second_onboarding")
    object Login: Screen("login")
}
