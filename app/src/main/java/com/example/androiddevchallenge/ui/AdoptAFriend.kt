package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainActivity
import com.example.androiddevchallenge.NavigationActions
import com.example.androiddevchallenge.Route
import com.example.androiddevchallenge.data.Friend
import com.example.androiddevchallenge.ui.detail.FriendInfo
import com.example.androiddevchallenge.ui.home.Home
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.*


@Composable
fun AdoptAFriend(darkTheme: Boolean) {
    val navController = rememberNavController()
    val navActions = remember(navController) { NavigationActions(navController) }

    MyTheme(darkTheme = darkTheme) {
        NavHost(navController, startDestination = Route.Home.path) {
            composable(Route.Home.path) {
                Home(
                    darkTheme = darkTheme,
                    openFriendInfo = navActions.openDetail,
                    MainActivity.listOfFriends
                )
            }
            composable(
                Route.FriendInfo.path,
                arguments = listOf(
                    navArgument(Route.FriendInfo.idArgument) { type = NavType.StringType },
                )
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString(Route.FriendInfo.idArgument)
                requireNotNull(id)

                var friend: Friend? = null
                MainActivity.listOfFriends.forEach {
                    if (it.id == UUID.fromString(id)) {
                        friend = it
                    }
                }

                if (friend != null) {
                    FriendInfo(
                        friend = friend!!,
                        navigateUp = navActions.navigateUp
                    )
                }
            }
        }
    }
}
