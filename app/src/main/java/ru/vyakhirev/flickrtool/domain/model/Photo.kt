package ru.vyakhirev.flickrtool.domain.model

data class Photo(
    val id: String,
    val farm: Int,
    val isFamily: Int,
    val isFriend: Int,
    val isPublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String
)
