package com.enet.sinar.ui.view.general.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import com.enet.sinar.ui.theme.NationsBlue

@Composable
fun CustomLoadingIndicator(
    modifier: Modifier = Modifier,
    color: Color = NationsBlue, // رنگ آبی
    numSegments: Int = 8, // تعداد "تکه‌های نور"
    segmentWidth: Float = 10f, // عرض هر تکه
    segmentLength: Float = 20f, // طول هر تکه
    innerRadiusFraction: Float = 0.3f // نسبت شعاع دایره مرکزی به کل اندازه
) {

    val infiniteTransition = rememberInfiniteTransition(label = "rotation_transition")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing), // 1 ثانیه برای یک چرخش کامل
            repeatMode = RepeatMode.Restart
        ), label = "rotation"
    )

    Canvas(modifier = modifier) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val actualSize = minOf(size.width, size.height) // اندازه واقعی برای رسم
        val currentRadius = actualSize / 2 // شعاع کلی برای رسم
        val segmentGap = 360f / numSegments // زاویه بین هر تکه

        for (i in 0 until numSegments) {
            rotate(rotation + i * segmentGap) { // چرخش هر تکه به صورت انیمیشن
                // محاسبه نقطه شروع تکه از مرکز دایره
                val startX = centerX + currentRadius * innerRadiusFraction
                val startY = centerY

                // رسم مستطیل برای هر تکه
                drawRect(
                    color = color,
                    topLeft = Offset(startX, startY - segmentWidth / 2),
                    size = androidx.compose.ui.geometry.Size(segmentLength, segmentWidth)
                )
            }
        }
    }
}