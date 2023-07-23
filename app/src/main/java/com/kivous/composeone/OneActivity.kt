package com.kivous.composeone


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kivous.composeone.ui.theme.ComposeOneTheme

@OptIn(ExperimentalMaterial3Api::class)
class OneActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOneTheme {
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text(text = "App Name")
                    }, navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Menu, contentDescription = "menu")
                        }
                    }, actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.Notifications,
                                contentDescription = "notification"
                            )
                        }
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Search, contentDescription = "search")
                        }
                    }
                    )
                }, floatingActionButton = {
                    FloatingActionButton(onClick = { }) {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Add, contentDescription = "add")
                        }
                    }
                }, floatingActionButtonPosition = FabPosition.End
                ) {
                    ShowSwitch()
                }
            }
        }
    }

    @Composable
    fun Greeting(msg: String) {
        Text(
            text = msg
        )
    }

    @Composable
    fun ShowSwitch() {
        val isChecked = remember {
            mutableStateOf(false)
        }

        Switch(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = it
            },
            modifier = Modifier.run {
                padding(24.dp, 80.dp)
            }
        )

    }

}

