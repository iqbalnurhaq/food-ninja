package com.nurhaq.food.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nurhaq.food.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.viga_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
    ),

    h4 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
    ),

    h6 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 13.sp,
    ),

    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    button = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium

    )






    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)