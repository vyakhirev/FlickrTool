package ru.vyakhirev.core_api.dto

import ru.vyakhirev.core_api.dto.PhotoItem

data class PhotoResult(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    val photo: MutableList<PhotoItem>
)