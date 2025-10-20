package com.enet.sab.ui.view.group

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R
import com.enet.sab.ui.theme.AtiselTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateGroupScreen(modifier: Modifier = Modifier) {

    var grupName by rememberSaveable { mutableStateOf("") }
    var managerName by rememberSaveable { mutableStateOf("") }


//    val context = LocalContext.current
//    val configuration = RealmConfiguration.create(schema = setOf(User::class))
//    val realm = Realm.open(configuration)
//    val all = realm.query<User>().find()
//    val unixTimeMillis = System.currentTimeMillis()


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(modifier.fillMaxSize()) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = "گروه جدید",
                color = Blue500,
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
            )
            Column(
                Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 90.dp, start = 10.dp, end = 10.dp, bottom = 120.dp)
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f),
                Arrangement.spacedBy(16.dp),
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
                    OutlinedTextField(
                        value = grupName,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("نام گروه",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { grupName = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = managerName,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("نام مسئول",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { managerName = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                }

            }
            Button(
                onClick = {
                    //
                },
                Modifier
                    .padding(bottom = 50.dp, end = 10.dp, start = 10.dp)
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    Blue500,
                    Color(0xFFFFFFFF),
                    Blue500,
                    Blue500
                ),
            ) {

                Text(
                    "ثبت",
                    fontSize = 29.sp,
                    fontWeight = FontWeight(500)
                )
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
fun CreateGroupPreview() {
    AtiselTheme {
        CreateGroupScreen()
    }
}