package ru.vyakhirev.core_api.datasource

import io.reactivex.Flowable
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.dto.PhotoResult

interface AppDataSource {
    fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult>

    fun updatePhotoItemList(photoItems: List<PhotoItem>)

    fun getRecentPhoto(): Flowable<PhotoResult>

//    fun getFavoritesPhoto(): Flowable<PhotoResult>
}
