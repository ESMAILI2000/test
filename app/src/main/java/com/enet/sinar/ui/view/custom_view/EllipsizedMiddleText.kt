package com.enet.sinar.ui.view.custom_view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enet.sinar.ui.theme.PoliceBlue

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

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=412dp,height=917dp,dpi=480"
)

@Composable
fun EllipsizedMiddleTextPreview() {
    Column {
        EllipsizedMiddleText(
            text = "0x5A141B7eba38A151EDfcd816D912E6ae5C0307b1",
            startLength = 10,
            endLength = 5,
            maxLines = 1,
            color = PoliceBlue,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}