package com.kivous.composeone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kivous.composeone.ui.theme.ComposeOneTheme

class TwoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val count = rememberSaveable {
                        mutableStateOf(0)
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Counter(count = count.value, increment = { count.value++ })
                        CounterValue(count = count.value)
                    }

                }
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun PreviewFun() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Counter(count.value)
//            CounterValue(count = 0)
        }
    }

    @SuppressLint("AutoboxingStateCreation")
    @Composable
    fun Counter(count: Int, increment: () -> Unit) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$count", fontSize = 18.sp)
            Button(onClick = {
                increment()
            }) {
                Text(text = "Click")
            }
        }
    }

    @Composable
    fun CounterValue(count: Int) {
        Text(text = "$count", fontWeight = FontWeight.Bold)
    }

    @Composable
    fun CircularImage() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.kit),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.DarkGray, CircleShape)
            )
        }

    }


    @Composable
    fun ModifierFun() {
        Text(
            text = "Souvik Mondal",
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .padding(16.dp)
                .border(8.dp, Color.Black)
                .clip(CircleShape)
                .background(Color.Cyan)
        )
    }

    @Composable
    fun ListView(img: Int, name: String, occupation: String) {
        Row {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
            Column {
                Text(text = name, fontWeight = FontWeight.Bold)
                Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 12.sp)
            }
        }
    }

    @Composable
    fun BoxFun() {
        Box(contentAlignment = Alignment.TopEnd) {
            Image(
                painter = painterResource(id = R.drawable.doraemon), contentDescription = ""
            )

            Text(text = "Doreamon")
        }
    }

    @Composable
    fun ColumnFun() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Souvik", fontSize = 24.sp)
            Text(text = "Mondal", fontSize = 24.sp)
        }

    }

    @Composable
    fun RowFun() {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Souvik", fontSize = 24.sp)
            Text(text = "Mondal", fontSize = 24.sp)
        }
    }


    @Composable
    fun TextFieldFun() {
        val state = remember {
            mutableStateOf("")
        }
        TextField(value = state.value, onValueChange = {
            state.value = it
        }, label = {
            Text(text = "Enter message")
        })
    }


    @Composable
    fun Greeting(name: String) {
        Text(
            text = "Hello $name",
            color = Color.Red,
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Serif,
            letterSpacing = 1.sp,
            textDecoration = TextDecoration.LineThrough,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            softWrap = true,
            minLines = 1,
            style = TextStyle.Default
        )
    }


    @Composable
    fun ImageFun() {
        Image(
            painter = painterResource(id = R.drawable.kit),
            contentDescription = "Image",
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Inside,
            alpha = DefaultAlpha,
            colorFilter = ColorFilter.tint(Color.Red, BlendMode.Lighten),
//            colorFilter = ColorFilter.lighting(Color.Red, Color.Cyan),
        )
    }

    @Composable
    fun ButtonFun() {
        Button(
            onClick = {}, colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black, containerColor = Color.Cyan
            )
        ) {
            Text(text = "Btn")
            Image(
                painter = painterResource(id = R.drawable.doraemon),
                contentDescription = "Doreamon img"
            )
        }
    }

//    @Preview(showSystemUi = true, showBackground = true, name = "greeting Preview")
//    @Composable
//    fun PreviewFun() {
//
//    }

}

