package com.kivous.composeone.screens

import androidx.compose.runtime.Composable

@Composable
fun RegistrationScreen(
    firstButtonOnClick: (email: String) -> Unit, secondButtonOnClick: () -> Unit
) {
    Screen(
        screenName = "Registration Screen",
        firstButton = "Main",
        secondButton = "Login",
        {
            firstButtonOnClick("souvik@gmail.com")
        }, {
            secondButtonOnClick()
        })
}