package com.enet.sab.ui.view.coast

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enet.sab.ui.theme.AtiselTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R
import com.enet.sab.ui.theme.Backgrund
import com.enet.sab.ui.theme.Gray400
import com.enet.sab.ui.theme.Text1


@Composable
fun CoastDetilsScreen(modifier: Modifier = Modifier) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    var titel by rememberSaveable { mutableStateOf("شهریه سالن") }
    var amount by rememberSaveable { mutableStateOf(87000) }
    var reportName by rememberSaveable { mutableStateOf("سانس نوجوانان") }
    var unitName by rememberSaveable { mutableStateOf("تربیت بدنی") }
    var description by rememberSaveable { mutableStateOf("شهریه آبان") }
    var datePayment by rememberSaveable { mutableStateOf("1403/08/05") }
    var dateInsert by rememberSaveable { mutableStateOf("1403/08/06") }

//    val context = LocalContext.current
//    val configuration = RealmConfiguration.create(schema = setOf(User::class))
//    val realm = Realm.open(configuration)
//    val all = realm.query<User>().find()
//    val unixTimeMillis = System.currentTimeMillis()


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(
            modifier
                .fillMaxSize()
                .background(Backgrund)) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = if(amount>=0) "هزینه دریافتی" else "هزینه پرداختی",
                color = Text1,
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
            )
            Column(
                Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 90.dp, start = 10.dp, end = 10.dp, bottom = 120.dp)
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
                    ) {
                        Text(
                            text = "عنوان",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = titel,
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
                            text = "مبلغ",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text =  amount.toString(),
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
                            text = "تاریخ",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = datePayment,
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
                            text = "نام فعالیت",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = reportName,
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
fun CoastDetilsScreenPreview() {
    AtiselTheme {
        CoastDetilsScreen()
    }
}