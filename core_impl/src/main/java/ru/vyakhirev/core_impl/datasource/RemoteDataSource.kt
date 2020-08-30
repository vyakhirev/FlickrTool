package ru.vyakhirev.core_impl.datasource

import io.reactivex.Flowable
import ru.vyakhirev.core_api.datasource.AppDataSource
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.dto.PhotoResult
import ru.vyakhirev.core_api.flickrApi.FlickrApiService
import javax.inject.Inject

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