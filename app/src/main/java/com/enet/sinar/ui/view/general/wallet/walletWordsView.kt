package com.enet.sinar.ui.view.general.wallet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.R
import com.enet.sinar.ui.theme.Background
import com.enet.sinar.ui.theme.GrayB
import com.enet.sinar.ui.theme.GrayF
import com.enet.sinar.ui.theme.Gunmetal
import com.enet.sinar.ui.theme.NationsBlue
import com.enet.sinar.ui.theme.PoliceBlue
import com.enet.sinar.ui.theme.SinarTheme

@Composable
fun WalletWordsScreen(modifier: Modifier = Modifier) {

    val texts = mutableListOf<String>().apply {
        add("flame")
        add("flame")
        add("flame")
        add("flame")
        add("flame")
        add("flame")
        add("flame")
        add("flame")
        add("flame")
        add("drive")
        add("flame")
        add("maze")
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr){
        Box(modifier = Modifier
            .fillMaxSize()
        ) {

            Column(
                Modifier
                    .width(364.dp)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {},
                    Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(332.dp, 56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults. buttonColors(
                        containerColor = NationsBlue,
                        contentColor = Color.White,
                    )
                ) {
                    Text(stringResource(id = R.string.next_step),
                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(imageVector = Icons.Default.ArrowForward , contentDescription = null )
                }
                OutlinedButton(
                    onClick = {},
                    Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(332.dp, 56.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, NationsBlue)
                ) {
                    Text(stringResource(id = R.string.save_changes),
                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(painter = painterResource(id = R.drawable.vc_download) , contentDescription = null )
                }
            }

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Gunmetal,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 64.dp)

            )

            Column(
                Modifier
                    .width(364.dp)
                    .align(Alignment.TopCenter)
                    .padding(bottom = 0.dp, top = 88.dp)
            ) {
                val image = painterResource(R.drawable.ic_wallet)
                Image(
                    painter = image, contentDescription = "logo",
                    Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(105.dp, 104.dp)
                )
                Text(
                    text = stringResource(id = R.string.write_down_your_recovery),
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp),
                    fontSize = 20.sp,
                    color = Gunmetal
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
//                    .height(44.dp)
                        .padding(top = 8.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.save_your_recovery_phrase_either),
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.labelSmall.copy(lineHeight = 16.sp ),
                        color = GrayF,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = stringResource(id = R.string.enter_this_phrase),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = GrayF,
                        textAlign = TextAlign.Center
                    )
                }

                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr){
                    Column(
                        modifier = Modifier
                            .size(364.dp, 236.dp)
                            .padding(top = 24.dp)
                            .align(Alignment.CenterHorizontally),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        // تقسیم لیست به گروه‌های ۳ تایی
                        texts.chunked(3).forEachIndexed { rowIndex, rowItems ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                rowItems.forEachIndexed { columnIndex, item ->
                                    Box(
                                        modifier = Modifier
                                            .size(108.dp, 44.dp)
                                            .background(Background, RoundedCornerShape(12.dp)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "${rowIndex * 3 + columnIndex + 1}. $item",
                                            textAlign = TextAlign.Center,
                                            color = Color.Black,
                                            style = MaterialTheme.typography.displayMedium.copy(fontSize = 14.sp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }


                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 34.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = stringResource(id = R.string.your_wallet_address),
                        maxLines = 1,
                        color = PoliceBlue,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(end = 8.dp))
                    Icon(painter = painterResource(id = R.drawable.vc_wallet), contentDescription = "")
                }

                Column(
                    Modifier
                        .fillMaxWidth()
                        .height(87.dp)
                        .padding(top = 8.dp)
                        .background(GrayB, RoundedCornerShape(12.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "0x5A141B7eba38A151EDfcd816D912E6ae5C0307b1",
                        maxLines = 1,
                        color = Gunmetal,
                        style = MaterialTheme.typography.displayMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth())

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = stringResource(id = R.string.copy),
                            maxLines = 1,
                            color = Gunmetal,
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .padding(end = 8.dp))
                        Icon(painter = painterResource(id = R.drawable.vc_copy),
                            contentDescription = "",
                            Modifier.size(20.dp))
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
fun WalletWordsPreview() {
    SinarTheme {
        WalletWordsScreen()
    }
}