package ru.vyakhirev.flickrtool.data.sources.remote

import com.google.gson.annotations.SerializedName
import ru.vyakhirev.flickrtool.data.model.Photo

data class ListPhotos(
    @SerializedName("page") val page: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("perpage") val perPage: Int,
    @SerializedName("photo") val photo: List<Photo>,
    @SerializedName("total") val total: String
)
