package com.nurhaq.food.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.nurhaq.food.ui.theme.TealGradient
import com.nurhaq.food.ui.theme.White


@Composable
fun ButtonInput(
    modifier: Modifier,
    text : String,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        shape = RoundedCornerShape(15),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .background(TealGradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.button,
                color = White
            )

        }
    }
}


@Composable
fun InputText(
    modifier: Modifier,
    onValueChange: () -> Unit
) {
    val textState = remember { mutableStateOf("") }
    TextField(
        modifier = modifier,
        value = textState.value,
        onValueChange = {},
        
    )

}

