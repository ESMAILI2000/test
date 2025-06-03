package com.enet.sinar.ui.view.student.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enet.sinar.ui.theme.SinarTheme
import com.enet.sinar.ui.view.MainActivity


@Composable
fun HomeScreen(
    onDarkThemeClicked: () -> Unit = {},
    modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 100.dp, top = 100.dp)
            .background(color = MaterialTheme.colorScheme.background)

    ){
        Button(onClick = { onDarkThemeClicked() }
        ) {
            Text("دارک مود")
        }
    }
}


@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=309dp,height=688dp,dpi=480"
)
@Composable
fun HomePreview() {
    SinarTheme {
        HomeScreen()
    }
}