package com.nurhaq.food

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Paint
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.food.navigation.SetupNavGraph
import com.nurhaq.food.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {

            FoodTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
//                Surface(
//                    color = MaterialTheme.colors.background
//                ) {
//                    SplashScreen()
//                }

                SetupNavGraph(navController = navController)

            }
        }
    }
}



