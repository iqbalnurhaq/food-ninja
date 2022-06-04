package com.nurhaq.food.ui.pages.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.nurhaq.food.R
import com.nurhaq.food.navigation.Screen
import com.nurhaq.food.ui.parts.onBoarding

@Composable
fun PageSecondOnboarding(
    navController: NavHostController
) {
    onBoarding(
        modifier = Modifier
            .fillMaxSize(),
        image = painterResource(id = R.drawable.second_onboarding),
        contentImage = "Illustration Second OnBoarding",
        title = "Food Ninja is Where Your\nComfort Food Lives",
        subtitle = "Enjoy a fast and smooth food delivery at\nyour doorstep",
        textButton = "Next",
        onClick = {
            navController.navigate(Screen.Login.route)
        }
    )
}