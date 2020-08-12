package ru.vyakhirev.flickrtool.domain

import io.reactivex.Flowable
import retrofit2.Response
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.model.remote.ResponsePhotoItemHolder

interface IRepository : AppDataSource {

    fun getSearchResults(
        query: String,
        page: Int,
        per_Page: Int
    ): Flowable<List<PhotoItem>>

//    fun updatePhotoItemList(photoItems: List<PhotoItem>)

    fun getRecentPhotos(
        page: Int,
        per_Page: Int
    ): Flowable<Response<ResponsePhotoItemHolder>>

    fun getCachedPhotoItems(): Flowable<List<PhotoItem>>

    fun getPaginationStatus(): Boolean

    fun getPageNumber(): Int

    fun getMaxPageNumber(): Int
}
