package com.example.androiddevchallenge.ui.firend

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Friend
import com.example.androiddevchallenge.ui.theme.Divider
import java.util.*

@Composable
fun FriendsList(
    friends: List<Friend>,
    modifier: Modifier = Modifier,
    openFriendInfo: (UUID) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier,
    ) {
        LazyColumn(modifier.fillMaxWidth()) {
            items(friends) { friend ->
                FriendListItem(friend = friend, modifier, openFriendInfo)
            }
        }
    }
}

@Composable
fun FriendListItem(friend: Friend, modifier: Modifier = Modifier, openFriendInfo: (UUID) -> Unit
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { openFriendInfo(friend.id) },
        elevation = 2.dp
    ) {
        Column {
            FriendImage(imageUrl = friend.picture)
            Divider()
            FriendDescription(
                name = friend.name,
                location = friend.location,
                quote = friend.quote
            )
        }
    }
}

@Composable
fun FriendImage(@DrawableRes imageUrl: Int, modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = imageUrl),
            contentDescription = "Friend Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(24.dp)
                .height(300.dp)
                .fillMaxWidth(),
        )
    }
}

@Composable
fun FriendDescription(
    name: String,
    location: String,
    quote: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Name: ",
        modifier = modifier.padding(bottom = 4.dp, top = 4.dp, end = 4.dp, start = 4.dp),
        style = TextStyle(fontWeight = FontWeight.Bold)
    )
    Text(
        text = name,
        modifier = Modifier.padding(bottom = 4.dp, top = 4.dp, end = 4.dp, start = 4.dp)
    )
    Divider()
    Text(
        text = "Quote: ",
        modifier = modifier.padding(bottom = 4.dp, top = 4.dp, end = 4.dp, start = 4.dp),
        style = TextStyle(fontWeight = FontWeight.Bold)
    )
    Text(quote, modifier.padding(bottom = 4.dp, top = 4.dp, end = 4.dp, start = 4.dp))
    Divider()
    Text(
        text = "Location: ",
        modifier = modifier.padding(bottom = 4.dp, top = 4.dp, end = 4.dp, start = 4.dp),
        style = TextStyle(fontWeight = FontWeight.Bold)
    )
    Text(
        text = location,
        modifier = modifier.padding(bottom = 4.dp, top = 4.dp, end = 4.dp, start = 4.dp)
    )
    Divider()
}