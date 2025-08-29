package com.enet.sinar.ui.view.custom_view

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.cos
import kotlin.math.sin

class HexagonShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path()
        val radius = size.width / 2f
        val centerX = size.width / 2f
        val centerY = size.height / 2f

        for (i in 0 until 6) {
            val angle = Math.toRadians((60 * i - 30).toDouble()) // فقط 6 نقطه
            val x = centerX + radius * cos(angle).toFloat()
            val y = centerY + radius * sin(angle).toFloat()
            if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }
        path.close()

        return Outline.Generic(path)
    }
}
