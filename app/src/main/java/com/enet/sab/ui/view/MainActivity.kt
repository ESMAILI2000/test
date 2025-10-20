package com.enet.sab.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enet.sab.ui.theme.AtiselTheme
import com.enet.sab.ui.utility.MySharedPreferences
import com.enet.sab.ui.view.activat.ActivatScreen
import com.enet.sab.ui.view.home.HomeScreen
import com.enet.sab.ui.view.password.ChengPasswordScreen
import com.enet.sab.ui.view.password.EnterPasswordScreen
import com.enet.sab.ui.view.report.ReportsListScreen


@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          setContent{
            AtiselTheme(darkTheme = false, dynamicColor = false) {
                    MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }




@SuppressLint("UnrememberedMutableState")
@Composable
fun MyApp(modifier: Modifier = Modifier) {


    val isActive = MySharedPreferences.isActive(this)

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = if (isActive) "Login" else "Activate" ){

        composable("Login"){
            EnterPasswordScreen(onChengPasswordClicked = {
                navController.navigate("ChengPassword")
            }, onHomeClicked = {
                navController.navigate("Home")
            })
        }
        composable("Activate"){
            ActivatScreen(onLoginClicked = {
                navController.navigate("Login")
            }
            )
        }
        composable("ChengPassword"){
            ChengPasswordScreen(onHomeClicked = {
                navController.navigate("Home")
            })
        }
        composable("Home"){
            HomeScreen(onReportsClicked = {
                navController.navigate("Reports")
            }, onContactsClicked = {
                navController.navigate("Contacts")
            }, onUnitsClicked = {
                navController.navigate("Units")
            }, onUsersClicked = {
                navController.navigate("Users")
            }, onImportClicked = {
                navController.navigate("Import")
            }, onCoastsClicked = {
                navController.navigate("Coasts")
            }, onViewReportClicked = {
                navController.navigate("Report")
            }, onAddContactClicked = {
                navController.navigate("AddContact")
            }, onAddUserClicked = {
                navController.navigate("AddUser")
            }, onAddReportClicked = {
                navController.navigate("AddReport")
            }, onAddCoastClicked = {
                navController.navigate("AddCoast")
            })
        }
        composable("Import"){

        }
        composable("Reports"){
            ReportsListScreen()
        }
    }
  }
}



