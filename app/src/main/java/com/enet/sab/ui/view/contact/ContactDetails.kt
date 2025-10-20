package com.enet.sab.ui.view.contact

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R



@Composable
fun ContactDetilsScreen(
    onHomeClicked: () -> Unit = {},
    onUnitsClicked: () -> Unit = {},
    onReportsClicked: () -> Unit = {},
    onCoastsClicked: () -> Unit = {},
    onExportClicked: () -> Unit = {},
    onAddClicked: () -> Unit = {},
    onViewContactClicked: () -> Unit = {},
    modifier: Modifier = Modifier) {

    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    var fullName by rememberSaveable { mutableStateOf(" محمد زندی") }
    var titel by rememberSaveable { mutableStateOf("سخنران") }
    var location by rememberSaveable { mutableStateOf("بین النهرین") }
    var phoneNumber by rememberSaveable { mutableStateOf("09182124345") }
    var description by rememberSaveable { mutableStateOf("") }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(
            modifier
                .fillMaxSize()
                .background(Backgrund)) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = fullName,
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
                            text = "شماره تلفن",
                            color = Gray400,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.roboto))
                        )
                        Text(
                            text =  phoneNumber,
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
                            text = "آدرس",
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
fun ContactDetilsPreview() {
    AtiselTheme {
        ContactDetilsScreen()
    }
}