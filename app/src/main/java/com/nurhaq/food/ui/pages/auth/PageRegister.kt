package com.nurhaq.food.ui.pages.auth

import android.os.Build
import android.util.Log
import android.widget.Space
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding
import com.nurhaq.food.R
import com.nurhaq.food.ui.components.ButtonInput
import com.nurhaq.food.ui.components.InputText
import com.nurhaq.food.ui.theme.Black
import com.nurhaq.food.ui.theme.TealGradient
import com.nurhaq.food.ui.theme.Transparent
import com.nurhaq.food.ui.theme.White
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PageRegister(
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth().navigationBarsWithImePadding()
                .height(LocalConfiguration.current.screenHeightDp.dp)
        ) {
            item {
                Box(
                    modifier = Modifier.height(380.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.background),
                        contentDescription = "Background register",
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
                                contentDescription = "Logo Register"
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
                    text = "Sign Up For Free",
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-12).dp)
                    ,
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center
                )

                Column{

                    InputText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(57.dp),
                        placeholder = "Anamwp . . |",
                        leadingIcon = R.drawable.ic_user,
                        onValueChange = {},
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    InputText(
                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        placeholder = "Email",
                        leadingIcon = R.drawable.ic_email,
                        onValueChange = {},
                        coroutineScope = coroutineScope,
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    InputText(
                        modifier = Modifier
                            .fillMaxWidth(),
                        placeholder = "Password",
                        onValueChange = {},
                        leadingIcon = R.drawable.ic_password,
                        coroutineScope = coroutineScope,
                    )
                    Spacer(modifier = Modifier.height(19.dp))

                    Row(
                        modifier = Modifier.padding(horizontal = 26.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .background(TealGradient, shape = RoundedCornerShape(22.dp))
                                .clip(RoundedCornerShape(22.dp))
                                .size(22.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_vector_check),
                                contentDescription = "list check",
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Keep Me Signed In",
                            style = MaterialTheme.typography.body2,
                            color = Black.copy(alpha = 0.5f)
                        )

                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier.padding(horizontal = 26.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .background(TealGradient, shape = RoundedCornerShape(22.dp))
                                .clip(RoundedCornerShape(22.dp))
                                .size(22.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_vector_check),
                                contentDescription = "list check",
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Email Me About Special Pricing",
                            style = MaterialTheme.typography.body2,
                            color = Black.copy(alpha = 0.5f)
                        )
                    }
                    Spacer(modifier = Modifier.height(44.dp))
                    ButtonInput(
                        modifier = Modifier
                            .width(175.dp)
                            .height(57.dp)
                            .align(Alignment.CenterHorizontally),
                        text = "Create Account",
                        onClick = {

                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_create_account),
                        contentDescription = "text create account",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .clickable { }
                    )
                    Spacer(modifier = Modifier.height(80.dp))

                }
            }
        }
    }
}