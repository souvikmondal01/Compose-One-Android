package com.kivous.composeone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kivous.composeone.ui.theme.ComposeOneTheme
import com.kivous.composeone.utils.User
import com.kivous.composeone.utils.userData

class RecyclerViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecyclerView(users = userData())
                }
            }
        }

    }


    @Composable
    fun EachRow(user: User) {
        Card(
            modifier = Modifier.padding(vertical = 8.dp),
            shape = RoundedCornerShape(CornerSize(8.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        ) {
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.doraemon),
                    contentDescription = "image",
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(CornerSize(8.dp))),
                )

                Text(
                    text = user.description.toString(), modifier = Modifier.padding(8.dp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }


    @Composable
    fun RecyclerView(users: List<User>) {
        LazyColumn(modifier = Modifier.padding(8.dp)) {
            items(users) {
                EachRow(user = it)
            }
        }
    }


}

