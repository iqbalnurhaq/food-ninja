package com.nurhaq.food.ui.pages.auth

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.food.R
import com.nurhaq.food.navigation.Screen
import com.nurhaq.food.ui.components.ButtonInput
import com.nurhaq.food.ui.parts.onBoarding


@Composable
fun PageFirstOnboarding(
    navController: NavHostController
) {

    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isNavigationBarVisible = true
    onBoarding(
        modifier = Modifier
            .fillMaxSize(),
        image = painterResource(id = R.drawable.first_onboarding),
        contentImage = "Illustration First OnBoarding",
        title = "Find your Comfort \nFood here",
        subtitle = "Here You Can find a chef or dish for every\ntaste and color. Enjoy!",
        textButton = "Next",
        onClick = {
            navController.navigate(Screen.SecondOnboarding.route)
        }
    )
}