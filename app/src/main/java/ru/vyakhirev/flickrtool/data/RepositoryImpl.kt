package ru.vyakhirev.flickrtool.data

import io.reactivex.Single
import retrofit2.Response
import ru.vyakhirev.flickrtool.BuildConfig
import ru.vyakhirev.flickrtool.data.sources.db.PhotoItem
import ru.vyakhirev.flickrtool.data.sources.remote.FlickrApiClient
import ru.vyakhirev.flickrtool.data.sources.remote.FlickrResponse
import ru.vyakhirev.flickrtool.domain.IRepository

class RepositoryImpl : IRepository {

//    var page=1
//    var per_Page=30

    override fun getRecentPhoto(
        api_key: String,
        page: Int,
        per_Page: Int
    ): Single<Response<FlickrResponse>> {
        return FlickrApiClient.FLICKR_API_CLIENT.getRecent(BuildConfig.FLICKR_API_KEY,page,per_Page)
    }

    override fun updatePhotoItemList(photoItems: List<PhotoItem>) {
    }

}