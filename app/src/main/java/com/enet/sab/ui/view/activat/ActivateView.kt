package com.enet.sab.ui.view.activat

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R
import com.enet.sab.ui.model.Profile
import com.enet.sab.ui.model.insertProfile
import com.enet.sab.ui.theme.AtiselTheme
import com.enet.sab.ui.theme.Blue500
import com.enet.sab.ui.theme.LoginBackgrund
import com.enet.sab.ui.utility.MySharedPreferences
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

@Composable
fun ActivatScreen(
    onLoginClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    var nationalId by remember { mutableStateOf("") }
    var activeCod by remember { mutableStateOf("") }
    val context = LocalContext.current
    
    Box(
        Modifier
            .fillMaxSize()
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
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ){
                    OutlinedTextField(
                        value = nationalId,
                        onValueChange = {
                            while(it.length < 11){
                                nationalId = it
                            }
                        },
                        label = { Text(text = "کد ملی") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "persen"
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp, top = 10.dp)
                    )

                    OutlinedTextField(
                        value = activeCod,
                        onValueChange = {
                            while(it.length < 50){
                                activeCod = it
                            }
                        },
                        label = { Text(text = "کد فعالسازی") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "cod"
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp, top = 10.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Go
                        ),
                        keyboardActions = KeyboardActions(
                            onGo = {
                                val isSuccess = logged(nationalId, activeCod, context)
                                if (isSuccess){
                                    MySharedPreferences.setActive(context,true)
                                    onLoginClicked()
                                }
                            }
                        ),
                        singleLine = true
                    )
                }

                Button(
                    onClick = {
                     val isSuccess = logged(nationalId, activeCod, context)
                        if (isSuccess){
                            MySharedPreferences.setActive(context,true)
                            onLoginClicked()
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
                    Text(text = "فعالسازی", textAlign = TextAlign.Center, fontSize = 29.sp, fontWeight = FontWeight(500))
                }

            }
        }
    }
}

fun logged(nationalId: String, activatCod: String, context: Context) :Boolean {

    val configuration = RealmConfiguration.create(schema = setOf(Profile::class))
    val realm = Realm.open(configuration)
    val profile = Profile()
    var isSuccess:Boolean = false

    if (nationalId.length != 10) {
        Toast.makeText(context, "لطفا کد ملی را به صورت صحیح وارد کنید", Toast.LENGTH_SHORT).show()

    } else if (activatCod == "sqlserberingolang") {
        profile.apply {
            national_id = nationalId
            level_permission = 2
            password = "1111"
        }
        insertProfile(realm,profile)
        isSuccess = true
    } else if (activatCod == "roominc#"){
        profile.apply {
            national_id = nationalId
            level_permission = 1
            password = "1111"
        }
        insertProfile(realm,profile)
        isSuccess = true
    }else if (activatCod == "kiosk mod in android srudio"){
        profile.apply {
            national_id = nationalId
            level_permission = 0
            password = "1111"
        }
        insertProfile(realm,profile)
        isSuccess = true
    }else {
        Toast.makeText(context, "کد فعالسازی اشتباه است", Toast.LENGTH_SHORT).show()
    }
    return isSuccess
}




@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=411dp,height=731dp,dpi=480"
)
@Composable
fun ActivatPreview() {
    AtiselTheme {
        ActivatScreen()
    }
}