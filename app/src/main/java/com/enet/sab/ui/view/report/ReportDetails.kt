package com.enet.sab.ui.view.report

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
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
fun ReportDetailsScreen(modifier: Modifier = Modifier) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(0) }
    var titel by rememberSaveable { mutableStateOf("حلقه صالحین") }
    var location by rememberSaveable { mutableStateOf("مدرسه خورشید پور") } // مکان
    var managerName by rememberSaveable { mutableStateOf("امیر مهدی قائم پناه") } // مسئول برگزاری
    var unitName by rememberSaveable { mutableStateOf("تعلیم و تربیت") } //نام واحد
    var groupName by rememberSaveable { mutableStateOf("حلقه شهید محمد غفاری") } //نام گروه
    var dateLunch by rememberSaveable { mutableStateOf("1404/02/10") } // تاریخ برگزاری
    var startTime by rememberSaveable { mutableStateOf("17:00") } // زمان شروع
    var endTime by rememberSaveable { mutableStateOf("19:00") } // زمان پایان
    var description by rememberSaveable { mutableStateOf("حلقه نوجوانان الف") }
    // لیست آیدی افراد شرکت کننده

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(
            modifier
                .fillMaxSize()
                .background(Backgrund)) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = titel,
                color = Text1,
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
            )
            Column(
                Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 90.dp, start = 10.dp, end = 10.dp, bottom = 50.dp)
                    .verticalScroll(state)
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f),
                Arrangement.spacedBy(16.dp),
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
                    Column(
                        Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(1f),
                        Arrangement.spacedBy(1.dp)
                    ){
                        Text(
                            text = "زمان",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text =  dateLunch.toString(),
                            color = colorResource(id = R.color.text1 ),
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                    }
                    Column(
                        Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(1f),
                        Arrangement.spacedBy(1.dp)
                    ){
                        Text(
                            text = "مکان",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = location,
                            color = Text1,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                    }
                    Column(
                        Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(1f),
                        Arrangement.spacedBy(1.dp)
                    ){
                        Text(
                            text = "ساعت شروع",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = startTime.toString(),
                            color = Text1,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                    }
                    Column(
                        Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(1f),
                        Arrangement.spacedBy(1.dp)
                    ){
                        Text(
                            text = "ساعت پایان",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = endTime.toString(),
                            color = Text1,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                    }
                    Column(
                        Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(1f),
                        Arrangement.spacedBy(1.dp)
                    ){
                        Text(
                            text = "توضیحات",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = description,
                            color = Text1,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                    }
                    Column(
                        Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(1f),
                        Arrangement.spacedBy(1.dp)
                    ){
                        Text(
                            text = "مسئول برگزاری",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = managerName,
                            color = Text1,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                    }
                    Column(
                        Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(1f),
                        Arrangement.spacedBy(1.dp)
                    ){
                        Text(
                            text = "نام واحد",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = unitName,
                            color = Text1,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                    }
                    Column(
                        Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(1f),
                        Arrangement.spacedBy(1.dp)
                    ){
                        Text(
                            text = "نام گروه",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = groupName,
                            color = Text1,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                    }
                    Column(
                        Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth(1f),
                        Arrangement.spacedBy(1.dp)
                    ){
                        Text(
                            text = "افراد حاضر",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Column(
                            Modifier,
                            Arrangement.spacedBy(16.dp)
                        ){
                            repeat(20) { index ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(1f)
                                        .heightIn(0.dp, 232.dp)
                                ) {
                                    Column (
                                        Modifier
                                            .align(Alignment.TopStart)) {
                                        Text(
                                            "صالح باقری",
                                            Modifier
                                                .align(Alignment.End)
                                                .padding(start = 0.dp, top = 0.dp),
                                            color = Text1,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight(400),
                                            fontFamily = FontFamily(Font(R.font.roboto))
                                        )
                                    }

                                }
                            }

                        }
                    }
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
fun ReportDetailsPreview() {
    AtiselTheme {
        ReportDetailsScreen()
    }
}