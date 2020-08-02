package ru.vyakhirev.flickrtool.domain

import io.reactivex.Single
import retrofit2.Response
import ru.vyakhirev.flickrtool.data.sources.db.PhotoItem
import ru.vyakhirev.flickrtool.data.sources.remote.FlickrResponse

interface IRepository {

    fun getRecentPhoto(api_key: String, page: Int, per_Page: Int): Single<Response<FlickrResponse>>

    fun updatePhotoItemList(photoItems: List<PhotoItem>)
}
