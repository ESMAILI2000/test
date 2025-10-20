package com.enet.sab.ui.view.password

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R
import com.enet.sab.ui.model.Profile
import com.enet.sab.ui.model.findProfile
import com.enet.sab.ui.model.updatePassword
import com.enet.sab.ui.theme.AtiselTheme
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ChengPasswordScreen(
    onHomeClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    var passwordIn by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){

        Box(modifier.fillMaxSize()
            .background(LoginBackgrund))
        {
            Image(
                painter = painterResource(R.mipmap.ic_launcher_background),
                contentDescription = "Import",
                Modifier
//                        .padding(bottom = 8.dp, start = 4.dp)
                    .align(Alignment.TopCenter)
                    .padding(10.dp, top = 80.dp)
                    .size(240.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 200.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = passwordIn,
                        onValueChange = {
                            passwordIn = it
                        },
                        label = { Text(text = "رمز ورود فعلی") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp, top = 10.dp)
                    )
                    OutlinedTextField(
                        value = newPassword,
                        onValueChange = {
                            newPassword = it
                        },
                        label = { Text(text = "رمز ورود جدید") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp, top = 10.dp)
                    )

                    Button(
                        onClick = {
                            var i= chengPassword(passwordIn,newPassword,context)
                            if (i==1){
                                onHomeClicked()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp, top = 10.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonColors(
                            Blue500,
                            Color(0xFFFFFFFF),
                            Blue500,
                            Blue500
                        )
                    ) {
                        Text(text = "تغییر رمز", textAlign = TextAlign.Center, fontSize = 29.sp, fontWeight = FontWeight(500))
                    }

                }
            }
        }
    }

}

fun chengPassword(passwordIn: String,newPassword: String ,context: Context): Int {

    val configuration = RealmConfiguration.create(schema = setOf(Profile::class))
    val realm = Realm.open(configuration)
    val profile = findProfile(realm)

    if (passwordIn.length < 4 || newPassword.length < 4) {
        Toast.makeText(context, "لطفا رمز ورود را کامل وارد کنید", Toast.LENGTH_SHORT).show()
        return 0
    } else if ((profile?.password ?: "1111") != passwordIn) {
        Toast.makeText(context, "رمز ورود اشتباه است", Toast.LENGTH_SHORT).show()
        return 0
    }else if((profile?.password ?: "1111") == newPassword) {
        Toast.makeText(context, "رمز ورود فعلی و رمز ورود جدید یکسان است", Toast.LENGTH_SHORT).show()
        return 2
    }else {
        updatePassword(realm,newPassword)
        return 1
    }

}

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=411dp,height=731dp,dpi=480"
)
@Composable
fun ChengPasswordPreview() {
    AtiselTheme {
        ChengPasswordScreen()
    }
}