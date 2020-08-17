package ru.vyakhirev.flickrtool.data.sources.repository.db

import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.model.remote.PhotoResult
import ru.vyakhirev.flickrtool.data.sources.db.AppDatabase
import ru.vyakhirev.flickrtool.domain.AppDataSource
import javax.inject.Inject


class LocalDataSource @Inject
constructor(private val flickrDatabase: AppDatabase) : AppDataSource {
    override fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
//        TODO("Not yet implemented")
        return flickrDatabase.imageItemDao().SearchPhotosByTitle()
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
        flickrDatabase.imageItemDao().insertMultipleItem(photoItems)
            .subscribe()
    }

    override fun getRecentPhoto(): Flowable<PhotoResult> {
        TODO("Not yet implemented")
    }

    fun switchFavorite(photoItem: PhotoItem):Completable {
        return flickrDatabase.imageItemDao().updateItem(photoItem)
    }

    fun getFavorites():Flowable<List<PhotoItem>>{
        return flickrDatabase.imageItemDao().getFavorites(true)
    }
}
