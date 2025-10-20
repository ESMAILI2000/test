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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsScreen(
    onPatientAppointmentsClicked: () -> Unit = {},
    onPatientEditClicked: () -> Unit = {},
    onShuttDownClicked: () -> Unit = {},
    onDialogClicked: () -> Unit = {},
    modifier: Modifier = Modifier
){
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(0) }
    var firstName by rememberSaveable { mutableStateOf("احسان") }
    var lastName by rememberSaveable { mutableStateOf("اسماعیلی") }
    var fatherName by rememberSaveable { mutableStateOf("علی") }
    var nationalId by rememberSaveable { mutableStateOf("4040368169") }
    var phoneNumber by rememberSaveable { mutableStateOf("09227049474") }
    var dateBirth by rememberSaveable { mutableStateOf("1379/03/17") }
    var dateJoined by rememberSaveable { mutableStateOf("1379/03/17") }
    var fatherPhone by rememberSaveable { mutableStateOf("09183126209") }
    var homePhone by rememberSaveable { mutableStateOf("08134243931") }
    var motherPhone by rememberSaveable { mutableStateOf("") }
    var homeLocation by rememberSaveable { mutableStateOf("حصار امام کوچه نیستان 4 پرواز 4") }
    var skill by rememberSaveable { mutableStateOf("برنامه نویسی") }
    var isActive by rememberSaveable { mutableStateOf(true) }


//    val context = LocalContext.current
//    val configuration = RealmConfiguration.create(schema = setOf(User::class))
//    val realm = Realm.open(configuration)
//    val all = realm.query<User>().find()
//    val unixTimeMillis = System.currentTimeMillis()


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(
            modifier
                .fillMaxSize()
                .background(Backgrund)
        ) {

            Column(
                Modifier
                    .align(Alignment.Center)
                    .padding(top = 40.dp, start = 10.dp, end = 10.dp, bottom = 50.dp)
                    .verticalScroll(state)
                    .fillMaxSize()
                    .background(Backgrund),
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
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
//                                .padding(top = 40.dp)
                            ,
                            text = "احسان اسماعیلی",
                            color = Text1,
                            fontSize = 32.sp,
                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(500),
                        )
                        Text(
                            text = "نام",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = firstName,
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
                            text = "نام خانوادگی",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = lastName,
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
                            text = "نام پدر",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = fatherName,
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
                            text = "کد ملی",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = nationalId,
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
                            text = "شماره تلفن",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = phoneNumber,
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
                            text = "تاریخ تولد",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = dateBirth,
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
                            text = "شماره تلفن پدر",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = fatherPhone,
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
                            text = "شماره تلفن منزل",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = homePhone,
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
                            text = "شماره تلفن مادر",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = motherPhone,
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
                            text = "آدرس",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = homeLocation,
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
                            text = "مهارت",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = skill,
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
                            text = "عضویت",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = if (isActive==true) "فعال" else "عادی",
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
                            text = "تاریخ عضویت",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text = "1403/09/12",
                            color = Text1,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )

                        Text(
                            text = "مشاهده فعالیت",
                            Modifier
                                .padding(top = 40.dp)
                                .align(Alignment.CenterHorizontally),
                            color = Blue500,
                            fontSize = 24.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.raleway))
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun BottomTabScreen(
    onHomeClicked: () -> Unit = {},
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

    Row(
        modifier
            .fillMaxSize(1f),
        verticalAlignment = Alignment.Bottom,
    ){
        Row(
            Modifier.fillMaxWidth(1f)
                .size(411.dp,100.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(8.dp),

            ) {
            Box (
                Modifier
                    .weight(1f)
                    .size(42.dp, 42.dp)
                    .pointerInput(Unit) {
                        detectTapGestures {
                                onHomeClicked()
                        }
                    },
            ) {
                Icon(
                    painter = painterResource(R.drawable.vc_contact),
                    contentDescription = "Home",
                    Modifier
                        .align(Alignment.Center)
                )
            }
            Box (
                Modifier
                    .weight(1f)
                    .size(42.dp, 42.dp)
                    .pointerInput(Unit) {
                        detectTapGestures {
//                                onHomeClicked()
                        }
                    },
            ) {
                Icon(
                    painter = painterResource(R.drawable.vc_contact),
                    contentDescription = "Home",
                    Modifier
                        .align(Alignment.Center)
                )
            }
            Box (
                Modifier
                    .weight(1f)
                    .size(42.dp, 42.dp)
                    .pointerInput(Unit) {
                        detectTapGestures {
//                                onHomeClicked()
                        }
                    },
            ) {
                Icon(
                    painter = painterResource(R.drawable.vc_contact),
                    contentDescription = "Home",
                    Modifier
                        .align(Alignment.Center)
                )
            }
            Box (
                Modifier
                    .weight(1f)
                    .size(42.dp, 42.dp)
                    .pointerInput(Unit) {
                        detectTapGestures {
//                                onHomeClicked()
                        }
                    },
            ) {
                Icon(
                    painter = painterResource(R.drawable.vc_contact),
                    contentDescription = "Home",
                    Modifier
                        .align(Alignment.Center)
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
fun UserDetailsPreview() {
    AtiselTheme {
        UserDetailsScreen()
    }
}