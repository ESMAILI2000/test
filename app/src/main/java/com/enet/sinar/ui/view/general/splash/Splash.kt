package com.sinar.sinar.ui.view.general.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinar.sinar.R
import com.sinar.sinar.ui.theme.GrayF
import com.sinar.sinar.ui.theme.Gunmetal
import com.sinar.sinar.ui.theme.SinarTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigateToLogin: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    LaunchedEffect(Unit) {
        delay(3000) // مکث به مدت 3000 میلی‌ثانیه (3 ثانیه)
        onNavigateToLogin() // پس از 3 ثانیه، تابع ناوبری را فراخوانی می‌کنیم
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 114.dp)
                    .size(176.dp, 176.dp)
                    .align(Alignment.CenterHorizontally)
            ){
                Image(
                    painter = painterResource(id = R.drawable.logo), contentDescription = null,
                    Modifier.fillMaxSize()

                )
            }
            Text(
                text = stringResource(id = R.string.app_name),
                Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally),
                color = Gunmetal,
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontFamily = FontFamily(Font(R.font.ir_heavy)),
//                fontWeight = FontWeight.Bold
               )
            Text(
                text = stringResource(id = R.string.splash_tagline),
                Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally),
                color = GrayF,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.ir_bold)),
                fontSize = 14.sp
            )
            CustomLoadingIndicator(
                modifier = Modifier
                    .size(24.dp)
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally),
                numSegments = 8, // 8 پره
                segmentWidth = 6f, // عرض هر پره
                segmentLength = 20f, // طول هر پره
                innerRadiusFraction = 2.9f // فضای داخلی دایره مرکزی
            )

        }


//        Box(
//            modifier = Modifier
//                .size(682.dp, 454.dp)
//                .align(Alignment.BottomCenter)
//        ){
//            Image(
//                painter = painterResource(id = R.drawable.ic_splash), contentDescription = null,
//                Modifier.fillMaxSize()
//
//            )
//        }

    }
}



@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=412dp,height=917dp,dpi=480"
)
@Composable
fun SplashPreview() {
    SinarTheme {
        SplashScreen()
    }
}