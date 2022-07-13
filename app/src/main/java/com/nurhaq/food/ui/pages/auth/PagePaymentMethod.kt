package com.nurhaq.food.ui.pages.auth

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nurhaq.food.R
import com.nurhaq.food.ui.components.paymentButton


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PagePaymentMethod(
    navController: NavController
) {
    var selectState = rememberSaveable { mutableStateOf(0) }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.second_background),
                    contentDescription = "Second Background"
                )

                Box {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = 55.dp,
                                start = 20.dp,
                                end = 20.dp
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 5.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_icon_back),
                                contentDescription = "Arrow Back"
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "Payment Method",
                                style = MaterialTheme.typography.h1
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "This data will be displayed in your account\nprofile for security",
                                style = MaterialTheme.typography.body2
                            )

                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            paymentButton(
                                image = R.drawable.paypal,
                                description = "paypal image",
                                modifier = Modifier.border(width = 2.dp, color = Color.Blue, shape = RoundedCornerShape(22.dp)),
                                onClick = {

                                }
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            paymentButton(
                                image = R.drawable.visa,
                                description = "visa image",
                                modifier = Modifier,
                                onClick = {}
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            paymentButton(
                                image = R.drawable.payoneer,
                                description = "payoneer image",
                                modifier = Modifier,
                                onClick = {}
                            )
                        }
                    }
                }
            }
        }
    }
}