package com.kivous.composeone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Screen(
    screenName: String,
    firstButton: String,
    secondButton: String,
    firstButtonOnClick: () -> Unit,
    secondButtonOnClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = screenName,
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.headlineSmall
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                firstButtonOnClick()
            }) {
                Text(text = firstButton)
            }
            Button(onClick = {
                secondButtonOnClick()
            }) {
                Text(text = secondButton)
            }
            Spacer(modifier = Modifier.padding(bottom = 16.dp))

        }

    }
}