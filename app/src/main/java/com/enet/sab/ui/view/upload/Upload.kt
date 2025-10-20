package com.enet.sab.ui.view.upload

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R
import com.enet.sab.ui.model.Profile
import com.enet.sab.ui.model.findProfile
import com.enet.sab.ui.theme.AtiselTheme
import com.enet.sab.ui.theme.Gray200
import com.enet.sab.ui.theme.Gray300
import com.enet.sab.ui.theme.Gray400
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

@Composable
fun UploaddScreen(
    onHomeClicked: () -> Unit = {},
    modifier: Modifier = Modifier
){
    val context = LocalContext.current
    var passwordIn by remember { mutableStateOf(TextFieldValue("")) }
    var newPassword by remember { mutableStateOf(TextFieldValue("")) }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(
            modifier
                .fillMaxSize()
        )
        {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
                    .drawBehind {
                        val strokeWidth = 4.dp.toPx()
                        val dashLength = 10.dp.toPx()
                        val gapLength = 6.dp.toPx()
                        val paint = Paint().apply {
                            color = androidx.compose.ui.graphics.Color.Red
                            style = PaintingStyle.Stroke
                            this.strokeWidth = strokeWidth
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, gapLength), 0f)
                        }

                        drawRect(
                            color = androidx.compose.ui.graphics.Color.Red,
                            topLeft = Offset.Zero,
                            size = size,
//                            paint = paint
                        )
                    }
            ) {
                Text("کربلایی جان این یه باکس با خط‌چین هست", modifier = Modifier.align(Alignment.Center))
            }
            Box(modifier = Modifier
                .align(Alignment.Center)
                .size(300.dp, 300.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Gray200)
                .pointerInput(Unit) {
                    detectTapGestures {
                       // انتخاب فایل
                    }
                }
            ){
                Icon(painter = painterResource(R.drawable.vc_download), contentDescription =null,
                    Modifier
                        .align(Alignment.Center)
                        .size(150.dp, 150.dp),
                         tint = Gray300
                        )
                Text(text = "کلیک کنید و فایل مورد نظر را انتخاب کنید",
                    Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 10.dp),
                    color = Gray400,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Font(R.font.roboto)))
            }
        }
    }
}

fun selectFile(passwordIn: String,newPassword: String ,context: Context): Int {

    val configuration = RealmConfiguration.create(schema = setOf(Profile::class))
    val realm = Realm.open(configuration)
    val profile = findProfile(realm)
    return 0
}

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=411dp,height=731dp,dpi=480"
)
@Composable
fun UploadPreview() {
    AtiselTheme {
        UploaddScreen()
    }
}