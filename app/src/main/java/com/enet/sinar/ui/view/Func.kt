package com.enet.sinar.ui.view

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.ui.theme.NationsBlue
import java.util.Locale


// تابع تغییر زبان
fun Context.setAppLocale(language: String): Context {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config = resources.configuration
    config.setLocale(locale)
    return createConfigurationContext(config)
}

@Composable
fun EllipsizedMiddleText(
    text: String,
    startLength: Int = 10,
    endLength: Int = 4,
    modifier: Modifier = Modifier,
    style: TextStyle,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = Color.Black,
    fontSize: TextUnit = 12.sp,
    maxLines: Int = 1
) {
    val shortenedText = remember(text) {
        if (text.length <= startLength + endLength) {
            text
        } else {
            val start = text.take(startLength)
            val end = text.takeLast(endLength)
            "$start.....$end"
        }
    }

    Text(
        text = shortenedText,
        maxLines = maxLines,
        color = color,
        fontSize = fontSize,
        textAlign = textAlign,
        overflow = TextOverflow.Visible,
        style = style,
        modifier = modifier
    )
}

data class MenuItem(val text:String,val icon:Painter)

data class TextFeildItem(
    val holder:String,
    val icon:Painter,
    var value: MutableState<String>,
    val isNumeric: Boolean = false,
    var isPassword: Boolean = false
)

@Composable
fun DashedContainer(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 32.dp,
    strokeWidth: Dp = 1.5.dp,
    dashLength: Dp = 5.dp,
    gapLength: Dp = 8.dp,
    borderColor: Color = NationsBlue,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .drawBehind {
                val stroke = strokeWidth.toPx()
                val dash = dashLength.toPx()
                val gap = gapLength.toPx()
                val radius = cornerRadius.toPx()

                val pathEffect = PathEffect.dashPathEffect(floatArrayOf(dash, gap), 0f)

                drawRoundRect(
                    color = borderColor,
                    topLeft = androidx.compose.ui.geometry.Offset(0f, 0f),
                    size = size,
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(radius, radius),
                    style = Stroke(width = stroke, pathEffect = pathEffect)
                )
            }
            .clip(RoundedCornerShape(cornerRadius))
//            .background(Color.White)
            .padding(0.dp)
    ) {
        content()
    }
}
