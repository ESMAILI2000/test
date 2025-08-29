package com.enet.sinar.ui.view.general.pay

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.R
import com.enet.sinar.ui.theme.Background
import com.enet.sinar.ui.theme.GrayC
import com.enet.sinar.ui.theme.Gunmetal
import com.enet.sinar.ui.theme.PoliceBlue
import com.enet.sinar.ui.theme.SinarTheme
import com.enet.sinar.ui.theme.Water
import com.enet.sinar.ui.theme.White
import com.enet.sinar.ui.view.custom_view.EllipsizedMiddleText


@Composable
fun InformationScreen(modifier: Modifier = Modifier){

    var walletAddress by remember { mutableStateOf("0x5A141B7eba38A151EDfcd816D912E6ae5C0307b1") }

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
            text = "اطلاعات حساب",
            style = MaterialTheme.typography.displayLarge.copy(fontSize = 16.sp),
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .align(Alignment.TopEnd)
        )

        Box(
            modifier = Modifier
                .padding(top = 56.dp)
                .fillMaxSize()
                .background(White, RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)),
            contentAlignment = Alignment.TopCenter
        ){
            Column(
                modifier = Modifier
                    .size(364.dp, 364.dp)
                    .padding(24.dp)
                    .border(1.dp, GrayC, RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_qrcode) ,
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(120.dp)
                        .padding(top = 20.dp)
                )
                Text(text = ": آدرس ولت شما",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                    color = PoliceBlue,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 16.dp, end = 20.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(48.dp)
                        .padding(top = 4.dp)
                        .align(Alignment.CenterHorizontally)
                        .border(1.dp, Water, RoundedCornerShape(12.dp))
                        .background(Water.copy(alpha = 0.15f), RoundedCornerShape(12.dp))
                ){
                        Icon(
                            painter = painterResource(id = R.drawable.vc_wallet),
                            contentDescription = "",
                            tint = Water,
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.CenterStart)
                                .offset(x = 12.dp)
                        )

                    EllipsizedMiddleText(text = walletAddress,
                        startLength = 10,
                        endLength = 5,
                        maxLines = 1,
                        color = Gunmetal,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.vc_copy),
                        contentDescription = "",
                        tint = Water,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterEnd)
                            .offset(x = -12.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .align(Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    HorizontalDivider(
                        modifier = Modifier.width(44.dp),
                        thickness = 1.dp,
                        color = GrayC
                    )
                    Text(text = "اشتراک گذاری با",
                        style = MaterialTheme.typography.labelSmall,
                        color = Gunmetal
                        )
                    HorizontalDivider(
                        modifier = Modifier.width(44.dp),
                        thickness = 1.dp,
                        color = GrayC
                    )

                }

                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_instagram) ,
                        contentDescription = "",
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_telegram) ,
                        contentDescription = "",
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_whatsapp) ,
                        contentDescription = "",
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_sms) ,
                        contentDescription = "",
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                    )
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
fun InformationScreenPreview() {
    SinarTheme {
      InformationScreen()
    }
}