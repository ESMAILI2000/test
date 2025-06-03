package com.enet.sinar.ui.view.student.login

import android.content.Context
import android.graphics.Path.Direction
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.R
import com.enet.sinar.ui.theme.SinarTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    var numberOfStudy by remember { mutableStateOf(TextFieldValue("")) }
    var collageName by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize(1f)
    ) {

        Column(
            Modifier
                .align(Alignment.Center)
                .padding(20.dp),
            Arrangement.spacedBy(16.dp)
        ) {
            val image = painterResource(R.drawable.ic_logo)
            Image(
                painter = image, contentDescription = "logo",
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(165.dp)
                    .padding(top = 48.dp, start = 20.dp, end = 20.dp)
            )
            Box(modifier = Modifier
                .padding(bottom = 100.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxHeight(1f)
                .background(color = Color.White)
                .align(Alignment.CenterHorizontally)){
                Column(
                    Modifier,
                    Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "ورود",
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 10.dp),
                        fontSize = 34.sp
                    )
                    Column(
                        Modifier.padding(top = 10.dp),
                        Arrangement.spacedBy(8.dp)
                    ) {

                        Row(
                            Modifier
//                            .align(Alignment.TopCenter)
                                .fillMaxWidth(1f)
                                .padding(top = 0.dp, start = 10.dp, end = 10.dp)
                                .size(0.dp, 50.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(MaterialTheme.colorScheme.tertiary),
                            Arrangement.SpaceEvenly,
                            Alignment.CenterVertically
                        ) {

                            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                                TextField(
                                    numberOfStudy,
                                    onValueChange = { numberOfStudy = it },
                                    Modifier
                                        .padding(start = 0.dp)
                                        .fillMaxHeight()
                                        .weight(1f),
                                    placeholder = {
                                        Text(
                                            text = "شماره دانشجویی",
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                    },
                                    textStyle = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight(400)
                                    ),
                                    colors = TextFieldDefaults.colors().copy(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedTextColor = Color.White,
                                        unfocusedTextColor = Color.White,
                                        focusedPlaceholderColor = Color.White,
                                        unfocusedPlaceholderColor = Color.White,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent
                                    ),
                                    singleLine = true
                                )
                            }
                        }
                        Row(
                            Modifier
//                            .align(Alignment.TopCenter)
                                .fillMaxWidth(1f)
                                .padding(top = 0.dp, start = 10.dp, end = 10.dp)
                                .size(0.dp, 50.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(MaterialTheme.colorScheme.tertiary),
                            Arrangement.SpaceEvenly,
                            Alignment.CenterVertically
                        ) {
                            Box(
                                Modifier.size(50.dp, 50.dp)
                            ) {
                                Icon(
                                    painterResource(R.drawable.vc_contact),
                                    contentDescription = "Search",
                                    Modifier.size(50.dp, 50.dp),
                                    tint = Color.White,
                                )
                            }
                            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                                TextField(
                                    collageName,
                                    onValueChange = { collageName = it },
                                    Modifier
                                        .padding(start = 0.dp)
                                        .fillMaxHeight()
                                        .weight(1f),
                                    placeholder = {
                                        Text(
                                            text = "نام دانشگاه",
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                    },
                                    textStyle = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight(400)
                                    ),
                                    colors = TextFieldDefaults.colors().copy(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedTextColor = Color.White,
                                        unfocusedTextColor = Color.White,
                                        focusedPlaceholderColor = Color.White,
                                        unfocusedPlaceholderColor = Color.White,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent
                                    ),
                                    singleLine = true
                                )
                            }
                        }
                        Row(
                            Modifier
//                            .align(Alignment.TopCenter)
                                .fillMaxWidth(1f)
                                .padding(top = 0.dp, start = 10.dp, end = 10.dp)
                                .size(0.dp, 50.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(MaterialTheme.colorScheme.tertiary),
                            Arrangement.SpaceEvenly,
                            Alignment.CenterVertically
                        ) {
                            Box(
                                Modifier
                                    .size(50.dp, 50.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .padding(4.dp)
                            ) {
                                Icon(
                                    painterResource(R.drawable.vc_contact),
                                    contentDescription = "Search",
                                    Modifier
                                        .size(50.dp, 50.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(MaterialTheme.colorScheme.secondary),
                                    tint = Color.White,
                                )
                            }
                            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                                TextField(
                                    password,
                                    onValueChange = { password = it },
                                    Modifier
                                        .padding(start = 0.dp)
                                        .fillMaxHeight()
                                        .weight(1f),
                                    placeholder = {
                                        Text(
                                            text = "رمز عبور",
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                    },
                                    textStyle = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight(400)
                                    ),
                                    colors = TextFieldDefaults.colors().copy(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedTextColor = Color.White,
                                        unfocusedTextColor = Color.White,
                                        focusedPlaceholderColor = Color.White,
                                        unfocusedPlaceholderColor = Color.White,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent
                                    ),
                                    singleLine = true
                                )
                            }
                        }
                    }
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        Row(
                            Modifier.align(Alignment.End)
                        ) {
                            Text(
                                text = " رمز عبور خود را فراموش کرده اید؟ ",
                                Modifier
                                    .padding(top = 0.dp, start = 20.dp),
                                style = TextStyle(
                                    fontSize = 8.sp
                                )
                            )
                            Text(
                                text = "بازیابی رمز عبور",
                                Modifier
                                    .padding(top = 0.dp, end = 0.dp),
                                color = MaterialTheme.colorScheme.secondary,
                                style = TextStyle(
                                    fontSize = 8.sp,
                                    textDecoration = TextDecoration.Underline
                                )
                            )
                        }

                    }
                }
                Button(
                    onClick = {
                        //
                    },
                    Modifier
                        .padding(bottom = 40.dp)
                        .align(Alignment.BottomCenter)
                        .size(100.dp,30.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonColors(
                        MaterialTheme.colorScheme.primary,
                        Color(0xFFFFFFFF),
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.primary
                    ),
                ) {
                    Text(
                        "ورود",
//                        Modifier.fillMaxSize(1f),
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                }
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    Row(
                        Modifier.align(Alignment.BottomCenter)
                            .padding(bottom = 20.dp)
                    ) {
                        Text(
                            text = " اکانت ندارید؟ ",
                            Modifier
                                .padding(top = 0.dp, start = 0.dp),
                            style = TextStyle(
                                fontSize = 8.sp
                            )
                        )
                        Text(
                            text = "ثبت نام کنید",
                            Modifier
                                .padding(top = 0.dp, end = 0.dp),
                            color = MaterialTheme.colorScheme.secondary,
                            style = TextStyle(
                                fontSize = 8.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    }

                }
            }


        }

        Text(
            text = "ورژن 1.0.0",
            Modifier
                .padding(bottom = 16.dp, end = 0.dp)
                .align(Alignment.BottomCenter),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 8.sp
        )
    }



    }


fun logged() {

}

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=309dp,height=688dp,dpi=480"
)
@Composable
fun LoginPreview() {
    SinarTheme {
        LoginScreen()
    }
}