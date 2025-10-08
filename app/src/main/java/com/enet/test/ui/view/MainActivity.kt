package com.enet.test.ui.view


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enet.test.ui.theme.SinarTheme
import com.enet.test.ui.view.contact.AddContactsScreen
import com.enet.test.ui.view.contact.ContactDetailScreen
import com.enet.test.ui.view.contact.ContactsScreen
import com.enet.test.ui.view.crypto.CryptoScreen
import com.enet.test.ui.view.hapoo.HapooScreen
import com.enet.test.ui.view.`object`.ObjectScreen
import com.enet.test.ui.view.post.PostsScreen


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

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "Crypto") {

            // "home" یک مسیر (route) برای صفحه اصلی است
            composable("Contacts") {
                ContactsScreen(
                    onNavigateToAddContact ={
                        navController.navigate("AddContact")
                    },
                    onNavigateToDetails = {
                        navController.navigate("findcont")
                    }
                )
            }
            composable("AddContact") {
                AddContactsScreen()
            }

            composable("findcont"){
                ContactDetailScreen()
            }

            composable("Post") {
                PostsScreen()
            }
            composable("Hapoo") {
                HapooScreen()
            }
            composable("Object") {
                ObjectScreen()
            }
            composable("Crypto") {
                CryptoScreen()
            }
            }
        }
    }



