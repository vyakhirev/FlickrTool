package ru.vyakhirev.core_api.dto

import ru.vyakhirev.core_api.dto.PhotoResult

data class ResponsePhotoItemHolder(
    val stat: String,
    val photos: PhotoResult
)