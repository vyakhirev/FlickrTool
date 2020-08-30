package ru.vyakhirev.flickrtool.data.sources.remote

import com.google.gson.annotations.SerializedName
import ru.vyakhirev.flickrtool.data.model.PhotoData

data class ListPhotos(
    @SerializedName("page") val page: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("perpage") val perPage: Int,
    @SerializedName("photo") val photo: List<PhotoData>,
    @SerializedName("total") val total: String
)
