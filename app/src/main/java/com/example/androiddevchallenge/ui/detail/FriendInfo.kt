package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Friend
import com.example.androiddevchallenge.ui.firend.FriendDescription
import com.example.androiddevchallenge.ui.firend.FriendImage

@Composable
fun FriendInfo(friend: Friend, navigateUp: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(friend.name) },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.primary,
            )
        },
        content = {
            Column {
                FriendImage(imageUrl = friend.picture)
                FriendDescription(
                    name = friend.name,
                    location = friend.location,
                    quote = friend.quote
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Favorite, contentDescription = null, tint = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
}



