package com.kivous.composeone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kivous.composeone.screens.LoginScreen
import com.kivous.composeone.screens.MainScreen
import com.kivous.composeone.screens.RegistrationScreen
import com.kivous.composeone.ui.theme.ComposeOneTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOneTheme {
                AppScreen()
            }
        }
    }

}


@Composable
fun AppScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main/ ") {
        composable("main/{email}", arguments = listOf(navArgument("email") {
            type = NavType.StringType
        })) {
            val email = it.arguments!!.getString("email")
            MainScreen(navController, email)
        }
        composable("registration") {
            RegistrationScreen({ email ->
                navController.navigate("main/${email}")
            }, {
                navController.navigate("login")
            })
        }
        composable("login") {
            LoginScreen()
        }
    }
}