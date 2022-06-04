package com.nurhaq.food.ui.parts

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nurhaq.food.R
import com.nurhaq.food.navigation.Screen
import com.nurhaq.food.ui.components.ButtonInput

@Composable
fun onBoarding(
    modifier: Modifier,
    image: Painter,
    contentImage: String,
    title: String,
    subtitle: String,
    textButton: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(56.dp))
            Image(
                painter = image,
                contentDescription = contentImage,
            )
            Spacer(modifier = Modifier.height(39.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )
            Text(
                text = subtitle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp),
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )
            ButtonInput(
                modifier = Modifier
                    .width(157.dp)
                    .height(57.dp)
                    .align(Alignment.CenterHorizontally),
                text = textButton,
                onClick = {
                    onClick()
                },
            )
        }
    }
}