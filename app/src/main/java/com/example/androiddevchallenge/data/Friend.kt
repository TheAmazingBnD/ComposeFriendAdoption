package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R
import com.github.javafaker.Faker
import java.util.*

data class Friend(
    val id : UUID,
    @DrawableRes val picture: Int,
    val name: String,
    val location: String,
    val quote: String
)

fun createFriendsList(): List<Friend> {
    var listOfFriends: List<Friend> = mutableListOf()
    repeat(50) {
        listOfFriends = listOfFriends.plus(createFriendData()).distinct()
    }
    return listOfFriends
}

fun createFriendData() = Friend(
    id = UUID.randomUUID(),
    picture = listOfPhoto[(1..7).random()],
    name = Faker.instance().rickAndMorty().character(),
    location = Faker.instance().rickAndMorty().location(),
    quote = Faker.instance().rickAndMorty().quote()
)

val listOfPhoto =
    listOf(
        R.drawable.bnd,
        R.drawable.duffman,
        R.drawable.julia,
        R.drawable.justin,
        R.drawable.michael,
        R.drawable.rafa,
        R.drawable.tobe,
        R.drawable.torres
    )
