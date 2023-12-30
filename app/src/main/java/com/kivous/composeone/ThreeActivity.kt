package com.kivous.composeone

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kivous.composeone.ui.theme.ComposeOneTheme

class ThreeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun Counter() {
    val count = remember { mutableIntStateOf(0) }
    val key = count.value % 3 == 0
    LaunchedEffect(key1 = key) {
        Log.d("SSSS", count.value.toString())
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Text(text = count.value.toString())
        Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = { count.value++ }) {
            Text(text = "Increment")
        }
    }

}

@Composable
fun FruitList() {
    LazyColumn {
        items(fruitList()) { item ->
            Text(text = item)
        }
    }
}

fun fruitList(): List<String> {
    return listOf("Apple", "Banana", "Cherry", "Mango", "Guava", "Litchi")
}


@Composable
fun App() {
    val theme = remember {
        mutableStateOf(false)
    }

    ComposeOneTheme(theme.value) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Column(verticalArrangement = Arrangement.Top) {
                Text(
                    text = "hello Souvik!", style = MaterialTheme.typography.titleLarge
                )
                Button(onClick = {
                    theme.value = !theme.value
                }) {
                    Text(text = "Change theme")
                }
            }
        }
    }


}

@Preview(showSystemUi = true)
@Composable
fun AppPrev() {
    App()
}
