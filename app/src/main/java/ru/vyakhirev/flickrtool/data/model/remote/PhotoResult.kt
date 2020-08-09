package ru.vyakhirev.flickrtool.data.model.remote

import java.util.*
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem

data class PhotoResult(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: String,
    val photo: ArrayList<PhotoItem>
)
