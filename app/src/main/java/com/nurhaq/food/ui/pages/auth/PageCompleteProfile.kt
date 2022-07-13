package com.nurhaq.food.ui.pages.auth

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nurhaq.food.R
import com.nurhaq.food.ui.components.ButtonInput
import com.nurhaq.food.ui.components.InputText

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PageCompleteProfile(
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Box(

            ) {
                Image(
                    painter = painterResource(id = R.drawable.second_background),
                    contentDescription = "Second background",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                
                Box {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = 55.dp,
                                start = 14.dp,
                                end = 14.dp
                            )
                    ) {

                        Column(
                            modifier = Modifier
                                .padding(horizontal = 11.dp)
                                .fillMaxWidth()
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.ic_icon_back),
                                contentDescription = "Arrow Back"
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "Fill in your bio to get\nstarted",
                                style = MaterialTheme.typography.h1
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "This data will be displayed in your account\nprofile for security",
                                style = MaterialTheme.typography.body2
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        InputText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            placeholder = "First Name",
                            onValueChange = {  }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        InputText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            placeholder = "Last Name",
                            onValueChange = {  }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        InputText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            placeholder = "Mobile Number",
                            onValueChange = {  }
                        )

                        Spacer(modifier = Modifier.height(180.dp))

                        ButtonInput(
                            modifier = Modifier
                                .width(157.dp)
                                .height(57.dp)
                                .align(alignment = CenterHorizontally),

                            text = "Next",
                            onClick = {
                                navController.navigate(route = "register")
                            },
                        )
                        Spacer(modifier = Modifier.height(50.dp))
                    }
                }
            }
        }
    }
}