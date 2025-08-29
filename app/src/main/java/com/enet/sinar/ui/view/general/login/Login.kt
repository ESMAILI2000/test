package com.enet.sinar.ui.view.general.login

import AppSection
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.R
import com.enet.sinar.ui.theme.Background
import com.enet.sinar.ui.theme.Blue200
import com.enet.sinar.ui.theme.Err
import com.enet.sinar.ui.theme.GrayA
import com.enet.sinar.ui.theme.GrayC
import com.enet.sinar.ui.theme.GrayE
import com.enet.sinar.ui.theme.GrayF
import com.enet.sinar.ui.theme.Gunmetal
import com.enet.sinar.ui.theme.NationsBlue
import com.enet.sinar.ui.theme.Primary
import com.enet.sinar.ui.theme.SinarTheme
import com.enet.sinar.ui.utility.MySharedPreferences.getIsEn
import com.enet.sinar.ui.utility.MySharedPreferences.setIsEn
import com.enet.sinar.ui.view.setAppLocale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier,
                onLoginSuccess: (AppSection) -> Unit) {

    var expanded by remember { mutableStateOf(false) }

    var captchaText by remember { mutableStateOf(generateCaptcha()) }

    var phoneNumber by remember { mutableStateOf("")}
    var fullName by remember { mutableStateOf("") }

    var userId by remember { mutableStateOf("") } // شماره دانشجویی یا کد پرسنلی
    var password by remember { mutableStateOf("") }
    var captchaInput by remember { mutableStateOf("") }
    val context = LocalContext.current
    var errorUserId by remember { mutableStateOf(false) }
    var errorPassword by remember { mutableStateOf(false) }
    var errorCapcha by remember { mutableStateOf(false) }
    var errorPhoneNumber by remember { mutableStateOf(false) }
    var isEn by remember { mutableStateOf(getIsEn(context)) }

    val layoutDirection = if (isEn) LayoutDirection.Rtl else LayoutDirection.Ltr
    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        Box(modifier = Modifier
            .background(Background)
            .fillMaxSize()
        ) {

            Column(
                Modifier
                    .width(364.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(bottom = 0.dp, top = 120.dp)
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
                    text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp),
                    fontSize = 18.sp,
                    color = Gunmetal
                )
                Text(
                    text = stringResource(id = R.string.enter_your_information_accurately),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    color = GrayF,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    fontFamily = FontFamily(Font(R.font.ir_bold)),
                    fontSize = 12.sp,
                    overflow = TextOverflow.Clip, // یا .Visible برای اطمینان از نمایش کامل
                )

                Column(
                    Modifier
                        .width(332.dp)
                        .padding(vertical = 20.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    var loginType by remember { mutableStateOf(LoginType.AcademicLogin) }
                    var isAcademic by remember { mutableStateOf(true) }


                    RoleSelector(selectedRole = isAcademic) { selected ->
                        isAcademic = selected
                        if (isAcademic) {
                            loginType = LoginType.AcademicLogin
                        }else {
                            loginType = LoginType.CitizenRegister
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    when(loginType){
                        LoginType.AcademicLogin -> {
                            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
                                OutlinedTextField(
                                    value = userId,
                                    onValueChange = { userId = it },
                                    Modifier
                                        .fillMaxWidth(),
                                    label = { Text(stringResource(id = R.string.student_staff_id),
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp) },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedBorderColor = NationsBlue,
                                        unfocusedBorderColor = GrayC,
                                        focusedLabelColor = NationsBlue,
                                        unfocusedLabelColor = GrayC,
                                        focusedLeadingIconColor = NationsBlue,
                                        unfocusedLeadingIconColor = GrayC,
                                        cursorColor = GrayC,
                                        errorBorderColor = Err,
                                        errorLeadingIconColor = Err,
                                        errorTextColor = Err,
                                        errorLabelColor = Err,
                                        focusedTextColor = NationsBlue,
                                        unfocusedTextColor = GrayC
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.vc_school),
                                            contentDescription = null,
                                        )
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    isError = errorUserId
                                )

                                AnimatedVisibility(
                                    visible = if (errorUserId) true else false,
                                ){
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 8.dp),
                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        Text(
                                            text = stringResource(id = R.string.error_student_id),
                                            Modifier
                                                .fillMaxWidth(0.9f)
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

                                OutlinedTextField(
                                    value = password,
                                    onValueChange = { password = it },
                                    Modifier
                                        .fillMaxWidth(),
                                    label = { Text(stringResource(id = R.string.password),
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp) },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedBorderColor = NationsBlue,
                                        unfocusedBorderColor = GrayC,
                                        focusedLabelColor = NationsBlue,
                                        unfocusedLabelColor = GrayC,
                                        cursorColor = GrayC,
                                        errorBorderColor = Err,
                                        errorLeadingIconColor = Err,
                                        errorTextColor = Err,
                                        errorLabelColor = Err,
                                        focusedLeadingIconColor = NationsBlue,
                                        unfocusedLeadingIconColor = GrayC,
                                        focusedTextColor = NationsBlue,
                                        unfocusedTextColor = GrayC
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.vc_lock_open),
                                            contentDescription = null,
                                        )
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    visualTransformation = PasswordVisualTransformation(),
                                    isError = errorPassword
                                    )

                                Row {
                                    OutlinedTextField(
                                        value = captchaInput,
                                        onValueChange = { captchaInput = it },
                                        Modifier
                                            .fillMaxWidth(0.60f)
                                            .padding(end = 8.dp),
                                        label = { Text(stringResource(id = R.string.enter_the_captcha),
                                            fontFamily = FontFamily(Font(R.font.ir_medium)),
                                            fontSize = 12.sp) },
                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                            focusedBorderColor = NationsBlue,
                                            unfocusedBorderColor = GrayC,
                                            focusedLabelColor = NationsBlue,
                                            unfocusedLabelColor = GrayC,
                                            cursorColor = GrayC,
                                            errorBorderColor = Err,
                                            errorLeadingIconColor = Err,
                                            errorTextColor = Err,
                                            errorLabelColor = Err,
                                            focusedLeadingIconColor = NationsBlue,
                                            unfocusedLeadingIconColor = GrayC,
                                            focusedTextColor = NationsBlue,
                                            unfocusedTextColor = GrayC
                                        ),
                                        leadingIcon = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.vc_shield_half),
                                                contentDescription = null,
                                            )
                                        },
                                        shape = RoundedCornerShape(12.dp)
                                    )

                                    CaptchaImage(captchaText = captchaText)
                                }

                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.Start)
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.forgot_password),
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp,
                                        color = Gunmetal,
                                    )

                                    Text(
                                        stringResource(id = R.string.recover_password),
                                        Modifier
                                            .pointerInput(Unit) {
                                                detectTapGestures {
                                                    /* بازیابی رمز */
                                                }
                                            },
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp,
                                        color = Primary)
                                }

                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = { /* ورود */ },
                                Modifier
                                    .fillMaxWidth()
                                    .size(0.dp, 50.dp),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(stringResource(id = R.string.button_login),
                                    fontFamily = FontFamily(Font(R.font.ir_medium)),
                                    fontSize = 14.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null )
                            }
                        }
                        LoginType.CitizenRegister -> {
                            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){

                                OutlinedTextField(
                                    value = fullName,
                                    onValueChange = { fullName = it },
                                    Modifier
                                        .fillMaxWidth(),
                                    label = { Text(stringResource(id = R.string.full_name),
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp) },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedBorderColor = NationsBlue,
                                        unfocusedBorderColor = GrayC,
                                        focusedLabelColor = NationsBlue,
                                        unfocusedLabelColor = GrayC,
                                        cursorColor = GrayC,
                                        errorBorderColor = Err,
                                        errorLeadingIconColor = Err,
                                        errorTextColor = Err,
                                        errorLabelColor = Err,
                                        focusedLeadingIconColor = NationsBlue,
                                        unfocusedLeadingIconColor = GrayC,
                                        focusedTextColor = NationsBlue,
                                        unfocusedTextColor = GrayC
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.vc_user),
                                            contentDescription = null,
                                        )
                                    },
                                    shape = RoundedCornerShape(12.dp)
                                )

                                OutlinedTextField(
                                    value = phoneNumber,
                                    onValueChange = { phoneNumber = it },
                                    Modifier
                                        .fillMaxWidth(),
                                    label = { Text(stringResource(id = R.string.phone_number),
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp) },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedBorderColor = NationsBlue,
                                        unfocusedBorderColor = GrayC,
                                        focusedLabelColor = NationsBlue,
                                        unfocusedLabelColor = GrayC,
                                        cursorColor = GrayC,
                                        errorBorderColor = Err,
                                        errorLeadingIconColor = Err,
                                        errorTextColor = Err,
                                        errorLabelColor = Err,
                                        focusedLeadingIconColor = NationsBlue,
                                        unfocusedLeadingIconColor = GrayC,
                                        focusedTextColor = NationsBlue,
                                        unfocusedTextColor = GrayC
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.vc_phone_call),
                                            contentDescription = null,
                                        )
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    isError = errorPhoneNumber
                                )

                                OutlinedTextField(
                                    value = password,
                                    onValueChange = { password = it },
                                    Modifier
                                        .fillMaxWidth(),
                                    label = { Text(stringResource(id = R.string.password),
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp) },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedBorderColor = NationsBlue,
                                        unfocusedBorderColor = GrayC,
                                        focusedLabelColor = NationsBlue,
                                        unfocusedLabelColor = GrayC,
                                        cursorColor = GrayC,
                                        errorBorderColor = Err,
                                        errorLeadingIconColor = Err,
                                        errorTextColor = Err,
                                        errorLabelColor = Err,
                                        focusedLeadingIconColor = NationsBlue,
                                        unfocusedLeadingIconColor = GrayC,
                                        focusedTextColor = NationsBlue,
                                        unfocusedTextColor = GrayC
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.vc_lock_open),
                                            contentDescription = null,
                                        )
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    visualTransformation = PasswordVisualTransformation(),
                                    isError = errorPassword
                                    )

                                Row {
                                    OutlinedTextField(
                                        value = captchaInput,
                                        onValueChange = { captchaInput = it },
                                        Modifier
                                            .fillMaxWidth(0.60f)
                                            .padding(end = 8.dp),
                                        label = { Text(stringResource(id = R.string.enter_the_captcha),
                                            fontFamily = FontFamily(Font(R.font.ir_medium)),
                                            fontSize = 12.sp) },
                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                            focusedBorderColor = NationsBlue,
                                            unfocusedBorderColor = GrayC,
                                            focusedLabelColor = NationsBlue,
                                            unfocusedLabelColor = GrayC,
                                            cursorColor = GrayC,
                                            errorBorderColor = Err,
                                            errorLeadingIconColor = Err,
                                            errorTextColor = Err,
                                            errorLabelColor = Err,
                                            focusedLeadingIconColor = NationsBlue,
                                            unfocusedLeadingIconColor = GrayC,
                                            focusedTextColor = NationsBlue,
                                            unfocusedTextColor = GrayC
                                        ),
                                        leadingIcon = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.vc_shield_half),
                                                contentDescription = null,
                                            )
                                        },
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    CaptchaImage(captchaText = captchaText)
                                }


                                var accepted by remember { mutableStateOf(false) }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start,
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .fillMaxWidth()
                                        .padding(0.dp)
                                ) {

                                    Checkbox(
                                        checked = accepted,
                                        onCheckedChange = { accepted = it },
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = Primary, // رنگ پس‌زمینه وقتی تیک خورده
                                            uncheckedColor = GrayC,      // رنگ وقتی خالیه
                                            checkmarkColor = Color.White     // رنگ تیک داخل چک‌باکس
                                        )
                                    )
                                    Text(text = stringResource(id = R.string.checkbox_terms0), style = MaterialTheme.typography.bodyMedium)

                                    Text(
                                        text = stringResource(id = R.string.checkbox_terms1),
                                        color = Color.Blue,
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .pointerInput(Unit) {
                                                detectTapGestures {
                                                    /* صفحه قوانین و مقررات */
                                                }
                                            }
                                            .padding(start = 4.dp)
                                    )
                                    Text(text = stringResource(id = R.string.checkbox_terms2),
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp)
                                }

                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = { /* ورود */ },
                                Modifier
                                    .fillMaxWidth()
                                    .size(0.dp, 50.dp),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonColors(
                                    containerColor = GrayA,
                                    contentColor = GrayE,
                                    disabledContentColor = GrayA,
                                    disabledContainerColor = GrayE
                                )
                            ) {
                                Text(stringResource(id = R.string.create_account),
                                    fontFamily = FontFamily(Font(R.font.ir_medium)),
                                    fontSize = 14.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null )
                            }
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .padding(top = 24.dp)
                                    .fillMaxWidth()
                                    .padding(0.dp)
                            ) {
                                Text(
                                    text = stringResource(id = R.string.login),
                                    color = Primary,
                                    fontFamily = FontFamily(Font(R.font.ir_bold)),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .pointerInput(Unit) {
                                            detectTapGestures {
                                                loginType = LoginType.CitizenLogin
                                            }
                                        }
                                        .padding(end = 4.dp)
                                )
                                Icon(painter = painterResource(id = R.drawable.vc_login), contentDescription = null,
                                    Modifier.size(30.dp),
                                    tint = Primary)
                            }
                        }
                        LoginType.CitizenLogin -> {
                            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){

                                OutlinedTextField(
                                    value = phoneNumber,
                                    onValueChange = { phoneNumber = it },
                                    Modifier
                                        .fillMaxWidth(),
                                    label = { Text(stringResource(id = R.string.phone_number),
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp) },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedBorderColor = NationsBlue,
                                        unfocusedBorderColor = GrayC,
                                        focusedLabelColor = NationsBlue,
                                        unfocusedLabelColor = GrayC,
                                        cursorColor = GrayC,
                                        errorBorderColor = Err,
                                        errorLeadingIconColor = Err,
                                        errorTextColor = Err,
                                        errorLabelColor = Err,
                                        focusedLeadingIconColor = NationsBlue,
                                        unfocusedLeadingIconColor = GrayC,
                                        focusedTextColor = NationsBlue,
                                        unfocusedTextColor = GrayC
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.vc_phone_call),
                                            contentDescription = null,
                                        )
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    isError = errorPhoneNumber
                                )

                                OutlinedTextField(
                                    value = password,
                                    onValueChange = { password = it },
                                    Modifier
                                        .fillMaxWidth(),
                                    label = { Text(stringResource(id = R.string.password),
                                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                                        fontSize = 12.sp) },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        focusedBorderColor = NationsBlue,
                                        unfocusedBorderColor = GrayC,
                                        focusedLabelColor = NationsBlue,
                                        unfocusedLabelColor = GrayC,
                                        cursorColor = GrayC,
                                        errorBorderColor = Err,
                                        errorLeadingIconColor = Err,
                                        errorTextColor = Err,
                                        errorLabelColor = Err,
                                        focusedLeadingIconColor = NationsBlue,
                                        unfocusedLeadingIconColor = GrayC,
                                        focusedTextColor = NationsBlue,
                                        unfocusedTextColor = GrayC
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.vc_lock_open),
                                            contentDescription = null,
                                        )
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    visualTransformation = PasswordVisualTransformation(),
                                    isError = errorPassword
                                    )

                                Row {
                                    OutlinedTextField(
                                        value = captchaInput,
                                        onValueChange = { captchaInput = it },
                                        Modifier
                                            .fillMaxWidth(0.60f)
                                            .padding(end = 8.dp),
                                        label = { Text(stringResource(id = R.string.enter_the_captcha),
                                            fontFamily = FontFamily(Font(R.font.ir_medium)),
                                            fontSize = 12.sp) },
                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                            focusedBorderColor = NationsBlue,
                                            unfocusedBorderColor = GrayC,
                                            focusedLabelColor = NationsBlue,
                                            unfocusedLabelColor = GrayC,
                                            cursorColor = GrayC,
                                            errorBorderColor = Err,
                                            errorLeadingIconColor = Err,
                                            errorTextColor = Err,
                                            errorLabelColor = Err,
                                            focusedLeadingIconColor = NationsBlue,
                                            unfocusedLeadingIconColor = GrayC,
                                            focusedTextColor = NationsBlue,
                                            unfocusedTextColor = GrayC
                                        ),
                                        leadingIcon = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.vc_shield_half),
                                                contentDescription = null,
                                            )
                                        },
                                        shape = RoundedCornerShape(12.dp),
                                        isError = errorCapcha,
                                    )

                                    CaptchaImage(captchaText = captchaText)
                                }

                            }

                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {
                                    errorCapcha = captchaInput != captchaText
                                    if (!errorCapcha){
                                        onLoginSuccess(AppSection.Student)
                                    }else{

                                    }
                                },
                                Modifier
                                    .fillMaxWidth()
                                    .size(0.dp, 50.dp),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonColors(
                                    containerColor = GrayA,
                                    contentColor = GrayE,
                                    disabledContentColor = GrayA,
                                    disabledContainerColor = GrayE
                                )
                            ) {
                                Text(stringResource(id = R.string.login),
                                    fontFamily = FontFamily(Font(R.font.ir_medium)),
                                    fontSize = 14.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null )
                            }
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .padding(top = 24.dp)
                                    .fillMaxWidth()
                                    .padding(0.dp)
                            ) {
                                Text(
                                    text = stringResource(id = R.string.create_account),
                                    color = Primary,
                                    fontFamily = FontFamily(Font(R.font.ir_medium)),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .pointerInput(Unit) {
                                            detectTapGestures {
                                                loginType = LoginType.CitizenRegister
                                            }
                                        }
                                        .padding(end = 4.dp)
                                )
                                Icon(imageVector = Icons.Default.Add, contentDescription = null,
                                    Modifier.size(30.dp),
                                    tint = Primary)
                            }
                        }
                    }

                }


            }

            Row(
                Modifier
                    .fillMaxHeight(0.1f)
                    .padding(top = 56.dp, end = 24.dp)
                    .align(Alignment.TopEnd)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Blue200)
                    .pointerInput(Unit){
                        detectTapGestures {
                            if (getIsEn(context)){
                                val newContext = context.setAppLocale("fa") //
                                setIsEn(context,false)
                            } else {
                                val newContext = context.setAppLocale("en") // یا "fa"
                                setIsEn(context,true)
                            }

                        }
                    }
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Gunmetal,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )
//            Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "فارسی",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontFamily = FontFamily(Font(R.font.ir_medium)),
                    fontSize = 12.sp,
                    color = Gunmetal
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(R.mipmap.ic_iran_background), contentDescription = "logo",
                    Modifier
                        .size(24.dp, 24.dp),
                )
            }
            Text(
                text = stringResource(id = R.string.app_version),
                Modifier
                    .padding(bottom = 54.dp, end = 0.dp)
                    .align(Alignment.BottomCenter),
                color = Gunmetal,
                fontFamily = FontFamily(Font(R.font.ir_medium)),
                fontSize = 14.sp
            )
        }
    }

    }


@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=412dp,height=917dp,dpi=480"
)
@Composable
fun LoginPreview() {
    SinarTheme {
        LoginScreen(onLoginSuccess = {AppSection.Student} )
    }
}