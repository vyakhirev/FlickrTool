package ru.vyakhirev.flickrtool.data.model.remote

import ru.vyakhirev.flickrtool.data.model.local.PhotoItem

data class PhotoResult(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    val photo: MutableList<PhotoItem>
)
