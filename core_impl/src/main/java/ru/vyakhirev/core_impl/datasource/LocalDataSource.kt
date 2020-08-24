package ru.vyakhirev.core_impl.datasource

import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import ru.vyakhirev.core_api.datasource.AppDataSource
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.dto.PhotoResult
import ru.vyakhirev.core_impl.db.AppDatabase
import javax.inject.Inject

class LocalDataSource @Inject
constructor(private val flickrDatabase: AppDatabase) : AppDataSource {
    override fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
//        TODO("Not yet implemented")
        return flickrDatabase.photosItemDao().SearchPhotosByTitle()
            .flatMap { photos ->
                Observable.just(
                    PhotoResult(
                        page,
                        photos.size / perPage,
                        perPage,
                        photos.size,
                        photos.toMutableList()
                    )
                )
                    .toFlowable(BackpressureStrategy.DROP)
            }
    }

    override fun updatePhotoItemList(photoItems: List<PhotoItem>) {
        flickrDatabase.photosItemDao().insertMultipleItem(photoItems)
            .subscribe()
    }

    override fun getRecentPhoto(): Flowable<PhotoResult> {
        TODO("Not yet implemented")
    }

    fun switchFavorite(photoItem: PhotoItem): Completable {
        return flickrDatabase.photosItemDao().updateItem(photoItem)
    }

    fun getFavorites(): Flowable<List<PhotoItem>> {
        return flickrDatabase.photosItemDao().getFavorites(true)
    }
}
