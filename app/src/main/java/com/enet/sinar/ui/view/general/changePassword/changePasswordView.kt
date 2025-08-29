package com.enet.sinar.ui.view.general.changePassword

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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
import com.enet.sinar.ui.theme.Succes
import com.enet.sinar.ui.view.custom_view.BoxedTextInput
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePasswordScreen(modifier: Modifier = Modifier) {


    var otpCode by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var rePassword by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf(false) }
    var time by rememberSaveable { mutableStateOf(30) }
    var step by rememberSaveable { mutableStateOf(1) } // 1 -> وارد کردن شماره تلفن 2-> وارد کردن کد 3-> وارد کردن رمز جدید

    var isSuccessOtp by remember { mutableStateOf(false) }
    var enableButton by remember { mutableStateOf(true) }


    if (otpCode.length == 5){
       if (otpCode == "11111"){
           isSuccessOtp = true
           error = false
           time = 0
           enableButton = true
           step = 3
       }else{
           isSuccessOtp = false
           error = true
       }
    }

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
                .align(Alignment.Center)
//                .padding(bottom = 0.dp, top =  290.dp)
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
                text = stringResource(
                    id = R.string.password_recovery
                ),
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp),
                fontSize = 18.sp,
                color = Gunmetal
            )
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text(text = if (step == 3)"تبریک! گذرواژه جدید خود را وارد کنید" else "لطفا شماره تلفن خود را با دقت پر کنید", style = MaterialTheme.typography.labelSmall,color = GrayF)
                }
            }


            Column(
                Modifier
                    .width(332.dp)
                    .padding(vertical = 20.dp)
                    .align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
                    OutlinedTextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = NationsBlue,
                            unfocusedBorderColor = GrayC,
                            focusedLabelColor = NationsBlue,
                            unfocusedLabelColor = GrayC,
                            focusedLeadingIconColor = NationsBlue,
                            unfocusedLeadingIconColor = GrayC,
//                            cursorColor = NationsBlue,
                            focusedTextColor = NationsBlue
                        ),
                        placeholder = {
                            Text(stringResource(
                                id = R.string.get_code
                            ),
                                fontFamily = FontFamily(Font(R.font.ir_medium)),
                                color = GrayC,
                                fontSize = 12.sp)
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.vc_phone_call),
                                contentDescription = null,
//                                tint = GrayC
                            )
                        },
                        shape = RoundedCornerShape(12.dp)
                    )
                }
                AnimatedVisibility(
                    visible = if (step != 1) true else false,
                ){
                    BoxedTextInput(
                        value = otpCode,
                        length = 5,
                        onValueChange = { otpCode = it },
                        Modifier
                            .padding(top = 8.dp)
                            .align(Alignment.CenterHorizontally),
                        textBorderShape = RoundedCornerShape(12.dp),
                        textArrangement = Arrangement.spacedBy(4.dp),
                        textStyle = TextStyle(fontSize = 18.sp, color = if (error) Err else if (isSuccessOtp) Succes else NationsBlue),
                        emptyTextBorderColor = GrayC,
                        filledTextBorderColor = if (error) Err else if (isSuccessOtp) Succes else NationsBlue,
                        backgroundColor = if (error) Color.Transparent else if (isSuccessOtp) Color.Transparent else Background ,
                        keyboardOptions = KeyboardOptions(
                            autoCorrect = false,
                            keyboardType = KeyboardType.NumberPassword
                        ),
                    )
                }
                AnimatedVisibility(
                    visible = if (error) true else false,
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "!کد وارد شده اشتباه است",
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
                AnimatedVisibility(
                    visible = if (enableButton && step != 2) false else true,
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
                                    text =  stringResource(
                                        id = R.string.resend_after
                                    ),
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

                AnimatedVisibility(
                    visible = if (step == 3) true else false,
                ){
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ){

                        Column {
                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                Modifier
                                    .fillMaxWidth(),
                                label = { Text( stringResource(
                                    id = R.string.new_password
                                ),
                                    fontFamily = FontFamily(Font(R.font.ir_medium)),
                                    fontSize = 12.sp) },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = GrayC,
                                    unfocusedBorderColor = GrayC,
                                    focusedLabelColor = GrayC,
                                    unfocusedLabelColor = GrayC,
                                    cursorColor = GrayC
                                ),
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.vc_lock_open),
                                        contentDescription = null,
                                        tint = GrayC
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.vc_eye_off),
                                        contentDescription = null,
                                        tint = GrayC
                                    )
                                },
                                shape = RoundedCornerShape(12.dp),
                                visualTransformation = PasswordVisualTransformation(),

                                )

                            OutlinedTextField(
                                value = rePassword,
                                onValueChange = { rePassword = it },
                                Modifier
                                    .fillMaxWidth(),
                                label = { Text(stringResource(
                                    id = R.string.confirm_new_password
                                ),
                                    fontFamily = FontFamily(Font(R.font.ir_medium)),
                                    fontSize = 12.sp) },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = GrayC,
                                    unfocusedBorderColor = GrayC,
                                    focusedLabelColor = GrayC,
                                    unfocusedLabelColor = GrayC,
                                    cursorColor = GrayC
                                ),
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.vc_lock_open),
                                        contentDescription = null,
                                        tint = GrayC
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.vc_eye_off),
                                        contentDescription = null,
                                        tint = GrayC
                                    )
                                },
                                shape = RoundedCornerShape(12.dp),
                                visualTransformation = PasswordVisualTransformation(),

                                )
                        }

                    }
                }


                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        if (step == 1){
                            step = 2
                            enableButton = false
                        } else if (step == 2){
//                        error = !error
                            // وقتی ستاپ 3 میشود که کد را درست وارد کند
                            time = 30
                        } else {
                            step = 1
                        }
                      },
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
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
                    Text( if (step == 1) stringResource(
                        id = R.string.get_code
                    ) else if (step == 2)stringResource(
                        id = R.string.resend
                    ) else  stringResource(
                        id = R.string.change_password
                    ),
                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    val iconButton = if (step == 1) Icons.Default.ArrowForward  else Icons.Default.Done

                    AnimatedVisibility(
                        visible = if (step != 2 ) true else false
                    ){
                        Icon(imageVector = iconButton , contentDescription = null )
                    }
                    AnimatedVisibility(
                        visible = if (step == 2 ) true else false
                    ){
                        Icon(painter = painterResource(R.drawable.vc_refresh) , contentDescription = null)
                    }


                }

            }


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


@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=412dp,height=917dp,dpi=480"
)
@Composable
fun ChangePasswordPreview() {
    SinarTheme {
        ChangePasswordScreen()
    }
}