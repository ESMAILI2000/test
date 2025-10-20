package com.enet.sab.ui.view.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R
import com.enet.sab.ui.theme.AtiselTheme

@Composable
fun ContactsListScreen(
    onHomeClicked: () -> Unit = {},
    onUnitsClicked: () -> Unit = {},
    onReportsClicked: () -> Unit = {},
    onCoastsClicked: () -> Unit = {},
    onExportClicked: () -> Unit = {},
    onAddClicked: () -> Unit = {},
    onViewContactClicked: () -> Unit = {},
    modifier: Modifier = Modifier) {

    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(0) }

    var search by rememberSaveable { mutableStateOf("") }
    var MainStatus by remember { mutableStateOf(4) } // 1:home 2:users 3:reports 4:contacts 5:coast


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = "مخاطبین",
                color = Blue500,
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
            )
            Box (
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 40.dp, end = 10.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Gray200)
                    .size(42.dp, 42.dp)
                    .pointerInput(Unit) {
                        detectTapGestures {
                            onAddClicked()
                        }
                    }
            ){
                Icon(
                    painter = painterResource(R.drawable.vc_plus),
                    contentDescription = "Add Contact",
                    tint = Blue500
                )
            }
            Box (
                Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 40.dp, start = 10.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Gray200)
                    .size(42.dp, 42.dp)
                    .pointerInput(Unit) {
                        detectTapGestures {
                            onExportClicked()
                        }
                    }
            ){
                Icon(
                    painter = painterResource(R.drawable.vc_upload),
                    contentDescription = "Export Coasts",
                    Modifier
                        .padding(10.dp)
                        .fillMaxSize(1f),
                    tint = Blue500
                )
            }
            Row(
                Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth(1f)
                    .padding(top = 90.dp, start = 10.dp, end = 10.dp)
                    .size(0.dp, 50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Blue200),
                Arrangement.SpaceEvenly,
                Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    Modifier.size(76.dp, 50.dp),
                    shape = RectangleShape,
                    colors = ButtonColors(
                        Blue500,
                        Color.White,
                        Color(0xFFB0B0B0),
                        Color.White
                    )
                ) {
                    Icon(
                        painterResource(R.drawable.vc_search),
                        contentDescription = "Search",
                        tint = colorResource(id = R.color.white)
                    )
                }
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ){
                    TextField(
                        search,
                        onValueChange = { search = it },
                        Modifier
                            .padding(start = 40.dp)
                            .fillMaxHeight()
                            .weight(1f),
                        placeholder = {
                            Text(text = "عنوان مخاطب،نام،......." ,
                                color = Gray400
                            ) },
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
            Column(
                Modifier
                    .align(Alignment.Center)
                    .padding(top = 150.dp, start = 10.dp, end = 10.dp, bottom = 50.dp)
                    .verticalScroll(state)
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f)){
                repeat(20) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .heightIn(0.dp, 232.dp)
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    onViewContactClicked()
                                }
                            }
                    ) {
                        Column (
                            Modifier
                                .align(Alignment.TopEnd)) {
                            Text(
                                "محمد زندی",
                                Modifier
                                    .padding(start = 0.dp, top = 0.dp),
                                color = Color(0xFF363636),
                                fontSize = 21.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                "سخنران", // عنوان
                                Modifier.padding(end = 0.dp, top = 0.dp)
                                    .align(Alignment.End),
                                color = Gray400,
                                fontSize = 17.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(600),
                            )
                        }

                    }
                }

            }
            Row(
                Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 50.dp)
                    .background(
                        Gray500,
                        shape = RoundedCornerShape(42.dp)
                    )
                    .size(250.dp, 60.dp)
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),

                ) {
                Box (
                    Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(24.dp))
                        .background(colorResource(id = if (MainStatus == 1) R.color.white else R.color.gray_400))
                        .size(42.dp, 42.dp)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onHomeClicked()
                            }
                        },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.vc_home),
                        contentDescription = "Home",
                        Modifier
                            .align(Alignment.Center),
                        tint = colorResource(id = if (MainStatus == 1) R.color.black else R.color.white)
                    )
                }
                Box (
                    Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(24.dp))
                        .background(colorResource(id = if (MainStatus == 2) R.color.white else R.color.gray_400))
                        .size(42.dp, 42.dp)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onUnitsClicked()
                            }
                        },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.vc_users),
                        contentDescription = "Users",
                        Modifier
                            .align(Alignment.Center),
                        tint = colorResource(id = if (MainStatus == 2) R.color.black else R.color.white)
                    )
                }
                Box (
                    Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(24.dp))
                        .background(colorResource(id = if (MainStatus == 3) R.color.white else R.color.gray_400))
                        .size(42.dp, 42.dp)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onReportsClicked()
                            }
                        },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.vc_report),
                        contentDescription = "Reports",
                        Modifier
                            .align(Alignment.Center)
                            .padding(7.dp),
                        tint = colorResource(id = if (MainStatus == 3) R.color.black else R.color.white)
                    )
                }
                Box (
                    Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(24.dp))
                        .background(colorResource(id = if (MainStatus == 4) R.color.white else R.color.gray_400))
                        .size(42.dp, 42.dp)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                //
                            }
                        },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.vc_contact),
                        contentDescription = "Contacts",
                        Modifier
                            .align(Alignment.Center),
                        tint = colorResource(id = if (MainStatus == 4) R.color.black else R.color.white)
                    )
                }
                Box (
                    Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(24.dp))
                        .background(colorResource(id = if (MainStatus == 5) R.color.white else R.color.gray_400))
                        .size(42.dp, 42.dp)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onCoastsClicked()
                            }
                        },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.vc_dollar),
                        contentDescription = "Coasts",
                        Modifier
                            .align(Alignment.Center),
                        tint = colorResource(id = if (MainStatus == 5) R.color.black else R.color.white)
                    )
                }
            }

        }
    }
}

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=411dp,height=731dp,dpi=480"
)
@Composable
fun ContactsListPreview() {
    AtiselTheme {
        ContactsListScreen()
    }
}