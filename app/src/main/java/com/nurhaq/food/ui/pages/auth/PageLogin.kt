package com.nurhaq.food.ui.pages.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.nurhaq.food.R
import com.nurhaq.food.ui.theme.Transparent
import com.nurhaq.food.ui.theme.White


@Composable
fun PageLogin(
    navController: NavHostController
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
       Column(
           modifier = Modifier.fillMaxSize()
       ) {
           Box(
               modifier = Modifier.height(330.dp)
           ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Background Login",
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
       }
    }
}