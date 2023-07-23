package com.kivous.composeone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kivous.composeone.ui.theme.ComposeOneTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOneTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    LoginScreen()
                }

            }
        }
    }

    private fun logged(username: String, password: String) {
        if (username == "souvik" && password == "12345") {
            Toast.makeText(this, "logged", Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this, "wrong credentials", Toast.LENGTH_SHORT).show()

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen() {
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            Column(modifier = Modifier.padding(top = 40.dp)) {
                TextHeading(string = "Hello Again!")
                TextHeading(string = "Welcome")
                TextHeading(string = "Back")
            }

            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "person") },
                label = {
                    Text(text = "Username")
                },
                placeholder = {
                    Text(text = "enter username")
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 88.dp)
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                leadingIcon = { Icon(Icons.Default.Info, contentDescription = "password") },
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "enter password")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedButton(
                onClick = { logged(username.value, password.value) }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .heightIn(50.dp)
            ) {
                Text(text = "Login")
            }

        }
    }

    @Composable
    fun TextHeading(string: String) {
        Text(
            text = string,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = Color.Blue
        )
    }
}


