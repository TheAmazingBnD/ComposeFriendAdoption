package com.example.androiddevchallenge.ui.home

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Friend
import com.example.androiddevchallenge.ui.firend.FriendsList
import java.util.*

@Composable
fun Home(
    darkTheme: Boolean,
    openFriendInfo: (UUID) -> Unit,
    friends: List<Friend>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Adapt a Friend") },
                elevation = 4.dp
            )
        },
        content = {
            FriendsList(friends = friends, openFriendInfo = openFriendInfo)
        }
    )
}