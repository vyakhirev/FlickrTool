package ru.vyakhirev.flickrtool.data.sources.remote

import com.google.gson.annotations.SerializedName

data class FlickrResponse(
    @SerializedName("photos") val photos: ListPhotos?,
    @SerializedName("stat") val stat: String
)
