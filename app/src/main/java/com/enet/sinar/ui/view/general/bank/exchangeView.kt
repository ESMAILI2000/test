package com.enet.sinar.ui.view.general.bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.R
import com.enet.sinar.ui.theme.Background
import com.enet.sinar.ui.theme.EerieBlack
import com.enet.sinar.ui.theme.Gray04
import com.enet.sinar.ui.theme.GrayC
import com.enet.sinar.ui.theme.GrayD
import com.enet.sinar.ui.theme.Gunmetal
import com.enet.sinar.ui.theme.NationsBlue
import com.enet.sinar.ui.theme.PoliceBlue
import com.enet.sinar.ui.theme.SinarTheme
import com.enet.sinar.ui.theme.Succes
import com.enet.sinar.ui.theme.Water
import com.enet.sinar.ui.theme.White
import com.enet.sinar.ui.view.DashedContainer
import com.enet.sinar.ui.view.EllipsizedMiddleText
import com.enet.sinar.ui.view.student.home.HexagonShape

@Composable
fun BankScreen(modifier: Modifier = Modifier){

    var state by remember { mutableStateOf(3) } // 0-> انتقال توکن  1-> خرید توکن  2-> فروش توکن  3-> شارژ باتری

    var isBatriLowRadio by remember { mutableStateOf(false) }
    var isCardLowRadio by remember { mutableStateOf(true) }
    var amountToken by remember { mutableStateOf("") }
    var walletAddress by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Gunmetal,
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .size(24.dp)
        )
        Text(
            text = "صرافی",
            style = MaterialTheme.typography.displayLarge.copy(fontSize = 16.sp),
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .align(Alignment.TopEnd)
        )
        Column(
            modifier = Modifier
                .padding(top = 56.dp)
                .fillMaxSize()
                .background(White, RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Spacer(modifier = Modifier.size(24.dp))

            Row(
                modifier = Modifier
                    .size(364.dp,94.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DashedContainer(
                        modifier = Modifier
                            .size(64.dp)
                            .background(White, shape = RoundedCornerShape(32.dp)),
                        cornerRadius = 32.dp,
                        borderColor = if (state == 3) Water else GrayD,
                        strokeWidth = 1.dp,
                        gapLength = if (state == 3) 0.dp else 8.dp
                    ){
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    state = 3
                                }
                            }
                            .background(
                                if (state == 3) NationsBlue.copy(alpha = 0.1f) else White,
                                CircleShape
                            ),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(painter = painterResource(id = R.drawable.vc_batri) ,
                                contentDescription = "",
                                tint = if (state == 3) NationsBlue else GrayC,
                                modifier = Modifier
                                    .size(32.dp)
                                    .padding(2.dp)
                            )
                        }
                    }

                    Text(
                        text = stringResource(id = R.string.battery_charging_button),
                        style = MaterialTheme.typography.labelSmall,
                        color = if (state == 3) NationsBlue else GrayD
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DashedContainer(
                        modifier = Modifier
                            .size(64.dp)
                            .background(White, shape = RoundedCornerShape(32.dp)),
                        cornerRadius = 32.dp,
                        borderColor = if (state == 2) Water else GrayD,
                        strokeWidth = 1.dp,
                        gapLength = if (state == 2) 0.dp else 8.dp
                    ){
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    state = 2
                                }
                            }
                            .background(
                                if (state == 2) NationsBlue.copy(alpha = 0.1f) else White,
                                CircleShape
                            ),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(painter = painterResource(id = R.drawable.vc_arrow_left_bottom) ,
                                contentDescription = "",
                                tint = if (state == 2) NationsBlue else GrayC,
                                modifier = Modifier
                                    .size(32.dp)
                                    .padding(2.dp)
                            )
                        }
                    }

                    Text(
                        text = stringResource(id = R.string.token_sell_button),
                        style = MaterialTheme.typography.labelSmall,
                        color = if (state == 2) NationsBlue else GrayD
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DashedContainer(
                        modifier = Modifier
                            .size(64.dp)
                            .background(White, shape = RoundedCornerShape(32.dp)),
                        cornerRadius = 32.dp,
                        borderColor = if (state == 1) Water else GrayD,
                        strokeWidth = 1.dp,
                        gapLength = if (state == 1) 0.dp else 8.dp
                    ){
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    state = 1
                                }
                            }
                            .background(
                                if (state == 1) NationsBlue.copy(alpha = 0.1f) else White,
                                CircleShape
                            ),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(painter = painterResource(id = R.drawable.vc_arrow_right_top) ,
                                contentDescription = "",
                                tint = if (state == 1) NationsBlue else GrayC,
                                modifier = Modifier
                                    .size(32.dp)
                                    .padding(2.dp)
                            )
                        }
                    }

                    Text(
                        text = stringResource(id = R.string.token_buy_button),
                        style = MaterialTheme.typography.labelSmall,
                        color = if (state == 1) NationsBlue else GrayD
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DashedContainer(
                        modifier = Modifier
                            .size(64.dp)
                            .background(White, shape = RoundedCornerShape(32.dp)),
                        cornerRadius = 32.dp,
                        borderColor = if (state == 0) Water else GrayD,
                        strokeWidth = 1.dp,
                        gapLength = if (state == 0) 0.dp else 8.dp
                    ){
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    state = 0
                                }
                            }
                            .background(
                                if (state == 0) NationsBlue.copy(alpha = 0.1f) else White,
                                CircleShape
                            ),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(painter = painterResource(id = R.drawable.vc_arrow_top) ,
                                contentDescription = "",
                                tint = if (state == 0) NationsBlue else GrayC,
                                modifier = Modifier
                                    .size(32.dp)
                                    .padding(2.dp)
                            )
                        }
                    }

                    Text(
                        text = stringResource(id = R.string.token_transfer_button),
                        style = MaterialTheme.typography.labelSmall,
                        color = if (state == 0) NationsBlue else GrayD
                        )
                }

            }

            Spacer(modifier = Modifier.size(1.dp))

            if (state == 3){
                Column(
                    Modifier
                        .width(364.dp)
                        .border(1.dp, GrayC, RoundedCornerShape(16.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.size(20.dp))

                    Row(
                        Modifier
                            .size(324.dp, 60.dp)
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                ),
                                clip = false
                            ),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(modifier = Modifier
                            .size(154.dp, 60.dp)
                            .background(White, RoundedCornerShape(12.dp)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ){
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "",
                                tint = EerieBlack,
                                modifier = Modifier.size(16.dp)

                            )

                            Text(text = "ریحانه کشاورز حداد",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = Gunmetal
                            )

                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(HexagonShape())
                            )

                        }

                        Row(modifier = Modifier
                            .size(154.dp, 60.dp)
                            .background(White, RoundedCornerShape(12.dp)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ){
                            Text(text = "توکن از حساب",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = PoliceBlue
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.vc_user),
                                contentDescription = "",
                                tint = PoliceBlue,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.size(16.dp))
                        }

                    }

                    Spacer(modifier = Modifier.size(24.dp))

                    Column(
                        Modifier
                            .width(324.dp)
                            .background(White, RoundedCornerShape(12.dp))
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                ),
                                clip = false
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.size(16.dp))
                        Row(
                            Modifier.width(292.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(text = " (سینار)",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = NationsBlue)

                            Text(text = " : مقدار توکن",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = PoliceBlue)
                        }

                        Spacer(modifier = Modifier.size(4.dp))

                        TextField(
                            value = amountToken, onValueChange ={
                                amountToken = it
                            },
                            textStyle = MaterialTheme.typography.displayLarge.copy(fontSize = 16.sp, textAlign = TextAlign.Center),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.vc_b_price) , contentDescription = "" ,
                                    tint = NationsBlue,
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            colors =  TextFieldDefaults.colors(
                                focusedContainerColor = NationsBlue.copy(alpha = 0.1f),
                                unfocusedContainerColor = NationsBlue.copy(alpha = 0.1f),
                                focusedTextColor = Gunmetal,
                                unfocusedTextColor = Gunmetal,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(
                                autoCorrect = false,
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier
                                .size(292.dp, 48.dp)
                                .border(1.dp, NationsBlue, RoundedCornerShape(12.dp))
                        )

                        Spacer(modifier = Modifier.size(16.dp))

                        Button(
                            onClick = {},
                            Modifier
                                .align(Alignment.CenterHorizontally)
                                .size(292.dp, 48.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults. buttonColors(
                                containerColor = NationsBlue,
                                contentColor = Color.White,
                            )
                        ) {
                            Text(
                                text = stringResource(id = R.string.battery_charging_button),
                                fontFamily = FontFamily(Font(R.font.ir_medium)),
                                fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(imageVector = Icons.Default.ArrowForward , contentDescription = null )
                        }

                        Spacer(modifier = Modifier.size(16.dp))
                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    Column(
                        Modifier
                            .width(324.dp)
                            .background(White, RoundedCornerShape(12.dp))
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                ),
                                clip = false
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(
                            Modifier
                                .width(167.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "",
                                modifier = Modifier.size(24.dp)
                            )
                            Text(text = "پیشنهادات ویژه",
                                style = MaterialTheme.typography.bodyLarge,
                                color = Gunmetal
                            )
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        
                        HorizontalDivider(
                            modifier = Modifier.width(269.dp),
                            thickness = 1.dp,
                            color = Gray04
                            )

                        LazyColumn (
                            modifier = Modifier
                                .width(292.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ){

                        }
                    }

                    Spacer(modifier = Modifier.size(20.dp))
                }
            } else {
                Column(
                    Modifier
                        .width(364.dp)
                        .border(1.dp, GrayC, RoundedCornerShape(16.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.size(20.dp))

                    Row(
                        Modifier
                            .size(324.dp, 60.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Box(modifier = Modifier
                            .size(154.dp, 60.dp)
                            .background(White, RoundedCornerShape(12.dp))
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                ),
                                clip = false
                            )
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.vc_binance_coin_bnb_logo),
                                contentDescription ="",
                                modifier = Modifier
                                    .size(27.dp)
                                    .align(Alignment.CenterEnd)
                                    .offset(x = -18.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                                    .offset(x = -49.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(text = "شبکه",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                    color = GrayD
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowLeft,
                                        contentDescription = "",
                                        tint = EerieBlack,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(text = "بایننس (BNB)",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Gunmetal
                                    )

                                }
                            }
                        }

                        Box(modifier = Modifier
                            .size(154.dp, 60.dp)
                            .background(White, RoundedCornerShape(12.dp))
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                ),
                                clip = false
                            )
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.vc_tether_usdt_logo),
                                contentDescription ="",
                                modifier = Modifier
                                    .size(27.dp)
                                    .align(Alignment.CenterEnd)
                                    .offset(x = -18.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                                    .offset(x = -49.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(text = "توکن",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                    color = GrayD
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowLeft,
                                        contentDescription = "",
                                        tint = EerieBlack,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(text = "تتر",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Gunmetal
                                    )

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    Row(
                        Modifier
                            .size(324.dp, 60.dp)
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                ),
                                clip = false
                            ),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(modifier = Modifier
                            .size(154.dp, 60.dp)
                            .background(White, RoundedCornerShape(12.dp)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ){
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "",
                                tint = EerieBlack,
                                modifier = Modifier.size(16.dp)

                            )

                            Text(text = "ریحانه کشاورز حداد",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = Gunmetal
                            )

                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(HexagonShape())
                            )

                        }

                        Row(modifier = Modifier
                            .size(154.dp, 60.dp)
                            .background(White, RoundedCornerShape(12.dp)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ){
                            Text(text = "توکن از حساب",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = PoliceBlue
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.vc_user),
                                contentDescription = "",
                                tint = PoliceBlue,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.size(16.dp))
                        }

                    }

                    Spacer(modifier = Modifier.size(24.dp))

                    Column(
                        Modifier
                            .width(324.dp)
                            .background(White, RoundedCornerShape(12.dp))
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                ),
                                clip = false
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.size(16.dp))
                        Box(
                            Modifier.width(292.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Text(text = ": مقدار توکن",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = PoliceBlue)
                        }

                        Spacer(modifier = Modifier.size(4.dp))

                        TextField(
                            value = amountToken, onValueChange ={
                                amountToken = it
                            },
                            textStyle = MaterialTheme.typography.displayLarge.copy(fontSize = 16.sp, textAlign = TextAlign.Center),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.vc_b_price) , contentDescription = "" ,
                                    tint = NationsBlue,
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            colors =  TextFieldDefaults.colors(
                                focusedContainerColor = NationsBlue.copy(alpha = 0.1f),
                                unfocusedContainerColor = NationsBlue.copy(alpha = 0.1f),
                                focusedTextColor = Gunmetal,
                                unfocusedTextColor = Gunmetal,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(
                                autoCorrect = false,
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier
                                .size(292.dp, 48.dp)
                                .border(1.dp, NationsBlue, RoundedCornerShape(12.dp))
                        )
                        
                        Spacer(modifier = Modifier.size(4.dp))
                        Row(
                            Modifier.width(292.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(text = "تومان",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = NationsBlue)

                            Text(text = "3350000",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = NationsBlue)
                        }

                        Spacer(modifier = Modifier.size(8.dp))

                        if (state == 0){ // انتقال توکن
                            Box(
                                Modifier.width(292.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(text = ": آدرس ولت گیرنده",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                    color = PoliceBlue)
                            }
                            Spacer(modifier = Modifier.size(4.dp))

                            TextField(
                                value = walletAddress, onValueChange ={
                                    walletAddress = it
                                },
                                textStyle = MaterialTheme.typography.displayLarge.copy(
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                ),
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.vc_wallet) ,
                                        contentDescription = "" ,
                                        tint = NationsBlue,
                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                },
                                singleLine = true,
                                shape = RoundedCornerShape(12.dp),
                                colors =  TextFieldDefaults.colors(
                                    focusedContainerColor = NationsBlue.copy(alpha = 0.1f),
                                    unfocusedContainerColor = NationsBlue.copy(alpha = 0.1f),
                                    focusedTextColor = Gunmetal,
                                    unfocusedTextColor = Gunmetal,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                modifier = Modifier
                                    .size(292.dp, 48.dp)
                                    .border(1.dp, NationsBlue, RoundedCornerShape(12.dp))
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                        } else if (state == 2){ // فروش توکن
                            Box(
                                Modifier.width(292.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(text = ": شماره کارت یا شبا",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                    color = PoliceBlue)
                            }
                            Spacer(modifier = Modifier.size(4.dp))

                            TextField(
                                value = cardNumber, onValueChange ={
                                    cardNumber = it
                                },
                                textStyle = MaterialTheme.typography.displayLarge.copy(
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                ),
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_mellat),
                                        contentDescription = "" ,
                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.vc_credit_card) ,
                                        contentDescription = "" ,
                                        tint = NationsBlue,
                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                },
                                singleLine = true,
                                shape = RoundedCornerShape(12.dp),
                                colors =  TextFieldDefaults.colors(
                                    focusedContainerColor = NationsBlue.copy(alpha = 0.1f),
                                    unfocusedContainerColor = NationsBlue.copy(alpha = 0.1f),
                                    focusedTextColor = Gunmetal,
                                    unfocusedTextColor = Gunmetal,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                modifier = Modifier
                                    .size(292.dp, 48.dp)
                                    .border(1.dp, NationsBlue, RoundedCornerShape(12.dp))
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                        }

                        Box(modifier = Modifier
                            .width(292.dp)
                        ){
                            RadioButton(selected = isBatriLowRadio,
                                onClick = {
                                    isCardLowRadio = false
                                    isBatriLowRadio = true
                                },
                                modifier = Modifier.align(Alignment.CenterEnd),
                                colors =  RadioButtonDefaults. colors(
                                    unselectedColor = GrayC,
                                    selectedColor = NationsBlue
                                )
                            )

                            Text(text = "از باتری کم شود",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = Gunmetal,
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                                    .offset(x = -38.dp)
                            )

                            Row(
                                modifier = Modifier
                                    .size(63.dp, 26.dp)
                                    .align(Alignment.CenterStart)
                                    .background(Succes.copy(alpha = 0.1f), RoundedCornerShape(6.dp)),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(text = "انرژی",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                    color = Succes
                                )
                                Text(text = " 80%",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                    color = Succes
                                )
                            }
                        }

                        Box(modifier = Modifier
                            .width(292.dp)
                        ){
                            RadioButton(selected = isCardLowRadio,
                                onClick = {
                                    isCardLowRadio = true
                                    isBatriLowRadio = false
                                },
                                modifier = Modifier.align(Alignment.CenterEnd),
                                colors =  RadioButtonDefaults. colors(
                                    unselectedColor = GrayC,
                                    selectedColor = NationsBlue
                                )
                            )

                            Text(text = "از کارت کم شود",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                color = Gunmetal,
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                                    .offset(x = -38.dp)
                            )

                            Row(
                                modifier = Modifier
                                    .align(Alignment.CenterStart),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Text(text = "0",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 10.sp),
                                    color = PoliceBlue
                                )
                                Text(text = " avsin: کارمزد تراکنش",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 10.sp),
                                    color = PoliceBlue
                                )
                            }
                        }


                        Spacer(modifier = Modifier.size(16.dp))

                        Button(
                            onClick = {},
                            Modifier
                                .align(Alignment.CenterHorizontally)
                                .size(292.dp, 48.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults. buttonColors(
                                containerColor = NationsBlue,
                                contentColor = Color.White,
                            )
                        ) {
                            Text(
                                text = if (state == 0) { stringResource(id = R.string.token_transfer_button)
                                } else if (state == 1) {
                                    stringResource(id = R.string.token_buy_button)
                                } else {
                                    stringResource(id = R.string.token_sell_button)
                                },
                                fontFamily = FontFamily(Font(R.font.ir_medium)),
                                fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(imageVector = Icons.Default.ArrowForward , contentDescription = null )
                        }
                        Spacer(modifier = Modifier.size(16.dp))
                    }

                    Spacer(modifier = Modifier.size(20.dp))
                }
            }
         
        }
    }
}

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=412dp,height=917dp,dpi=480"
)
@Composable
fun BankPreview() {
    SinarTheme {
        BankScreen()
    }
}
