package com.enet.sinar.ui.view.general.otp

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.R
import com.enet.sinar.ui.theme.Background
import com.enet.sinar.ui.theme.Err
import com.enet.sinar.ui.theme.GrayA
import com.enet.sinar.ui.theme.GrayC
import com.enet.sinar.ui.theme.GrayE
import com.enet.sinar.ui.theme.GrayF
import com.enet.sinar.ui.theme.Gunmetal
import com.enet.sinar.ui.theme.NationsBlue
import com.enet.sinar.ui.theme.SinarTheme
import com.enet.sinar.ui.view.custom_view.BoxedTextInput
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(modifier: Modifier = Modifier) {


    var otpCode by remember { mutableStateOf("1")}
    var phoneNumber by remember { mutableStateOf("09227049474") }
    var error by remember { mutableStateOf(false) }
    var time by remember { mutableStateOf(30) }
    var enableButton by remember { mutableStateOf(false) }

    if (enableButton == false){
        LaunchedEffect(Unit) {
            for (i in 30 downTo 0) {
                delay(1000) // update once a second
                time = i
            }
            enableButton = true
        }
    }


    Box(modifier = Modifier
        .background(Background)
        .fillMaxSize()
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Gunmetal,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 64.dp)

        )

        Column(
            Modifier
                .width(364.dp)
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(bottom = 0.dp, top = 250.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color.White)
        ) {
            val image = painterResource(R.drawable.logo)
            Image(
                painter = image, contentDescription = "logo",
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(72.dp, 72.dp)
                    .padding(top = 24.dp)
            )
            Text(
                text = "احراز هویت",
                style = MaterialTheme.typography.displayLarge.copy(fontSize = 18.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp),
                color = Gunmetal
            )
            Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(text = "رقمی ارسال شده به شماره", style = MaterialTheme.typography.labelSmall,color = GrayF)
                Text(text = " 5 ", style = MaterialTheme.typography.labelSmall,color = NationsBlue)
                Text(text = "کد ", style = MaterialTheme.typography.labelSmall,color = GrayF)
            }
                Text(
                    text = phoneNumber,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = NationsBlue,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "را وارد کنید",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = GrayF,
                    textAlign = TextAlign.Center
                )
            }


            Column(
                Modifier
                    .width(332.dp)
                    .padding(vertical = 20.dp)
                    .align(Alignment.CenterHorizontally)
            ) {

                BoxedTextInput(
                    value = otpCode,
                    length = 5,
                    onValueChange = { otpCode = it },
                    Modifier
                        .padding(top = 0.dp)
                        .align(Alignment.CenterHorizontally),
                    textBorderShape = RoundedCornerShape(12.dp),
                    textArrangement = Arrangement.spacedBy(4.dp),
                    textStyle = TextStyle(fontSize = 18.sp, color = if (error) Err else NationsBlue),
                    emptyTextBorderColor = GrayC,
                    filledTextBorderColor = if (error) Err else NationsBlue,
                    backgroundColor = if (error) Color.Transparent else Background ,
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        keyboardType = KeyboardType.NumberPassword
                    ),
                )
                AnimatedVisibility(
                    visible = if (error) true else false,
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "!کد وارد شده اشتباه است",
                            Modifier.fillMaxWidth(0.9f)
                                .padding(end = 4.dp),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font( R.font.ir_regular)),
                            color = Err,
                            maxLines = 1,
                            textAlign = TextAlign.End,
                            overflow = TextOverflow.Clip,
//                        fontWeight = 500
                        )
                        Icon(painter = painterResource(id = R.drawable.vc_mood_sad) ,
                            contentDescription = null,
                            tint = Err
                        )
                    }
                }

                AnimatedVisibility(
                    visible = if (error) false else true,
                ){
                    Row(
                        Modifier
                            .fillMaxWidth(1f)
                            .padding(top = 12.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxWidth(0.5f)){
                            Text(
                                text = if (time>9) " 00:$time " else " 00:0$time",
                                Modifier.align(Alignment.TopStart),
                                style = MaterialTheme.typography.labelLarge.copy(color = Gunmetal),
                                textAlign = TextAlign.Start,
//                                color = NationsBlue
                            )

                        }

                        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ){
                            Box(modifier = Modifier.fillMaxWidth(1f)){
                                Text(
                                    text = " ارسال مجدد کد بعد از:",
                                    Modifier.align(Alignment.CenterStart),
                                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 16.sp),
                                    color = Gunmetal,
                                    textAlign = TextAlign.Start,
                                    maxLines = 1,
                                    overflow = TextOverflow.Clip
                                )
                            }
                        }


                    }
                }



                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        enableButton = false
//                        error = !error
                              time = 30},
                    Modifier
                        .fillMaxWidth()
                        .size(0.dp, 50.dp),
                    shape = RoundedCornerShape(12.dp),
                    enabled = enableButton,
                    colors = ButtonColors(
                        containerColor = NationsBlue,
                        contentColor = Color.White,
                        disabledContentColor = GrayE,
                        disabledContainerColor = GrayA
                    )
                ) {
                    Text("ارسال مجدد",
                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(painter = painterResource(R.drawable.vc_refresh) , contentDescription = null )
                }

            }


        }


        Text(
            text = "ورژن 1.0.0",
            Modifier
                .padding(bottom = 54.dp, end = 0.dp)
                .align(Alignment.BottomCenter),
            color = Gunmetal,
            fontFamily = FontFamily(Font(R.font.ir_medium)),
            fontSize = 14.sp
        )
    }

}


@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=412dp,height=917dp,dpi=480"
)
@Composable
fun OtpPreview() {
    SinarTheme {
        OtpScreen()
    }
}