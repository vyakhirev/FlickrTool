package ru.vyakhirev.core_api.datasource

import io.reactivex.Completable
import io.reactivex.Flowable
import ru.vyakhirev.core_api.dto.PhotoItem

interface Repository : AppDataSource {

    fun getSearchResults(
        query: String,
        page: Int,
        per_Page: Int
    ): Flowable<List<PhotoItem>>

//    fun updatePhotoItemList(photoItems: List<PhotoItem>)

//    fun getRecentPhotos(
//        page: Int,
//        per_Page: Int
//    ): Flowable<Response<ResponsePhotoItemHolder>>

    fun getCachedPhotoItems(): Flowable<List<PhotoItem>>

    fun getPaginationStatus(): Boolean

    fun getPageNumber(): Int

    fun getMaxPageNumber(): Int

    fun switchFavorite(photoItem: PhotoItem): Completable

    fun getFavorites(): Flowable<List<PhotoItem>>
}
