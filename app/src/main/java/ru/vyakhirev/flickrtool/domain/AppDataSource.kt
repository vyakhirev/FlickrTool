package ru.vyakhirev.flickrtool.domain

import io.reactivex.Flowable
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.model.remote.PhotoResult

interface AppDataSource {
    fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult>

    fun updatePhotoItemList(photoItems: List<PhotoItem>)

    fun getRecentPhoto(): Flowable<PhotoResult>
}
