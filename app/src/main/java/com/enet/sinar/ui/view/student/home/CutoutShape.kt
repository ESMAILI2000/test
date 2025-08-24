package com.sinar.sinar.ui.view.student.home

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class CutoutShape(private val cutoutSize: Float) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                val cornerRadius = 24.dp.toPx(density)

                // شروع رسم از گوشه بالا سمت چپ
                moveTo(x = cornerRadius, y = 0f)

                // خط بالا
                lineTo(x = size.width - cornerRadius, y = 0f)

                // قوس بالا سمت راست
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        left = size.width - 2 * cornerRadius,
                        top = 0f,
                        right = size.width,
                        bottom = 2 * cornerRadius
                    ),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                // خط سمت راست
                lineTo(x = size.width, y = size.height - cutoutSize)

                // رسم بریدگی پایین به صورت مثلثی
                lineTo(x = size.width / 2 + cutoutSize, y = size.height - cutoutSize)
                lineTo(x = size.width / 2, y = size.height)
                lineTo(x = size.width / 2 - cutoutSize, y = size.height - cutoutSize)

                // خط سمت چپ
                lineTo(x = 0f, y = size.height - cutoutSize)

                // قوس پایین سمت چپ (اینجا لازم نیست چون بریدگی را خودمان رسم کردیم)
                // خط سمت چپ تا بالا
                lineTo(x = 0f, y = cornerRadius)

                // قوس بالا سمت چپ
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        left = 0f,
                        top = 0f,
                        right = 2 * cornerRadius,
                        bottom = 2 * cornerRadius
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                close()
            }
        )
    }

    private fun Dp.toPx(density: Density): Float {
        return this.value * density.density
    }
}

class TripleCutoutShape(private val cutoutHeight: Float, private val cutoutWidth: Float) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                val cornerRadius = 24.dp.toPx(density)

                // شروع رسم Path از گوشه بالا سمت چپ
                moveTo(x = cornerRadius, y = 0f)

                // رسم خط بالا
                lineTo(x = size.width - cornerRadius, y = 0f)

                // رسم قوس بالا سمت راست
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        left = size.width - 2 * cornerRadius,
                        top = 0f,
                        right = size.width,
                        bottom = 2 * cornerRadius
                    ),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                // رسم خط سمت راست تا شروع بریدگی‌ها
                lineTo(x = size.width, y = size.height - cutoutHeight)

                // رسم اولین بریدگی (سمت راست)
                lineTo(x = size.width / 2 + cutoutWidth * 1.5f, y = size.height - cutoutHeight)
                lineTo(x = size.width / 2 + cutoutWidth, y = size.height)

                // رسم بریدگی وسط
                lineTo(x = size.width / 2 - cutoutWidth, y = size.height)
                lineTo(x = size.width / 2 - cutoutWidth * 1.5f, y = size.height - cutoutHeight)

                // رسم بریدگی سمت چپ
                lineTo(x = cutoutWidth, y = size.height - cutoutHeight)
                lineTo(x = 0f, y = size.height)

                // خط سمت چپ تا بالا
                lineTo(x = 0f, y = cornerRadius)

                // رسم قوس بالا سمت چپ
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        left = 0f,
                        top = 0f,
                        right = 2 * cornerRadius,
                        bottom = 2 * cornerRadius
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                close()
            }
        )
    }

    private fun Dp.toPx(density: Density): Float {
        return this.value * density.density
    }
}


class CustomCurvedShape(private val cornerRadius: Float) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                // شروع Path از گوشه بالا سمت چپ
                moveTo(x = cornerRadius, y = 0f)

                // رسم خط بالا
                lineTo(x = size.width - cornerRadius, y = 0f)

                // رسم قوس بالا سمت راست (Outward)
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        left = size.width - 2 * cornerRadius,
                        top = 0f,
                        right = size.width,
                        bottom = 2 * cornerRadius
                    ),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                // رسم خط سمت راست
                lineTo(x = size.width, y = size.height - cornerRadius)

                // رسم قوس پایین سمت راست (Inward)
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        left = size.width - 2 * cornerRadius,
                        top = size.height - 2 * cornerRadius,
                        right = size.width,
                        bottom = size.height
                    ),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                // رسم خط پایین
                lineTo(x = cornerRadius, y = size.height)

                // رسم قوس پایین سمت چپ (Inward)
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        left = 0f,
                        top = size.height - 2 * cornerRadius,
                        right = 2 * cornerRadius,
                        bottom = size.height
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                // رسم خط سمت چپ
                lineTo(x = 0f, y = cornerRadius)

                // رسم قوس بالا سمت چپ (Outward)
                arcTo(
                    rect = androidx.compose.ui.geometry.Rect(
                        left = 0f,
                        top = 0f,
                        right = 2 * cornerRadius,
                        bottom = 2 * cornerRadius
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                close()
            }
        )
    }
}

// برای تبدیل Dp به Pixel
private fun Dp.toPx(density: Density): Float {
    return this.value * density.density
}