package com.enet.sab.ui.view.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
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
fun EditUserScreen(
    onPatientDetailsClicked: () -> Unit = {},
    modifier: Modifier = Modifier
){
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(0) }
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var fatherName by rememberSaveable { mutableStateOf("") }
    var nationalId by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var dateBirth by rememberSaveable { mutableStateOf("") }
    var fatherPhone by rememberSaveable { mutableStateOf("") }
    var homePhone by rememberSaveable { mutableStateOf("") }
    var motherPhone by rememberSaveable { mutableStateOf("") }
    var homeLocation by rememberSaveable { mutableStateOf("") }
    var skill by rememberSaveable { mutableStateOf("") }
    var isActive by rememberSaveable { mutableStateOf(false) }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(modifier.fillMaxSize()) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = lastName+" "+firstName,
                color = Blue500,
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500)
            )
            Column(
                Modifier
                    .align(Alignment.Center)
                    .padding(top = 90.dp, start = 10.dp, end = 10.dp, bottom = 120.dp)
                    .verticalScroll(state)
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f),
                Arrangement.spacedBy(16.dp),
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
                    OutlinedTextField(
                        value = firstName,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("نام",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { firstName = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = lastName,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("نام خانوادگی",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { lastName = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = fatherName,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("نام پدر",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { fatherName = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = nationalId,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("کد ملی",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { nationalId = nationalId },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = dateBirth,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("تاریخ تولد",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { dateBirth = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = phoneNumber,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("شماره تماس",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { phoneNumber = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = homePhone,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("شماره تماس منزل",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { homePhone = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = fatherPhone,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("شماره تماس پدر",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { fatherPhone = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = motherPhone,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("شماره تماس مادر",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { motherPhone = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = homeLocation,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("آدرس",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { homeLocation = it },
                        singleLine = false,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                            .height(height = 135.dp)
                    )
                    OutlinedTextField(
                        value = skill,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("مهارت",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { skill = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                            .height(height = 100.dp)
                    )
                    Row(
                        Modifier
                            .align(Alignment.Start)
                            .padding(start = 10.dp)
                            .background(
                                Gray200,
                                shape = RoundedCornerShape(24.dp)
                            )
                            .size(250.dp, 50.dp)
                            .padding(4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),

                        ) {
                        Button(
                            onClick = { isActive = true },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(colorResource(id = if (isActive == true) R.color.blue_500 else R.color.gray_200)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("فعال",
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontSize = 16.sp,
                                color = if (isActive == true)  Color.White else Color.Black )
                        }
                        Button(
                            onClick = { isActive = false },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(colorResource(id = if (isActive == false) R.color.blue_500 else R.color.gray_200)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("عادی",
                                fontFamily = FontFamily(Font(R.font.roboto)),
                                fontSize = 16.sp,
                                color = if (isActive == false)  Color.White else Color.Black
                            )
                        }
                    }
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
fun EditUserPreview() {
    AtiselTheme {
        EditUserScreen()
    }
}