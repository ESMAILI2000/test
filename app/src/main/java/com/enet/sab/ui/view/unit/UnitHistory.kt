package com.enet.sab.ui.view.unit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
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
fun UnitHistoryScreen(
    modifier: Modifier = Modifier
) {

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(modifier
            .fillMaxSize()
            .background(Backgrund)) {
            Text(
                modifier = Modifier.align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = "واحد عقیدتی", //نام واحد
                color = Text1,
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
            )
            Column(
                Modifier
                    .align(Alignment.Center)
                    .padding(top = 90.dp, start = 10.dp, end = 10.dp)
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f),
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
                                .align(Alignment.TopEnd)) {
                            Text(
                                "امیر مهدی قائم پناه",
                                Modifier
                                    .align(Alignment.End)
                                    .padding(start = 0.dp, top = 0.dp),
                                color = Color(0xFF363636),
                                fontSize = 21.sp,
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                "از تاریخ 1400/01/18 تا تاریخ 1401/10/12", //  اگر مسئول عوض شده بود از تاریخ تا تاریخ اگر نام عوض شده بود در تاریخ
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
        }
    }
}

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=411dp,height=731dp,dpi=480"
)
@Composable
fun UnitHistoryPreview() {
    AtiselTheme {
        UnitHistoryScreen()
    }
}