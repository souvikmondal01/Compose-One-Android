package com.kivous.composeone

import android.os.Bundle
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kivous.composeone.ui.theme.ComposeOneTheme
import com.kivous.composeone.utils.Utils.logD
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FourActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterCoroutine()
                    KeyboardVisibilityCheck()
                }
            }
        }
    }
}

@Composable
fun KeyboardVisibilityCheck() {
    val isVisible = remember {
        mutableStateOf(false)
    }
    val view = LocalView.current
    DisposableEffect(Unit) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())
            logD(isKeyboardVisible.toString())
            isKeyboardVisible?.let {
                isVisible.value = isKeyboardVisible
            }
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }

    Text(text = isVisible.value.toString())
}


@Composable
fun CounterCoroutine() {
    val scope = rememberCoroutineScope()
    val count = remember {
        mutableIntStateOf(0)
    }
    var text = "Counter is running: ${count.value}"
    if (count.value == 10) {
        text = "Counter stopped"
    }
    var color = Color.Cyan
    if (count.value == 1) {
        color = Color.Cyan
    } else if (count.value == 2) {
        color = Color.Blue
    } else if (count.value == 3) {
        color = Color.Black
    } else if (count.value == 4) {
        color = Color.DarkGray
    } else if (count.value == 5) {
        color = Color.Green
    } else if (count.value == 5) {
        color = Color.Magenta
    } else if (count.value == 6) {
        color = Color.Red
    } else if (count.value == 7) {
        color = Color.Yellow
    } else if (count.value == 8) {
        color = Color.Gray
    } else if (count.value == 9) {
        color = Color.LightGray
    } else if (count.value == 10) {
        color = Color.Cyan
    }

    Column(
        modifier = Modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.padding(8.dp))
        Button(colors = ButtonDefaults.buttonColors(color), onClick = {
            scope.launch {
                logD("Coroutine started")
                try {
                    for (i in 1..10) {
                        count.value++
                        delay(1000)
                    }
                } catch (e: Exception) {
                    logD("Exception: ${e.localizedMessage}")
                }
            }
        }) {
            Text(text = "Start")
        }

        Spacer(modifier = Modifier.padding(16.dp))
        val num = remember {
            mutableIntStateOf(0)
        }

        LaunchedEffect(true) {
            delay(2000)
            num.value = 10
        }
        CC(msg = num.value)


        val state = remember {
            mutableStateOf(false)
        }

        DisposableEffect(key1 = state.value) {
            logD("DisposableEffect stared...")
            onDispose {
                logD("Clean up performed")
            }
        }

        Button(onClick = {
            state.value = !state.value
        }) {
            Text(text = "Disposable Effect")
        }

        TextField(value = "", onValueChange = {}, modifier = Modifier.padding(top = 16.dp))
    }
}

@Composable
fun CC(msg: Int) {
    val value = rememberUpdatedState(newValue = msg)
    LaunchedEffect(msg) {
        delay(3000)
        logD(value.value.toString())
    }
    Text(text = value.value.toString())
}


