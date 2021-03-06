package com.nurhaq.food.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object FirstOnboarding: Screen("first_onboarding")
    object SecondOnboarding: Screen("second_onboarding")
    object Login: Screen("login")
    object Register: Screen("register")
    object CompleteProfile: Screen("complete_profile")
    object PaymentMethod: Screen("payment_method")
}
