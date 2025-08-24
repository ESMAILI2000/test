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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.R
import com.enet.sinar.ui.theme.Background
import com.enet.sinar.ui.theme.Err
import com.enet.sinar.ui.theme.GrayB
import com.enet.sinar.ui.theme.GrayC
import com.enet.sinar.ui.theme.GrayF
import com.enet.sinar.ui.theme.Green
import com.enet.sinar.ui.theme.Gunmetal
import com.enet.sinar.ui.theme.NationsBlue
import com.enet.sinar.ui.theme.PoliceBlue
import com.enet.sinar.ui.theme.SinarTheme
import com.enet.sinar.ui.theme.Succes
import com.enet.sinar.ui.theme.White

@Composable
fun ReservationFoodScreen(modifier: Modifier = Modifier){

    var isReserv by remember { mutableStateOf(false) }
    var isVisibleItem = remember {
        mutableStateListOf(true, false, false, false)
    }

    val itemsFoods = listOf(
        FoodItem("قرمه سبزی","دانشکده هنر",false, painterResource(id = R.drawable.ic_ghorme)),
        FoodItem("چلوکباب","دانشکده مرکزی",true, painterResource(id = R.drawable.ic_kabab)),
        FoodItem("چلوکباب","دانشکده هنر",true, painterResource(id = R.drawable.ic_kabab)),
        FoodItem("قرمه سبزی","دانشکده مرکزی",false, painterResource(id = R.drawable.ic_ghorme)),
    )
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
            text = "فروش و رزرو غذا",
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
                Text(text = "تغییر حالت به رزو غذا",
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
                    .pointerInput(Unit){
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
                                    Text(text = "تومان",
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
                                    Text("خرید غذا",
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