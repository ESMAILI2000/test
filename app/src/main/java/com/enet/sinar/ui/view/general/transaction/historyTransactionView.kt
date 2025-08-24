package com.enet.sinar.ui.view.general.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.R
import com.enet.sinar.ui.theme.Background
import com.enet.sinar.ui.theme.Err
import com.enet.sinar.ui.theme.GrayB
import com.enet.sinar.ui.theme.GrayD
import com.enet.sinar.ui.theme.Gunmetal
import com.enet.sinar.ui.theme.NationsBlue
import com.enet.sinar.ui.theme.PoliceBlue
import com.enet.sinar.ui.theme.SinarTheme
import com.enet.sinar.ui.theme.Succes
import com.enet.sinar.ui.theme.Water
import com.enet.sinar.ui.theme.White
import com.enet.sinar.ui.view.DashedContainer
import com.enet.sinar.ui.view.EllipsizedMiddleText

@Composable
fun HistoryTransactionScreen(modifier: Modifier = Modifier){

    var transactionId by remember { mutableStateOf("722535") }
    var amount by remember { mutableStateOf("5.76") }
    var transactionCause by remember { mutableStateOf("خرید از رستوران") }
    var transactionDate by remember { mutableStateOf("1404/07/02") }
    var transactionTime by remember { mutableStateOf("12:30:24") }
    var walletAddress by remember { mutableStateOf("0x5A141B7eba38A151EDfcd816D912E6ae5C0307b1") }

    val itemsHistory = listOf(
        Pair("سبحا کشاورز", 1), // 0 -> در انتظار تایید  1-> تایید شده  2-> رد شده
        Pair("علی محمدی", 2),
        Pair("علی محمدی", 0),
        Pair("حسین محمدی", 0),
        Pair("متین عروتی", 1)
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Gunmetal,
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .size(24.dp)
        )
        Text(
            text = "صورت حساب",
            style = MaterialTheme.typography.displayLarge.copy(fontSize = 16.sp),
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .align(Alignment.TopEnd)
            )

        LazyColumn(
            modifier = Modifier
                .padding(top = 56.dp)
                .fillMaxSize()
                .background(White, RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)),
            contentPadding = PaddingValues(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(itemsHistory.size) { page ->
                DashedContainer(
                    modifier = Modifier
                        .size(364.dp, 276.dp)
                        .background(White, shape = RoundedCornerShape(24.dp)),
                    cornerRadius = 24.dp,
                    borderColor = Water,
                    strokeWidth = 1.dp
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .height(82.dp)
                                .background(
                                    Color(0xFF539DF3).copy(0.08f),
                                    RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                                ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "کد پیگیری: $transactionId",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = NationsBlue)

                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                EllipsizedMiddleText(text = walletAddress,
                                    startLength = 10,
                                    endLength = 5,
                                    maxLines = 1,
                                    color = PoliceBlue,
                                    style = MaterialTheme.typography.bodyLarge,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .fillMaxWidth(0.4f)
                                        .padding(end = 8.dp))
                                Row(
                                    Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(text = ": واریز $amount سینار از آدرس ",
                                        maxLines = 1,
                                        color = Gunmetal,
                                        style = MaterialTheme.typography.bodyLarge,
                                        overflow = TextOverflow.Visible,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier
                                            .padding(end = 8.dp)
                                            .fillMaxWidth(0.9f))

                                    Icon(painter = painterResource(id = when(itemsHistory[page].second){
                                        2-> R.drawable.vc_circle_chevron_up
                                        else -> {
                                            R.drawable.vc_circle_chevron_down
                                        }
                                    }),
                                        contentDescription = "",
                                        tint = if (itemsHistory[page].second != 2) Succes else Err,
                                        modifier =  Modifier.size(18.dp))
                                }
                            }

                        }

                         Column(
                             Modifier
                                 .size(332.dp, 96.dp)
                                 .padding(top = 16.dp),
                             verticalArrangement = Arrangement.spacedBy(2.dp)
                         ) {
                             Row(
                                 Modifier
                                     .fillMaxWidth(),
                                 verticalAlignment = Alignment.CenterVertically
                             ) {
                                 Text(text = itemsHistory[page].first,
                                     maxLines = 1,
                                     color = Gunmetal,
                                     style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                     overflow = TextOverflow.Visible,
                                     textAlign = TextAlign.Start,
                                     modifier = Modifier
                                         .padding(end = 8.dp)
                                         .fillMaxWidth(0.4f))
                                 Row(
                                     Modifier
                                         .fillMaxWidth(),
                                     horizontalArrangement = Arrangement.End,
                                     verticalAlignment = Alignment.CenterVertically
                                 ) {
                                     Text(text = ": دامنه ثبت شده",
                                         maxLines = 1,
                                         color = PoliceBlue,
                                         style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                         overflow = TextOverflow.Visible,
                                         textAlign = TextAlign.End,
                                         modifier = Modifier
                                             .padding(end = 4.dp))

                                     Icon(painter = painterResource(id = R.drawable.vc_credit_card),
                                         contentDescription = "",
                                         tint = Gunmetal,
                                         modifier =  Modifier.size(18.dp))
                                 }
                             }
                             Row(
                                 Modifier
                                     .fillMaxWidth(),
                                 verticalAlignment = Alignment.CenterVertically
                             ) {
                                 Text(text = transactionCause,
                                     maxLines = 1,
                                     color = Gunmetal,
                                     style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                     overflow = TextOverflow.Visible,
                                     textAlign = TextAlign.Start,
                                     modifier = Modifier
                                         .padding(end = 8.dp)
                                         .fillMaxWidth(0.4f))
                                 Row(
                                     Modifier
                                         .fillMaxWidth(),
                                     horizontalArrangement = Arrangement.End,
                                     verticalAlignment = Alignment.CenterVertically
                                 ) {
                                     Text(text = ": علت پرداخت",
                                         maxLines = 1,
                                         color = PoliceBlue,
                                         style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                         overflow = TextOverflow.Visible,
                                         textAlign = TextAlign.End,
                                         modifier = Modifier
                                             .padding(end = 4.dp))

                                     Icon(painter = painterResource(id = R.drawable.vc_credit_card),
                                         contentDescription = "",
                                         tint = Gunmetal,
                                         modifier =  Modifier.size(18.dp))
                                 }
                             }
                             Row(
                                 Modifier
                                     .fillMaxWidth(),
                                 verticalAlignment = Alignment.CenterVertically
                             ) {
                                 Text(text = transactionDate,
                                     maxLines = 1,
                                     color = Gunmetal,
                                     style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                     overflow = TextOverflow.Visible,
                                     textAlign = TextAlign.Start,
                                     modifier = Modifier
                                         .padding(end = 8.dp)
                                         .fillMaxWidth(0.4f))
                                 Row(
                                     Modifier
                                         .fillMaxWidth(),
                                     horizontalArrangement = Arrangement.End,
                                     verticalAlignment = Alignment.CenterVertically
                                 ) {
                                     Text(text = ": تاریخ واریز",
                                         maxLines = 1,
                                         color = PoliceBlue,
                                         style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                         overflow = TextOverflow.Visible,
                                         textAlign = TextAlign.End,
                                         modifier = Modifier
                                             .padding(end = 4.dp))

                                     Icon(painter = painterResource(id = R.drawable.vc_calendar_due),
                                         contentDescription = "",
                                         tint = Gunmetal,
                                         modifier =  Modifier.size(18.dp))
                                 }
                             }
                             Row(
                                 Modifier
                                     .fillMaxWidth(),
                                 verticalAlignment = Alignment.CenterVertically
                             ) {
                                 Text(text = transactionTime,
                                     maxLines = 1,
                                     color = Gunmetal,
                                     style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                     overflow = TextOverflow.Visible,
                                     textAlign = TextAlign.Start,
                                     modifier = Modifier
                                         .padding(end = 8.dp)
                                         .fillMaxWidth(0.4f))
                                 Row(
                                     Modifier
                                         .fillMaxWidth(),
                                     horizontalArrangement = Arrangement.End,
                                     verticalAlignment = Alignment.CenterVertically
                                 ) {
                                     Text(text = ": زمان واریز",
                                         maxLines = 1,
                                         color = PoliceBlue,
                                         style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                         overflow = TextOverflow.Visible,
                                         textAlign = TextAlign.End,
                                         modifier = Modifier
                                             .padding(end = 4.dp))

                                     Icon(painter = painterResource(id = R.drawable.vc_clock_hour),
                                         contentDescription = "",
                                         tint = Gunmetal,
                                         modifier =  Modifier.size(18.dp))
                                 }
                             }
                         }

                        HorizontalDivider(modifier = Modifier
                            .width(332.dp)
                            .padding(top = 16.dp),
                            thickness = 1.dp,
                            color = GrayB)

                        Row(
                            Modifier
                                .width(332.dp)
                                .padding(top = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(end = 8.dp)

                            ){
                                Row(
                                    Modifier
                                        .size(114.dp, 36.dp)
                                        .border(
                                            1.dp,
                                            when (itemsHistory[page].second) {
                                                0 -> GrayD
                                                1 -> Succes
                                                else -> {
                                                    Color(0xFFD84040)
                                                }
                                            },
                                            RoundedCornerShape(8.dp)
                                        )
                                        .background(
                                            when (itemsHistory[page].second) {
                                                0 -> White
                                                1 -> Succes.copy(alpha = 0.16f)
                                                else -> {
                                                    Color(0xFFD84040).copy(alpha = 0.16f)
                                                }
                                            },
                                            RoundedCornerShape(8.dp)
                                        ),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(text = when(itemsHistory[page].second){
                                        0-> "در انتظار تایید"
                                        1-> "تایید شده"
                                        else -> {
                                           "رد شده"
                                        }
                                    },
                                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                        color = when(itemsHistory[page].second){
                                                0-> GrayD
                                                1-> Succes
                                                else -> {
                                                    Color(0xFFD84040)
                                                }
                                            }
                                        )
                                    if (itemsHistory[page].second != 0){
                                        Icon(
                                            imageVector =  when(itemsHistory[page].second){
                                                1-> Icons.Default.Check
                                                else -> {
                                                    Icons.Default.Close
                                                }
                                            },
                                            contentDescription ="" ,
                                            tint = when(itemsHistory[page].second){
                                                0-> GrayD
                                                1-> Succes
                                                else -> {
                                                    Color(0xFFD84040)
                                                }
                                            },
                                            modifier = Modifier
                                                .size(16.dp)
                                                .padding(start = 2.dp))
                                    }


                                }
                            }
                            Row(
                                Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = ": وضعیت دریافت",
                                    maxLines = 1,
                                    color = Gunmetal,
                                    style = MaterialTheme.typography.bodyLarge,
                                    overflow = TextOverflow.Visible,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .padding(end = 8.dp))

                                Icon(painter = painterResource(id = R.drawable.vc_progress_down),
                                    contentDescription = "",
                                    tint = Gunmetal,
                                    modifier =  Modifier.size(24.dp))
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
    device = "spec:width=412dp,height=917dp,dpi=480"
)
@Composable
fun HistoryTransactionPreview() {
    SinarTheme {
        HistoryTransactionScreen()
    }
}