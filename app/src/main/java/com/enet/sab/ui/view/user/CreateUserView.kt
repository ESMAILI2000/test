package com.enet.sab.ui.view.user

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enet.sab.ui.theme.AtiselTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.enet.sab.R
import kotlin.math.absoluteValue


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CreateUserScreen(
    onPatientsClicked: () -> Unit = {},
    modifier: Modifier = Modifier) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(0) }

    var showDialog by remember { mutableStateOf(false) }

    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var fatherName by rememberSaveable { mutableStateOf("") }
    var nationalId by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var dateBirth by rememberSaveable { mutableStateOf("") }
    var fatherPhone by rememberSaveable { mutableStateOf("") }
    var homePhone by rememberSaveable { mutableStateOf("") }
    var motherPhone by rememberSaveable { mutableStateOf("") }
    var homeLocation by rememberSaveable { mutableStateOf("") }
    var skill by rememberSaveable { mutableStateOf("") }
    var isActive by rememberSaveable { mutableStateOf(false) }

    // دیالوگ تاریخ تولد
    val years = (1360..1400).toList()
    val months = (1..12).toList()
    val days = (1..31).toList()
    var selectedYear by remember { mutableStateOf(years.first()) }
    var selectedMonth by remember { mutableStateOf(months.first()) }
    var selectedDay by remember { mutableStateOf(days.first()) }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){

        if (showDialog) {

            val pagerStateYear = rememberPagerState(initialPage = if (dateBirth == "") 30 else selectedYear-1360) { years.size }
            val pagerStateMonth = rememberPagerState(initialPage = if (dateBirth == "") 5 else selectedMonth-1) { months.size }
            val pagerStateDay = rememberPagerState(initialPage = if (dateBirth == "") 14 else selectedDay-1) { days.size }

            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "انتخاب تاریخ") },
                text = {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        VerticalPager(
                            state = pagerStateYear,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .height(100.dp),
                            beyondBoundsPageCount = 1,
                            contentPadding = PaddingValues(vertical = 3.dp)
                        ) { page ->
                            val item = years[page]
                            val offset = pagerStateYear.getOffsetFractionForPage(page)
                            val scale = 1f - (offset.absoluteValue * .2f)
                            selectedYear = pagerStateYear.currentPage+1360
                            Box(
                                modifier = Modifier
                                    .zIndex(-(page - pagerStateYear.currentPage).absoluteValue * 10f)
                                    .graphicsLayer {
                                        translationY = size.height * (offset * .60f)
                                        alpha = (2f - offset.absoluteValue) / 2f
                                        scaleX = scale
                                        scaleY = scale
                                    }
                                    .padding(8.dp)
                                    .border(1.dp, Color(0xFF2196F3), RoundedCornerShape(12.dp))
                                    .clickable {
                                        //
                                    },
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = item.toString(),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                        VerticalPager(
                            state = pagerStateMonth,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .height(100.dp),
                            beyondBoundsPageCount = 1,
                            contentPadding = PaddingValues(vertical = 3.dp)
                        ) { page ->
                            val item = months[page]
                            val offset = pagerStateMonth.getOffsetFractionForPage(page)
                            val scale = 1f - (offset.absoluteValue * .2f)
                            Box(
                                modifier = Modifier
                                    .zIndex(-(page - pagerStateMonth.currentPage).absoluteValue * 10f)
                                    .graphicsLayer {
                                        translationY = size.height * (offset * .60f)
                                        alpha = (2f - offset.absoluteValue) / 2f
                                        scaleX = scale
                                        scaleY = scale
                                    }
                                    .padding(8.dp)
                                    .border(1.dp, Color(0xFF2196F3), RoundedCornerShape(12.dp))
                                    .clickable {
                                        //
                                    },
                                contentAlignment = Alignment.Center

                            ){
                                selectedMonth = pagerStateMonth.currentPage+1
                                Text(
                                    text = item.toString(),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                        VerticalPager(
                            state = pagerStateDay,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .height(100.dp),
                            beyondBoundsPageCount = 1,
                            contentPadding = PaddingValues(vertical = 3.dp)
                        ) { page ->
                            val item = days[page]
                            val offset = pagerStateDay.getOffsetFractionForPage(page)
                            val scale = 1f - (offset.absoluteValue * .2f)
                            Box(
                                modifier = Modifier
                                    .zIndex(-(page - pagerStateDay.currentPage).absoluteValue * 10f)
                                    .graphicsLayer {
                                        translationY = size.height * (offset * .60f)
                                        alpha = (2f - offset.absoluteValue) / 2f
                                        scaleX = scale
                                        scaleY = scale
                                    }
                                    .padding(8.dp)
                                    .border(1.dp, Color(0xFF2196F3), RoundedCornerShape(12.dp))
                                    .clickable {
                                        //
                                    },
                                contentAlignment = Alignment.Center
                            ){
                                selectedDay = pagerStateDay.currentPage+1
                                Text(
                                    text = item.toString(),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }

                    }
                },
                confirmButton = {
                    Button(onClick = {
                        dateBirth = "$selectedYear/$selectedMonth/$selectedDay"
                        showDialog = false
                    },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonColors(
                            Blue500,
                            Color(0xFFFFFFFF),
                            Blue500,
                            Blue500
                        )
                    ) {
                        Text("ثبت تاریخ")
                    }
                },
                dismissButton = {
                    //
                }
            )
        }

        Box(modifier.fillMaxSize()) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = "عضو جدید",
                color = Blue500,
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
            )
            Column(
                Modifier
                    .align(Alignment.Center)
                    .padding(top = 90.dp, start = 10.dp, end = 10.dp, bottom = 120.dp)
                    .verticalScroll(state)
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f),
                Arrangement.spacedBy(16.dp),
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
                    OutlinedTextField(
                        value = firstName,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("نام",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { firstName = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = lastName,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("نام خانوادگی",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { lastName = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = fatherName,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("نام پدر",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { fatherName = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = nationalId,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("کد ملی",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { nationalId = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    Box(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(1f)
                        .clickable { showDialog = true }
                    ){
                        OutlinedTextField(
                            value = dateBirth,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Blue500,
                                unfocusedBorderColor = Blue200,
                                focusedLabelColor = Blue500,
                                unfocusedLabelColor = Blue200,
                                cursorColor = Blue500
                            ),
                            label = { Text("تاریخ تولد",
                                style = TextStyle(
                                    fontFamily =  FontFamily(Font(R.font.roboto)),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Blue400
                                )) },
                            onValueChange = { showDialog = true },
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp),
//                            readOnly = true,
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .clickable { showDialog = true }
                        )
                    }

                    OutlinedTextField(
                        value = phoneNumber,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("شماره تماس",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { phoneNumber = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = homePhone,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("شماره تماس منزل",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { homePhone = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = fatherPhone,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("شماره تماس پدر",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { fatherPhone = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = motherPhone,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("شماره تماس مادر",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { motherPhone = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = homeLocation,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("آدرس",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { homeLocation = it },
                        singleLine = false,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                            .height(height = 135.dp)
                    )
                    OutlinedTextField(
                        value = skill,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("مهارت",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )) },
                        onValueChange = { skill = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                            .height(height = 100.dp)
                    )
                    Row(
                        Modifier
                            .align(Alignment.Start)
                            .padding(start = 10.dp)
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
                            onClick = { isActive = true },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(colorResource(id = if (isActive == true) R.color.blue_500 else R.color.gray_200)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("فعال",
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontSize = 16.sp,
                                color = if (isActive == true)  Color.White else Color.Black )
                        }
                        Button(
                            onClick = { isActive = false },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(colorResource(id = if (isActive == false) R.color.blue_500 else R.color.gray_200)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("عادی",
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontSize = 16.sp,
                                color = if (isActive == false)  Color.White else Color.Black
                            )
                        }
                    }
                }

            }
            Button(
                onClick = {

                },
                Modifier
                    .padding(bottom = 50.dp, end = 10.dp, start = 10.dp)
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    Blue500,
                    Color(0xFFFFFFFF),
                    Blue500,
                    Blue500
                )
            ) {

                Text(
                    "ثبت",
                    fontSize = 29.sp,
                    fontWeight = FontWeight(500)
                )
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
fun CreateUserPreview() {
    AtiselTheme {
        CreateUserScreen()
    }
}