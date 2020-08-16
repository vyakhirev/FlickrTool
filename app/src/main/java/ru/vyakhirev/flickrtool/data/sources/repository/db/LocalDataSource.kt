package ru.vyakhirev.flickrtool.data.sources.repository.db

import io.reactivex.Flowable
import javax.inject.Inject
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.model.remote.PhotoResult
import ru.vyakhirev.flickrtool.data.sources.db.AppDatabase
import ru.vyakhirev.flickrtool.domain.AppDataSource

class LocalDataSource @Inject
constructor(private val flickrDatabase: AppDatabase) : AppDataSource {
    override fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
//       return flickrDatabase.imageItemDao().SearchPhotosByTitle("test")
        TODO("Not yet implemented")
    }

    override fun updatePhotoItemList(photoItems: List<PhotoItem>) {
        TODO("Not yet implemented")
    }

    override fun getRecentPhoto(): Flowable<PhotoResult> {
        TODO("Not yet implemented")
    }
}
