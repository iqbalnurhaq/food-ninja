package com.nurhaq.food.ui.components

import android.os.Build
import android.util.Log
import android.widget.Space
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.focus.*
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.imePadding
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.nurhaq.food.R
import com.nurhaq.food.ui.theme.TealGradient
import com.nurhaq.food.ui.theme.Transparent
import com.nurhaq.food.ui.theme.White
import com.nurhaq.food.ui.theme.White100
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ButtonLogin(
    text: String,
    color: Color,
    icon: Int,
    iconDes :  String,
    modifier: Modifier
) {
    Box(
            modifier = Modifier.drawColoredShadow(color = Color(0XFF5571f1))
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxSize()
                .background(White, shape = RoundedCornerShape(15.dp))
                .border(
                    width = 1.dp,
                    color = White100,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = iconDes
            )
            Spacer(modifier = Modifier.width(13.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.h5
            )
        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun InputText(
    modifier: Modifier,
    placeholder: String,
    leadingIcon: Int? = null,
    onValueChange: () -> Unit,
    coroutineScope: CoroutineScope? = null,
) {
    val textState = remember { mutableStateOf("") }
    val focusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = remember { BringIntoViewRequester()}
    val interactionSource = remember { MutableInteractionSource() }
    val interactionSourceState = interactionSource.collectIsFocusedAsState()

    val leadingIconView = @Composable {
        IconButton(
            onClick = { "" },
        ) {
            Icon(
                painter = painterResource(id = leadingIcon ?: 0),
                contentDescription = "",
                tint = Color(0xFF53E88B)
            )
        }
    }
        Box(
            modifier = Modifier
                .height(75.dp)
                .drawColoredShadow(color = Color(0XFF5571f1))
        ) {
            OutlinedTextField(
                modifier = modifier
                    .height(57.dp)
                    .background(
                        color = White,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .onFocusEvent { focusState ->
                        if (focusState.isFocused || focusState.hasFocus) {
                            coroutineScope?.launch {
                                delay(250)
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    }
                    .bringIntoViewRequester(bringIntoViewRequester),
                value = textState.value,
                onValueChange = {
                    textState.value = it
                },
                interactionSource = interactionSource,
                placeholder = {
                    Text(
                        text = placeholder,
                        color = Color.Black.copy(alpha = 0.3f),
                        style = MaterialTheme.typography.h5
                    )
                },
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    disabledIndicatorColor = Transparent,
                    backgroundColor = White,
                    cursorColor = Color.Black.copy(alpha = 0.4f),
                ),
                leadingIcon = if (leadingIcon != null) leadingIconView else null,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )

            )
        }
}


@RequiresApi(Build.VERSION_CODES.O)
fun Modifier.drawColoredShadow(
    color: Color,
    alpha: Float = 0.07f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 50.dp,
    offsetY: Dp = 26.dp,
    offsetX: Dp = 12.dp
) = this.drawBehind {
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
    }
}

