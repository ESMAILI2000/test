package com.enet.sab.ui.view.home


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enet.sab.ui.theme.AtiselTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.enet.sab.R
import com.enet.sab.ui.theme.Blue500
import com.enet.sab.ui.theme.Gray200


@Composable
fun HomeScreen(
    onUnitsClicked: () -> Unit = {},
    onReportsClicked: () -> Unit = {},
    onContactsClicked: () -> Unit = {},
    onCoastsClicked: () -> Unit = {},
    onUsersClicked: () -> Unit = {},
    onImportClicked: () -> Unit = {},
    onAddUserClicked: () -> Unit = {},
    onAddCoastClicked: () -> Unit = {},
    onAddReportClicked: () -> Unit = {},
    onAddContactClicked: () -> Unit = {},
    onViewReportClicked: () -> Unit = {},
    modifier: Modifier = Modifier) {

    var isWeeklySelected by remember { mutableStateOf(true) }
    var MainStatus by remember { mutableStateOf(1) } // 1:home 2:users 3:reports 4:contacts 5:coasts
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("پایگاه شهید شمسی پور", "کانون نسل صالح","+")
    val selectedIndex = remember { mutableStateOf(0) }
    val selectedText = remember { mutableStateOf(items[0]) }
    
        Box(modifier.fillMaxSize()) {
            Box (
                Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 40.dp, start = 50.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Gray200),
            ) {
                Button(onClick = { expanded = true },
                    colors = ButtonColors(
                        Gray200,
                        colorResource(id = R.color.black),
                        Gray200,
                        colorResource(id = R.color.black))) {
                    Text(selectedText.value,
                        fontFamily = FontFamily(Font(R.font.roboto)))
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    items.forEachIndexed { index, item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                if(index!=2){ //تعداد مجموعه ها + 1
                                    selectedIndex.value = index
                                    expanded = false

                                }else {
                                    // ثبت مجموعه جدید
                                }
                            }
                        )
                    }
                }
            }
            Box (
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 100.dp, end = 50.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Gray200)
                    .size(42.dp, 42.dp)
                    .pointerInput(Unit) {
                        detectTapGestures {
                            onImportClicked()
                        }
                    },
            ){
                Icon(
                    painter = painterResource(R.drawable.vc_download),
                    contentDescription = "Import",
                    Modifier
//                        .padding(bottom = 8.dp, start = 4.dp)
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                        .size(32.dp),
                    tint = Blue500
                )
            }
            Row(
                Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 100.dp, start = 50.dp)
                    .background(
                        Gray200,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .size(250.dp, 50.dp)
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),

                ) {
                Button(
                    onClick = { isWeeklySelected = true },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = if (isWeeklySelected == true) R.color.white else R.color.gray_200)),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("هفتگی",
                        fontFamily = FontFamily(Font(R.font.raleway)),
                        fontSize = 16.sp,
                        color = Color.Black )
                }
                Button(
                    onClick = { isWeeklySelected = false },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = if (isWeeklySelected == false) R.color.white else R.color.gray_200)),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("ماهانه",
                        fontFamily = FontFamily(Font(R.font.raleway)),
                        fontSize = 16.sp,
                        color =  Color.Black)
                }
            }
            Box(
                Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 165.dp, start = 50.dp, end = 50.dp)
                    .fillMaxWidth(1f)
            ) {
                Box(
                    Modifier
                        .align(Alignment.CenterStart)
                        .size(150.dp, 135.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(Gray200)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onUsersClicked()
                            }
                        },
                    Alignment.Center
                ) {
                    Icon(
                        painterResource(R.drawable.vc_plus),
                        "Add User",
                        Modifier
                            .align(Alignment.TopEnd)
                            .padding(10.dp)
                            .size(32.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(colorResource(id = R.color.white))
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    onAddUserClicked()
                                }
                            },
                        tint = Blue500
                    )
                    Row(
                        Modifier
                            .align(Alignment.CenterStart)
                    ) {
                        Text(
                            " عضو جدید",
                            Modifier
                                .align(Alignment.Bottom),
                            color = Gray400,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            "12",
                            color = colorResource(id = R.color.black),
                            fontSize = 28.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                    Row(
                        Modifier
                            .align(Alignment.BottomStart)
                            .padding(10.dp)
                    ) {
                        Text(
                            "کل اعضا  ",
                            color = Gray400,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            "125",
                            color = colorResource(id = R.color.black),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                }
                Box(
                    Modifier
                        .align(Alignment.CenterEnd)
                        .size(150.dp, 135.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(colorResource(id = R.color.black))
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onCoastsClicked()
                            }
                        },
                    Alignment.Center
                ) {
                    Icon(
                        painterResource(R.drawable.vc_plus),
                        "Add Coast",
                        Modifier
                            .align(Alignment.TopEnd)
                            .padding(10.dp)
                            .size(32.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(colorResource(id = R.color.white))
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    onAddCoastClicked()
                                }
                            },
                        tint = Blue500
                    )
                    Text(
                        "5000",
                        color = Green200,
                        fontSize = 28.sp,
                        fontWeight = FontWeight(400)
                    )
                    Column(
                        Modifier.align(Alignment.BottomCenter)
                    ) {
                        Row {
                            Text(
                                "درآمد ",
                                color = colorResource(id = R.color.white),
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = FontFamily(Font(R.font.roboto))
                            )
                            Text(
                                "125000",
                                color = Green200,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400)
                            )
                        }
                        Row {
                            Text(
                                "هزینه ",
                                color = colorResource(id = R.color.white),
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = FontFamily(Font(R.font.roboto))
                            )
                            Text(
                                "120000",
                                color = Red500,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400)
                            )
                        }
                    }
                }
            }
            Box(
                Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 310.dp, start = 50.dp, end = 50.dp)
                    .fillMaxWidth(1f)
            ) {
                Box(
                    Modifier
                        .align(Alignment.CenterStart)
                        .size(150.dp, 135.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(Blue500)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onReportsClicked()
                            }
                        },
                    Alignment.Center
                ) {
                    Icon(
                        painterResource(R.drawable.vc_plus),
                        "Add Report",
                        Modifier
                            .align(Alignment.TopEnd)
                            .padding(10.dp)
                            .size(32.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(colorResource(id = R.color.white))
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    onAddReportClicked()
                                }
                            },
                        tint = Blue500
                    )
                    Row(
                        Modifier
                            .align(Alignment.CenterStart)
                    ) {
                        Text(
                            "  عضو فعال",
                            Modifier
                                .align(Alignment.Bottom),
                            color = Gray300,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            "40",
                            color = colorResource(id = R.color.white),
                            fontSize = 28.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                    Row(
                        Modifier
                            .align(Alignment.BottomStart)
                            .padding(10.dp)
                    ) {
                        Text(
                            "تعداد گزارش  ",
                            color = Gray300,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            "5",
                            color = colorResource(id = R.color.white),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                }
                Box(
                    Modifier
                        .align(Alignment.CenterEnd)
                        .size(150.dp, 135.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(Blue200)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onContactsClicked()
                            }
                        },
                    Alignment.Center
                ) {
                    Icon(
                        painterResource(R.drawable.vc_plus),
                        "Add Contect",
                        Modifier
                            .align(Alignment.TopEnd)
                            .padding(10.dp)
                            .size(32.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(colorResource(id = R.color.white))
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    onAddContactClicked()
                                }
                            },
                        tint = Blue500
                    )
                    Row(
                        Modifier
                            .align(Alignment.CenterStart)
                    ) {
                        Text(
                            " مخاطب جدید ",
                            Modifier
                                .align(Alignment.Bottom),
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            "2",
                            color = colorResource(id = R.color.black),
                            fontSize = 28.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                    Row(
                        Modifier
                            .align(Alignment.BottomStart)
                            .padding(10.dp)
                    ) {
                        Text(
                            "کل مخاطبین  ",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            "25",
                            color = colorResource(id = R.color.black),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                }
            }
            Column(
                Modifier
                    .align(Alignment.Center)
                    .padding(top = 360.dp, start = 10.dp, end = 10.dp)
                    .fillMaxWidth(1f)
                    .heightIn(0.dp, 232.dp)){
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .heightIn(0.dp, 232.dp)
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    onViewReportClicked()
                                }
                            }
                    ) {
                        Text(
                            "23",
                            Modifier
                                .padding(top = 10.dp)
                                .align(Alignment.TopStart),
                            color = Blue500,
                            fontSize = 21.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(500),
                        )

                        Column (Modifier
                            .align(Alignment.TopEnd)) {
                            Text(
                                "حلقه صالحین",
                                Modifier
                                    .padding(start = 0.dp, top = 0.dp),
                                color = Color(0xFF363636),
                                fontSize = 21.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                "1403/06/05",
                                Modifier
                                    .padding(end = 0.dp, top = 0.dp)
                                    .align(Alignment.End),
                                color = Gray400,
                                fontSize = 17.sp,
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
//                                onHomeClicked()
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
                                onContactsClicked()
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
                        contentDescription = "Contacts",
                        Modifier
                            .align(Alignment.Center),
                        tint = colorResource(id = if (MainStatus == 5) R.color.black else R.color.white)
                    )
                }
            }

        }
}


@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=309dp,height=688dp,dpi=480"
)
@Composable
fun HomePreview() {
    AtiselTheme {
        HomeScreen()
    }
}