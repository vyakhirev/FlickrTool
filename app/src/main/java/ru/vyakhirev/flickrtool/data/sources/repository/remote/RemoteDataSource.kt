package ru.vyakhirev.flickrtool.data.sources.repository.remote

import io.reactivex.Flowable
import javax.inject.Inject
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.model.remote.PhotoResult
import ru.vyakhirev.flickrtool.data.sources.remote.FlickrApiService
import ru.vyakhirev.flickrtool.domain.AppDataSource

class RemoteDataSource @Inject
constructor(private val flickrApiClient: FlickrApiService) : AppDataSource {

    override fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
        return flickrApiClient
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
