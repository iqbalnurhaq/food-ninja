package com.nurhaq.food.ui.pages.auth

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.nurhaq.food.R
import com.nurhaq.food.ui.components.ButtonInput
import com.nurhaq.food.ui.components.ButtonLogin
import com.nurhaq.food.ui.components.InputText
import com.nurhaq.food.ui.theme.Black
import com.nurhaq.food.ui.theme.TealGradient
import com.nurhaq.food.ui.theme.Transparent
import com.nurhaq.food.ui.theme.White


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PageLogin(
    navController: NavHostController
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp - 71.dp
    val buttonWidth = screenWidth / 2
    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxHeight()
    ) {
       Column(
           modifier = Modifier
               .fillMaxHeight()
               .verticalScroll(rememberScrollState())
       ) {
           Box(
               modifier = Modifier.height(380.dp)
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
               Box(
                   modifier = Modifier.fillMaxSize()
               ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 47.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo Login",
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
           Text(
               modifier = Modifier
                   .fillMaxWidth()
                   .offset(y = (-12).dp)
                   .padding(bottom = 40.dp),
               text = "Login To Your Account",
               style = MaterialTheme.typography.h3,
               textAlign = TextAlign.Center
           )
           InputText(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(57.dp),
               placeholder = "Email",
               onValueChange = {},
               coroutineScope = coroutineScope,
           )
           Spacer(modifier = Modifier.height(12.dp))
           InputText(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(57.dp),
               onValueChange = {},
               placeholder = "Password",
               coroutineScope = coroutineScope,
           )
           Spacer(modifier = Modifier.height(20.dp))
           Text(
               text = "Or Continue With",
               color = Black,
               style = MaterialTheme.typography.h6,
               modifier = Modifier.fillMaxWidth(),
               textAlign = TextAlign.Center
           )
           Spacer(modifier = Modifier.height(20.dp))
           Column(
               modifier = Modifier
                   .padding(horizontal = 25.dp)
                   .fillMaxWidth()
           ) {
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween
               ) {
                   ButtonLogin(
                       text = "Facebook",
                       color = White,
                       icon = R.drawable.ic_facebook,
                       iconDes = "Icon Facebook",
                       modifier = Modifier
                           .height(57.dp)
                           .width(buttonWidth)
                           .fillMaxWidth()
                   )

                   ButtonLogin(
                       text = "Google",
                       icon = R.drawable.ic_google,
                       color = White,
                       iconDes = "Icon Google",
                       modifier = Modifier
                           .height(57.dp)
                           .width(buttonWidth)
                           .fillMaxWidth()
                   )
               }
               Image(
                   painter = painterResource(id = R.drawable.ic_forgot_password_text),
                   contentDescription = "forgot password text",
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 20.dp)
               )
               Spacer(modifier = Modifier.height(36.dp))
               ButtonInput(
                   modifier = Modifier
                       .width(157.dp)
                       .height(57.dp)
                       .align(Alignment.CenterHorizontally),

                   text = "Login",
                   onClick = {
                       navController.navigate(route = "register")
                   },
               )
               Spacer(modifier = Modifier.height(80.dp))
           }

       }
    }
}