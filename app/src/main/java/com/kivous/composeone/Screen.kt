package com.kivous.composeone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFunction() {
    LazyColumn(content = {
        items(getCategoryList()) {
            BlogCategory(img = it.img, title = it.title, subTitle = it.subTitle)
        }
    })
}

@Composable
fun BlogCategory(img: Int, title: String, subTitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier
                    .size(64.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(title, subTitle, Modifier.weight(.8f))
        }
    }
}

@Composable
private fun ItemDescription(title: String, subTitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title, style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = subTitle,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Thin
        )
    }
}


data class Category(val img: Int, val title: String, val subTitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.account_circle, "Programming", "Learn Different Languages"))
    list.add(Category(R.drawable.account_circle, "Technology", "News about new Tech"))
    list.add(
        Category(
            R.drawable.account_circle,
            "Full Stack Development",
            "From Backend to Frontend"
        )
    )
    list.add(Category(R.drawable.account_circle, "DevOps", "Development, CI, CD etc."))
    list.add(Category(R.drawable.account_circle, "AI & ML", "Basic Artificial Intelligence"))
    list.add(Category(R.drawable.account_circle, "Programming", "Learn Different Languages"))
    list.add(Category(R.drawable.account_circle, "Technology", "News about new Tech"))
    list.add(
        Category(
            R.drawable.account_circle,
            "Full Stack Development",
            "From Backend to Frontend"
        )
    )
    list.add(Category(R.drawable.account_circle, "DevOps", "Development, CI, CD etc."))
    list.add(Category(R.drawable.account_circle, "AI & ML", "Basic Artificial Intelligence"))
    list.add(Category(R.drawable.account_circle, "Programming", "Learn Different Languages"))
    list.add(Category(R.drawable.account_circle, "Technology", "News about new Tech"))
    list.add(
        Category(
            R.drawable.account_circle,
            "Full Stack Development",
            "From Backend to Frontend"
        )
    )
    list.add(Category(R.drawable.account_circle, "DevOps", "Development, CI, CD etc."))
    list.add(Category(R.drawable.account_circle, "AI & ML", "Basic Artificial Intelligence"))
    return list
}
