package ru.vyakhirev.flickrtool.data.sources.repository.db

import io.reactivex.Flowable
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.model.remote.PhotoResult
import ru.vyakhirev.flickrtool.domain.AppDataSource

class LocalDataSource : AppDataSource {
    override fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
        TODO("Not yet implemented")
    }

    override fun updatePhotoItemList(photoItems: List<PhotoItem>) {
        TODO("Not yet implemented")
    }

    override fun getRecentPhoto(): Flowable<PhotoResult> {
        TODO("Not yet implemented")
    }
}
