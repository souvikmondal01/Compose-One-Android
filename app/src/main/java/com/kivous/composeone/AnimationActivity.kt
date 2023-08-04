package com.kivous.composeone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kivous.composeone.ui.theme.ComposeOneTheme

class AnimationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOneTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 24.dp)
                ) {
                    var isVisible by remember {
                        mutableStateOf(false)
                    }
                    var isRound by remember {
                        mutableStateOf(false)
                    }

                    Button(onClick = {
                        isVisible = !isVisible
                        isRound = !isRound
                    }) {
                        Text(text = "Toggle")
                    }

                    val transition = rememberInfiniteTransition()
                    val color by transition.animateColor(
                        initialValue = Color.Red,
                        targetValue = Color.Blue,
                        animationSpec = infiniteRepeatable(
                            animation = tween(2000), repeatMode = RepeatMode.Reverse
                        )
                    )

                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(color)
                    )

                    val borderRadius by animateIntAsState(
                        targetValue = if (isRound) 40 else 20, label = "",
//                        animationSpec = tween(durationMillis = 3000),
                        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessLow)
                    )
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(borderRadius))
                            .background(
                                Color.Green
                            )
                    ) {
                    }


//                    AnimatedVisibility(
//                        visible = isVisible,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .weight(1f),
//                        enter = slideInHorizontally()+ fadeIn(),
//                        exit = slideOutHorizontally()+ fadeOut()
//                    ) {
//                        Box(modifier = Modifier.background(Color.Green)) {
//
//                        }
//                    }

                }
            }
        }
    }
}
