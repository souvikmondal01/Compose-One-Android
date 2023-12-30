package com.kivous.composeone.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController, email: String?) {
    val screenName = remember {
        mutableStateOf("Main Screen")
    }
    email?.let {
        screenName.value = email
    }
    Screen(screenName = screenName.value,
        firstButton = "Registration",
        secondButton = "Login",
        {
            navController.navigate("registration")
        },
        {
            navController.navigate("login")
        })

}

