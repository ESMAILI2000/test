package com.enet.sinar.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.enet.sinar.ui.theme.SinarTheme
import com.enet.sinar.ui.view.student.home.HomeScreen


@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          setContent{
              var isDarkThemeEnabled by remember { mutableStateOf(true) }
              SinarTheme(darkTheme = isDarkThemeEnabled, dynamicColor = true) {
                    MyApp(modifier = Modifier.fillMaxSize(),
                        onToggleDarkTheme = {
                            isDarkThemeEnabled = !isDarkThemeEnabled
                        })
            }
        }
    }

    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun MyApp(modifier: Modifier = Modifier,onToggleDarkTheme: () -> Unit) {

        //نسخه کاربران دانشجو
        var screenStudent by remember { mutableStateOf(StudentLunchActivity.home) } // صفحه در حال نمایش

        Surface(modifier){
            when(screenStudent){
                StudentLunchActivity.login -> TODO()
                StudentLunchActivity.home -> HomeScreen(onDarkThemeClicked = { onToggleDarkTheme() })
                StudentLunchActivity.register -> TODO()
            }
        }
    }

}



