package com.enet.sab.ui.view.user

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enet.sab.ui.theme.AtiselTheme
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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R

@Composable
fun UsersListScreen(
    onHomeClicked: () -> Unit = {},
    onReportsClicked: () -> Unit = {},
    onContactsClicked: () -> Unit = {},
    onCoastsClicked: () -> Unit = {},
    onExportClicked: () -> Unit = {},
    onAddClicked: () -> Unit = {},
    onViewUserClicked: () -> Unit = {},
    modifier: Modifier = Modifier) {

    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(0) }

    var search by rememberSaveable { mutableStateOf("") }
    var dateBirthStart by rememberSaveable { mutableStateOf("") }
    var dateBirthEnd by rememberSaveable { mutableStateOf("") }
    var dateJoinStart by rememberSaveable { mutableStateOf("") }
    var dateJoinEnd by rememberSaveable { mutableStateOf("") }
    var MainStatus by remember { mutableStateOf(2) } // 1:home 2:users 3:reports 4:contacts
    var isSearchClick by remember { mutableStateOf(true) }
    var isFilterClick by remember { mutableStateOf(false) }
    var isSortClick by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    val context = LocalContext.current

//    val persianPickerDate = remember { mutableStateOf(PersianPickerDate()) }
//    val picker = PersianDatePickerDialog(context)
//        .setPositiveButtonString("باشه")
//        .setNegativeButton("بیخیال")
//        .setTodayButton("امروز")
//        .setTodayButtonVisible(true)
//        .setMinYear(1350)
//        .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
//        .setMaxMonth(PersianDatePickerDialog.THIS_MONTH)
//        .setMaxDay(PersianDatePickerDialog.THIS_DAY)
//        .setInitDate(1400, 4, 19)
////        .setActionTextColor(Blue500)
////        .setTypeFace(typeface)
//        .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
//        .setShowInBottomSheet(true)
//        .setListener(object : PersianPickerListener {
//        override fun onDateSelected(persianPickerDate: PersianPickerDate) {
//            dateBirthStart = persianPickerDate.persianLongDate
//        }
//        override fun onDismissed() {}
//    })
//    dateBirthStart = persianPickerDate.value.persianLongDate


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(modifier.fillMaxSize()) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = "حلقه شهید محمد غفاری",
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
                    contentDescription = "Add User",
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
                    contentDescription = "Export Users",
                    Modifier
                        .padding(10.dp)
                        .fillMaxSize(1f),
                    tint = Blue500// برای کاربر سطح 1,2 آبی برای بقیه سزوح خاکستری
                )
            }
            Column(
                Modifier
                    .padding(top = 90.dp)
                    .fillMaxWidth(1f)
                    .align(Alignment.TopCenter)
            ) {
                    Row(
                        Modifier
                            .fillMaxWidth(1f)
                            .padding(10.dp)
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
                                    .fillMaxHeight(1f)
                                    .weight(1f),
                                placeholder = {
                                    Text(text = "نام.........." ,
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
                        .padding(10.dp, bottom = 50.dp)
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
                                        onViewUserClicked()
                                    }
                                }
                        ) {
                            Text(
                                "14:30", // مجموع ساعت فعالیت(ثبت شده در گزارش)
                                Modifier
                                    .padding(top = 10.dp)
                                    .align(Alignment.TopStart),
                                color = Blue500,
                                fontSize = 21.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight(500),
                            )

                            Column (
                                Modifier
                                    .align(Alignment.TopEnd)) {
                                Text(
                                    "امیر مهدی قائم پناه",
                                    Modifier
                                        .padding(start = 0.dp, top = 0.dp),
                                    color = Color(0xFF363636),
                                    fontFamily = FontFamily(Font(R.font.roboto)),
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Normal
                                )
                                Text(
                                    "فعال", // وضعیت فعال و عادی
                                    Modifier
                                        .padding(start = 0.dp, top = 0.dp)
                                        .align(Alignment.End),
                                    color = Gray400,
                                    fontFamily = FontFamily(Font(R.font.roboto)),
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight(600),
                                )
                            }

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
//                                onUnitsClicked()
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
}


@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=411dp,height=731dp,dpi=480"
)
@Composable
fun UsersListPreview() {
    AtiselTheme {
        UsersListScreen()
    }
}