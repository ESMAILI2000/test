package com.sinar.sinar.ui.view

import AppSection
import CitizenRoutes
import GeneralRoutes
import StaffRoutes
import StudentRoutes
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
import com.sinar.sinar.ui.theme.SinarTheme
import com.sinar.sinar.ui.view.general.login.LoginScreen
import com.sinar.sinar.ui.view.general.splash.SplashScreen
import com.sinar.sinar.ui.view.staff.StaffHomeScreen
import com.sinar.sinar.ui.view.student.home.StudentHomeScreen


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

        NavHost(navController = navController, startDestination = GeneralRoutes.Splash.name) {

            // "home" یک مسیر (route) برای صفحه اصلی است
            composable(GeneralRoutes.Splash.name) {
                SplashScreen(onNavigateToLogin = {  navController.navigate(GeneralRoutes.Login.name) }, onNavigateToHome = { /* به صفحه هوم */ })
            }
            composable(GeneralRoutes.Login.name) {
                LoginScreen(
                    onLoginSuccess = { userSection ->
                        // تعیین مسیر صفحه اصلی بر اساس نقش کاربر
                        val homeRoute = when (userSection) {
                            AppSection.Student -> StudentRoutes.Home.name
                            AppSection.Staff -> StaffRoutes.Home.name
                            AppSection.Citizen -> CitizenRoutes.Home.name
                            else -> GeneralRoutes.Login.name // در صورت ورود موفقیت‌آمیز نباید اتفاق بیفتد.
                        }
                        // ناوبری به صفحه اصلی مربوطه و پاک کردن پشته ناوبری
                        navController.navigate(homeRoute) {
                            // `popUpTo` باعث می‌شود که تمام Composables تا مسیر مشخص شده از پشته حذف شوند.
                            popUpTo(GeneralRoutes.Splash.name) {
                                // `inclusive = true` به این معنی است که خود مسیر GeneralRoutes.Splash.name نیز حذف شود.
                                inclusive = true
                            }
                        }

                    }
                )
            }
            composable(GeneralRoutes.AboutUs.name) {

            }

            // مسیرهای دانشجو (Student Routes)
            composable(StudentRoutes.Home.name) {
                StudentHomeScreen(
                    onLogout = {
                        // هنگام خروج، به صفحه ورود برگردید و پشته را پاک کنید.
                        navController.navigate(GeneralRoutes.Login.name) {
                            popUpTo(StudentRoutes.Home.name) {
                                inclusive = true
                            }
                        }
                    }, onDarkThemeClicked = onToggleDarkTheme // ارسال تابع تغییر تم
                )
            }

            // مسیرهای کارمند (Staff Routes)
            composable(StaffRoutes.Home.name) {
                StaffHomeScreen(
                    onLogout = {
                        navController.navigate(GeneralRoutes.Login.name) {
                            popUpTo(StaffRoutes.Home.name) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }



        //
//        var appSection by remember { mutableStateOf(AppSection.General) }
//        var screenGeneral by remember { mutableStateOf(GeneralRoutes.Splash) } // صفحه در حال نمایش
//        var screenStudent by remember { mutableStateOf(StudentRoutes.Home) }
//        var screenStaff by remember { mutableStateOf(StaffRoutes.Home) }
//        var screenCitizen by remember { mutableStateOf(CitizenRoutes.Home) }

//        Surface(modifier){
//            when(appSection){
//                AppSection.General -> {
//                    when(screenGeneral){
//                        GeneralRoutes.Splash -> SplashScreen(onNavigateToLogin = {screenGeneral = GeneralRoutes.Login})
//                        GeneralRoutes.Login -> TODO()
//                        GeneralRoutes.AboutUs -> TODO()
//                    }
//                }
//                AppSection.Student -> {
//                    when(screenStudent){
//                        StudentRoutes.Home -> StudentHomeScreen(onDarkThemeClicked = { onToggleDarkTheme() })
//                    }
//                }
//                AppSection.Staff -> {
//                    when(screenStaff){
//                        StaffRoutes.Home -> TODO()
//                    }
//                }
//                AppSection.Citizen -> {
//                    when(screenCitizen){
//                        CitizenRoutes.Home -> TODO()
//                    }
//                }
//            }
//        }
    }

}



