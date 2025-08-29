package com.enet.sinar.ui.view.custom_view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.ui.theme.NationsBlue

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

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=412dp,height=917dp,dpi=480"
)
@Composable
fun DashedContainerPreview() {
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        DashedContainer(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(100.dp)
                .background(Color(0xFFD2EEFF), RoundedCornerShape(24.dp)),
            cornerRadius = 24.dp,
            borderColor = Color.Blue,
            gapLength = 8.dp,
            dashLength = 5.dp,
            strokeWidth = 1.dp
        ){}

        DashedContainer(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(100.dp),
            cornerRadius = 24.dp,
            borderColor = Color.Blue,
            gapLength = 16.dp,
            dashLength = 5.dp,
            strokeWidth = 1.dp
        ){}
        DashedContainer(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(100.dp),
            cornerRadius = 24.dp,
            borderColor = Color.Blue,
            gapLength = 8.dp,
            dashLength = 10.dp,
            strokeWidth = 1.dp
        ){}
    }
}