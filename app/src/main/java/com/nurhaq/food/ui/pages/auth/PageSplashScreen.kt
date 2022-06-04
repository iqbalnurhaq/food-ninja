package com.nurhaq.food.ui.pages.auth

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.food.R
import com.nurhaq.food.navigation.Screen
import com.nurhaq.food.ui.theme.Transparent
import com.nurhaq.food.ui.theme.White
import kotlinx.coroutines.delay


@Composable
fun PageSplashScreen(navController: NavHostController) {

    var startAnimation by remember { mutableStateOf(false)}
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1 = true) {7
        startAnimation = true
        delay(1500)
        navController.popBackStack()
        navController.navigate(Screen.FirstOnboarding.route)
    }

    Surface(
        color = MaterialTheme.colors.background
    ) {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val systemUiController: SystemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(Transparent)
        systemUiController.setNavigationBarColor(Transparent)
        systemUiController.setSystemBarsColor(Transparent)
        systemUiController.isNavigationBarVisible = false


        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier.height(330.dp)

            ) {

                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Background",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    Pair(0.8f, Transparent),
                                    Pair(1f, White)
                                )
                            )
                        )
                )
            }

            Column(
                modifier = Modifier.fillMaxSize().alpha(alpha = alphaAnim.value) ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_text_logo),
                    contentDescription = "Text Logo"
                )
                Text(
                    text = "Deliver Favorite Food",
                    style = MaterialTheme.typography.h6
                )
            }

        }
    }
}