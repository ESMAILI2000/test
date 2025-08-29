package com.enet.sinar.ui.view.student.food

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.R
import com.enet.sinar.ui.theme.Background
import com.enet.sinar.ui.theme.Err
import com.enet.sinar.ui.theme.Gray04
import com.enet.sinar.ui.theme.GrayB
import com.enet.sinar.ui.theme.GrayC
import com.enet.sinar.ui.theme.GrayE
import com.enet.sinar.ui.theme.GrayF
import com.enet.sinar.ui.theme.Green
import com.enet.sinar.ui.theme.Gunmetal
import com.enet.sinar.ui.theme.NationsBlue
import com.enet.sinar.ui.theme.PoliceBlue
import com.enet.sinar.ui.theme.SinarTheme
import com.enet.sinar.ui.theme.Succes
import com.enet.sinar.ui.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationFoodScreen(modifier: Modifier = Modifier){

    var isReserv by remember { mutableStateOf(false) }
    var isSheetAddFood by remember { mutableStateOf(false) }
    var foodType by remember { mutableStateOf("") }
    var suggestedPrice by remember { mutableStateOf("") }
    var pickupLocation by remember { mutableStateOf("") }
    var forgotCode by remember { mutableStateOf("") }
    var isMan by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    val state = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded,
            confirmValueChange = { newValue->
                newValue != SheetValue.Hidden
            },
            skipHiddenState = true
        )
    )

    var isVisibleItem = remember {
        mutableStateListOf(true, false, false, false)
    }
    val itemsFoods = listOf(
        FoodItem("قرمه سبزی","دانشکده هنر",false, painterResource(id = R.drawable.ic_ghorme)),
        FoodItem("چلوکباب","دانشکده مرکزی",true, painterResource(id = R.drawable.ic_kabab)),
        FoodItem("چلوکباب","دانشکده هنر",true, painterResource(id = R.drawable.ic_kabab)),
    )

    BottomSheetScaffold(
        scaffoldState = state ,
        sheetShape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        containerColor = White,
        contentColor = Gray04,
        sheetMaxWidth = 500.dp,
        sheetTonalElevation = 16.dp,
        sheetPeekHeight = 0.dp,
        sheetSwipeEnabled = false,
        sheetDragHandle = {

        },
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    contentAlignment = Alignment.Center
                ){
                    HorizontalDivider(
                        Modifier.width(24.dp),
                        thickness = 4.dp,
                        color = Gray04
                    )
                }
                OutlinedTextField(
                    value = foodType,
                    onValueChange = {
                        foodType = it
                    },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.select_food_type),
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.vc_salad),
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = GrayC,
                        focusedBorderColor = NationsBlue,
                        errorBorderColor = Err,
                        focusedLeadingIconColor = NationsBlue,
                        unfocusedLeadingIconColor = GrayC,
                        errorLeadingIconColor = Err,
                        focusedTextColor = NationsBlue,
                        unfocusedTextColor = GrayC,
                        errorTextColor = Err,
                        focusedPlaceholderColor = NationsBlue,
                        unfocusedPlaceholderColor = GrayC,
                        errorPlaceholderColor = Err,
                        unfocusedTrailingIconColor = GrayC
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =  KeyboardType.Number
                    ),
                    maxLines = 1,
                    modifier = Modifier
                        .size(364.dp,56.dp)
                )

                OutlinedTextField(
                    value = suggestedPrice,
                    onValueChange = {
                        suggestedPrice = it
                    },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.suggested_price),
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.vc_coins),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = GrayC,
                        focusedBorderColor = NationsBlue,
                        errorBorderColor = Err,
                        focusedLeadingIconColor = NationsBlue,
                        unfocusedLeadingIconColor = GrayC,
                        errorLeadingIconColor = Err,
                        focusedTextColor = NationsBlue,
                        unfocusedTextColor = GrayC,
                        errorTextColor = Err,
                        focusedPlaceholderColor = NationsBlue,
                        unfocusedPlaceholderColor = GrayC,
                        errorPlaceholderColor = Err
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =  KeyboardType.Number
                    ),
                    maxLines = 1,
                    modifier = Modifier
                        .size(364.dp,56.dp)
                )

                OutlinedTextField(
                    value = pickupLocation,
                    onValueChange = {
                        pickupLocation = it
                    },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.pickup_location),
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.vc_building_store),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = GrayC,
                        focusedBorderColor = NationsBlue,
                        errorBorderColor = Err,
                        focusedLeadingIconColor = NationsBlue,
                        unfocusedLeadingIconColor = GrayC,
                        errorLeadingIconColor = Err,
                        focusedTextColor = NationsBlue,
                        unfocusedTextColor = GrayC,
                        errorTextColor = Err,
                        focusedPlaceholderColor = NationsBlue,
                        unfocusedPlaceholderColor = GrayC,
                        errorPlaceholderColor = Err
                    ),
                    maxLines = 1,
                    modifier = Modifier
                        .size(364.dp,56.dp)
                )

                OutlinedTextField(
                    value = forgotCode,
                    onValueChange = {
                        forgotCode = it
                    },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.forgot_code),
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.vc_key),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = GrayC,
                        focusedBorderColor = NationsBlue,
                        errorBorderColor = Err,
                        focusedLeadingIconColor = NationsBlue,
                        unfocusedLeadingIconColor = GrayC,
                        errorLeadingIconColor = Err,
                        focusedTextColor = NationsBlue,
                        unfocusedTextColor = GrayC,
                        errorTextColor = Err,
                        focusedPlaceholderColor = NationsBlue,
                        unfocusedPlaceholderColor = GrayC,
                        errorPlaceholderColor = Err
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =  KeyboardType.Number
                    ),
                    maxLines = 1,
                    modifier = Modifier
                        .size(364.dp,56.dp)
                )

                Row(modifier = Modifier
                    .width(364.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    RadioButton(selected = isMan,
                        onClick = {
                            isMan = true
                        },
                        colors =  RadioButtonDefaults. colors(
                            unselectedColor = GrayC,
                            selectedColor = NationsBlue
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(id = R.string.gentlemen),
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                        color = Gunmetal,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    RadioButton(selected = !isMan,
                        onClick = {
                            isMan = false
                        },
                        colors =  RadioButtonDefaults.colors(
                            unselectedColor = GrayC,
                            selectedColor = NationsBlue
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(id = R.string.ladies),
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                        color = Gunmetal,
                    )
                }

                Spacer(modifier = Modifier.size(8.dp))

                Button(
                    onClick = {},
                    Modifier
                        .size(332.dp, 56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults. buttonColors(
                        containerColor = NationsBlue,
                        contentColor = Color.White,
                    )
                ) {
                    Text(stringResource(id = R.string.add_food),
                        fontFamily = FontFamily(Font(R.font.ir_medium)),
                        fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(imageVector = Icons.Default.ArrowForward , contentDescription = null )
                }

                Spacer(modifier = Modifier.width(4.dp))

            }
        })
    {
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
                text = stringResource(id = R.string.food_sale_reservation),
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
                Box(modifier = Modifier
                    .border(1.dp, GrayC, RoundedCornerShape(12.dp))
                    .size(364.dp, 56.dp)
                ){
                    Text(text = stringResource(id = R.string.change_reservation_mode),
                        style = MaterialTheme.typography.bodyLarge,
                        color = PoliceBlue,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .offset(x = -12.dp))

                    Switch(
                        checked =  isReserv ,
                        onCheckedChange = {
                            isReserv = !isReserv
                        },
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .size(48.dp, 24.dp)
                            .offset(x = 12.dp),
                        enabled = true,
                        colors = SwitchDefaults. colors(
                            checkedTrackColor = Green,
                            uncheckedTrackColor = GrayB,
                            checkedThumbColor = White,
                            uncheckedThumbColor = White,
                            checkedBorderColor = Color.Transparent,
                            uncheckedBorderColor = Color.Transparent,
                        )
                    )
                }
                LazyColumn(
                    modifier = Modifier
                        .width(364.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                )
                { items(itemsFoods.size) { page ->
                    Box(modifier = Modifier
                        .width(364.dp)
                        .background(Succes, RoundedCornerShape(16.dp))
                        .pointerInput(Unit) {
                            detectTapGestures {
                                isVisibleItem[page] = !isVisibleItem[page]
                            }
                        }
                    ){
                        Column(
                            modifier = Modifier
                                .width(362.dp)
                                .align(Alignment.CenterEnd)
                                .background(White, RoundedCornerShape(16.dp))
                                .clip(RoundedCornerShape(16.dp))
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
                        ) {
                            Box(modifier = Modifier
                                .width(362.dp)
                                .height(84.dp)
                            ){
                                Box(modifier = Modifier
                                    .size(64.dp)
                                    .align(Alignment.CenterEnd)
                                    .offset(x = -16.dp)
                                    .clip(RoundedCornerShape(16.dp)),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = itemsFoods[page].image,
                                        contentDescription = "",
                                        alpha = 0.64f,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(64.dp)
                                    )
                                    Icon(
                                        painter = painterResource(id = when(itemsFoods[page].isMen){
                                            true -> R.drawable.vc_man
                                            false -> R.drawable.vc_women
                                        }),
                                        contentDescription = "",
                                        tint = White,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .width(128.dp)
                                        .align(Alignment.CenterEnd)
                                        .offset(x = -92.dp),
                                    horizontalAlignment = Alignment.End
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(text = itemsFoods[page].resturanName,
                                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                            color = GrayF
                                        )
                                        Icon(
                                            painter = painterResource(id = R.drawable.vc_building_community),
                                            contentDescription = "",
                                            tint = GrayF,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                    Text(text = itemsFoods[page].foodName,
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = Gunmetal
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .width(128.dp)
                                        .align(Alignment.CenterStart)
                                        .offset(x = 16.dp),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                                    ) {
                                        Text(text = "20",
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = PoliceBlue
                                        )
                                        Text(text = "avsin",
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = PoliceBlue
                                        )
                                    }
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                                    ) {
                                        Text(text = stringResource(id = R.string.toman),
                                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                            color = GrayF
                                        )
                                        Text(text = "10000",
                                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                            color = GrayF
                                        )
                                    }
                                }

                            }

                            AnimatedVisibility(visible = isVisibleItem[page],
                                enter = slideInVertically(
                                    initialOffsetY = { fullHeight -> -fullHeight }, // از بالا وارد شود
                                    animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
                                ),
                                exit = slideOutVertically(
                                    targetOffsetY = { fullHeight -> -fullHeight }, // به بالا خارج شود
                                    animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
                                ),
                                modifier = Modifier
                                    .width(332.dp)
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    HorizontalDivider(
                                        Modifier
                                            .fillMaxWidth(),
                                        thickness = 1.dp,
                                        color = GrayB
                                    )

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                    ){
                                        Box(modifier = Modifier
                                            .size(30.dp)
                                            .background(
                                                NationsBlue.copy(alpha = 0.1f),
                                                RoundedCornerShape(8.dp)
                                            ),
                                            contentAlignment = Alignment.Center
                                        ){
                                            Icon(
                                                painter = painterResource(id = R.drawable.vc_settings),
                                                contentDescription = "",
                                                tint = NationsBlue,
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }

                                        Box(modifier = Modifier
                                            .size(30.dp)
                                            .offset(x = 38.dp)
                                            .background(
                                                Err.copy(alpha = 0.1f),
                                                RoundedCornerShape(8.dp)
                                            ),
                                            contentAlignment = Alignment.Center
                                        ){
                                            Icon(
                                                painter = painterResource(id = R.drawable.vc_trash),
                                                contentDescription = "",
                                                tint = Err,
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }

                                        Row(modifier = Modifier
                                            .size(90.dp, 30.dp)
                                            .offset(x = 76.dp)
                                            .border(1.dp, PoliceBlue, RoundedCornerShape(8.dp)),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.vc_clock_hour),
                                                contentDescription = "",
                                                tint = PoliceBlue,
                                                modifier = Modifier
                                                    .size(18.dp)
                                                    .offset(x = -2.dp)
                                            )
                                            Text(text = "01:21:30",
                                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                                color = PoliceBlue
                                            )
                                        }

                                        Row(modifier = Modifier
                                            .size(106.dp, 30.dp)
                                            .align(Alignment.CenterEnd)
                                            .background(
                                                PoliceBlue.copy(alpha = 0.1f),
                                                RoundedCornerShape(8.dp)
                                            ),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(text = "58947664",
                                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                                color = PoliceBlue
                                            )
                                            Icon(
                                                painter = painterResource(id = R.drawable.vc_qrcode),
                                                contentDescription = "",
                                                tint = PoliceBlue,
                                                modifier = Modifier
                                                    .size(18.dp)
                                                    .offset(x = 2.dp)
                                            )
                                        }
                                    }

                                    Button(
                                        onClick = {},
                                        Modifier
                                            .align(Alignment.CenterHorizontally)
                                            .size(332.dp, 48.dp),
                                        shape = RoundedCornerShape(12.dp),
                                        colors = ButtonDefaults. buttonColors(
                                            containerColor = NationsBlue,
                                            contentColor = Color.White,
                                        )
                                    ) {
                                        Text(stringResource(id = R.string.purchase_food),
                                            fontFamily = FontFamily(Font(R.font.ir_medium)),
                                            fontSize = 14.sp)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Icon(imageVector = Icons.Default.ShoppingCart , contentDescription = null )
                                    }
                                    Spacer(modifier = Modifier.size(1.dp))
                                }

                            }
                        }

                    }
                }

                }
            }

            FloatingActionButton(
                onClick = {
                    scope.launch {
                        scope.launch {  state.bottomSheetState.expand() }
                        isSheetAddFood = true
                    }
                },
                shape = RoundedCornerShape(68.dp),
                contentColor = White,
                containerColor = NationsBlue,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 24.dp
                ),
                modifier = Modifier
                    .size(132.dp, 52.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = -32.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = stringResource(id = R.string.add_food),
                        style = MaterialTheme.typography.bodyLarge,
                        color = White
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Icon(painter = painterResource(id = R.drawable.vc_salad),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp))
                }

            }
        }

        // لایه نیمه‌شفاف وقتی شیت بازه
        if (isSheetAddFood) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .pointerInput(Unit) {
                        detectTapGestures {
                            scope.launch {
                                state.bottomSheetState.partialExpand()
                                isSheetAddFood = false
                            }
                        }
                    } // جلوگیری از تعامل با محتوای اصلی صفحه
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
fun ReservationFoodPreview() {
    SinarTheme {
        ReservationFoodScreen()
    }
}