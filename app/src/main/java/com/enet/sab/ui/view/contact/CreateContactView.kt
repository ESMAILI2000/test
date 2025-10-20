package com.enet.sab.ui.view.contact

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enet.sab.ui.theme.AtiselTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sab.R
import com.enet.sab.ui.model.Contact
import com.enet.sab.ui.model.Profile
import com.enet.sab.ui.model.findContactAll
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enet.sab.ui.theme.Blue500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateContactScreen(modifier: Modifier = Modifier,
                        viewModel: ContactViewModel = viewModel()
) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(0) }
//    var fullName by rememberSaveable { mutableStateOf("") }
//    var titel by rememberSaveable { mutableStateOf("") }
//    var location by rememberSaveable { mutableStateOf("") }
//    var description by rememberSaveable { mutableStateOf("") }
//    var phoneNumber by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
//    val coroutineScope = rememberCoroutineScope()

    val configuration = RealmConfiguration.create(schema = setOf(Profile::class))
    val realm = Realm.open(configuration)
//    val profile = findProfile(realm)


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ){
        Box(modifier.fillMaxSize()) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp),
                text = "مخاطب جدید",
                color = Blue500,
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
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
                        value = viewModel.Name,
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
                        onValueChange = { viewModel.Name = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = viewModel.PhoneNumber,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("شماره تلفن",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { viewModel.PhoneNumber = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = viewModel.Title,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("عنوان",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { viewModel.Title = it },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                    )
                    OutlinedTextField(
                        value = viewModel.Location,
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
                        onValueChange = { viewModel.Location = it },
                        singleLine = false,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                            .height(height = 105.dp)
                    )
                    OutlinedTextField(
                        value = viewModel.Description,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Blue500,
                            unfocusedBorderColor = Blue200,
                            focusedLabelColor = Blue500,
                            unfocusedLabelColor = Blue200,
                            cursorColor = Blue500
                        ),
                        label = { Text("توضیحات",
                            style = TextStyle(
                                fontFamily =  FontFamily(Font(R.font.roboto)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Blue400
                            )
                        ) },
                        onValueChange = { viewModel.Description = it },
                        singleLine = false,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(1f)
                            .height(height = 135.dp)
                    )
                }

            }
            Button(
                onClick = {
                    viewModel.saveContact(realm)
//                    addContact(profile?.national_id ?: "",phoneNumber,fullName,titel,location,description,context)
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


            if (viewModel.isSaved) {
                Toast.makeText(context, "مخاطب با موفقیت ثبت شد", Toast.LENGTH_SHORT).show()
            }

            viewModel.errorMessage?.let {
                Toast.makeText(context, "خطا: $it", Toast.LENGTH_LONG).show()
            }

        }
    }
}

fun addContact(NationalId: String, PhoneNumber: String, Name: String, Title: String,Location: String, Description: String, context: Context) {

    val configuration = RealmConfiguration.create(schema = setOf(Contact::class))
    val realm = Realm.open(configuration)
    val contact = Contact()
    val all = findContactAll(realm).count()
    val unixTimeMillis = System.currentTimeMillis()


    if (PhoneNumber.length != 11) {
        Toast.makeText(context, "لطفا شماره تماس را به صورت صحیح وارد کنید", Toast.LENGTH_SHORT).show()

    } else if (Name.length != 3) {
        Toast.makeText(context, "نام نباید کمتر از 3 حرف باشد", Toast.LENGTH_SHORT).show()

    } else {
        contact.apply {
            contact_id = NationalId + (all+1).toString()
            phone_number = PhoneNumber
            full_name = Name
            title = Title
            location = Location
            description = Description
            date_insert = unixTimeMillis
        }
//        insertContact(realm,contact)
        Toast.makeText(context, "مخاطب جدید با موفقیت ایجاد شد", Toast.LENGTH_SHORT).show()
    }

}

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=411dp,height=731dp,dpi=480"
)
@Composable
fun CreateContactPreview() {
    AtiselTheme {
        CreateContactScreen()
    }
}