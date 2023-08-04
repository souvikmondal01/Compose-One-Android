package com.kivous.composeone

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kivous.composeone.ui.theme.ComposeOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            ComposeOneTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(vertical = 8.dp)) {
                        AddButton(text = "One", OneActivity())
                        AddButton(text = "Login", LoginActivity())
                        AddButton(text = "RecyclerView", RecyclerViewActivity())
                        AddButton(text = "Animation", AnimationActivity())
                    }
                }
            }

        }
    }
}

@Composable
fun AddButton(text: String, activity: Activity) {
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(
                Intent(
                    context, activity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )
        },

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
    ) {
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!", modifier = Modifier.size(18.dp)
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    ComposeOneTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Greeting("Souvik")
        }
    }

}