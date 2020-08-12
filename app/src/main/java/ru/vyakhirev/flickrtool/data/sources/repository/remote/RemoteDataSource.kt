package ru.vyakhirev.flickrtool.data.sources.repository.remote

import io.reactivex.Flowable
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.model.remote.PhotoResult
import ru.vyakhirev.flickrtool.data.sources.remote.FlickrApiClient
import ru.vyakhirev.flickrtool.domain.AppDataSource

class RemoteDataSource : AppDataSource {
    override fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
        return FlickrApiClient.FLICKR_API_CLIENT
            .getPhotoSearch(query, page, perPage)
            .map { it.body()?.photos }
    }

    override fun updatePhotoItemList(photoItems: List<PhotoItem>) {
        TODO("Not yet implemented")
    }

    override fun getRecentPhoto(): Flowable<PhotoResult> {
        TODO("Not yet implemented")
    }
}
