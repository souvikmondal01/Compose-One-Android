package com.kivous.composeone.screens

import androidx.compose.runtime.Composable
import com.kivous.composeone.utils.Utils

@Composable
fun LoginScreen() {
    Screen(screenName = "Login Screen",
        firstButton = "Registration",
        secondButton = "Main",
        {
            Utils.logD("One")
        },
        {
            Utils.logD("Two")
        })
}