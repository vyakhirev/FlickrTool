package ru.vyakhirev.flickrtool.data.sources.repository

import androidx.annotation.VisibleForTesting
import io.reactivex.Flowable
import retrofit2.Response
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.model.remote.PhotoResult
import ru.vyakhirev.flickrtool.data.model.remote.ResponsePhotoItemHolder
import ru.vyakhirev.flickrtool.data.sources.remote.FlickrApiClient
import ru.vyakhirev.flickrtool.data.sources.repository.db.LocalDataSource
import ru.vyakhirev.flickrtool.data.sources.repository.remote.RemoteDataSource
import ru.vyakhirev.flickrtool.domain.IRepository

class RepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : IRepository {

    //    var page=1
//    var per_Page=30
    @VisibleForTesting
    internal var cachedPhotoItemList: MutableList<PhotoItem> = mutableListOf()

    @VisibleForTesting
    internal var currentPageNumber: Int = 0

    @VisibleForTesting
    internal var maxPageNumber: Int = 0

    var paginationEndPoint: Boolean = false

    @VisibleForTesting
    internal var cacheIsDirty = false

    private fun getItemFromServerDB(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
        return remoteDataSource
            .getPhotoSearchResult(query, page, perPage)
            .doOnNext {
                val items = it.photo
                // mLocalAppDataSource.updatePhotoItemList(items)
                if (page <= 1)
                    cachedPhotoItemList.clear()
                if (it.page >= it.pages)
                    paginationEndPoint = true
                currentPageNumber = it.page
                maxPageNumber = it.pages
                cachedPhotoItemList.addAll(items)
                cacheIsDirty = false
            }
    }

    override fun getSearchResults(
        query: String,
        page: Int,
        per_Page: Int
    ): Flowable<List<PhotoItem>> {

        if (paginationEndPoint)
            return Flowable.just(listOf())

        // request page already available
        if (maxPageNumber != 0 && (page !in (currentPageNumber + 1)..(maxPageNumber))) {

            // calculate the offset from the page and perPage
            val offset = (page - 1) * per_Page

            // if items are available in the cache, directly use it, send batch by batch
            if (cachedPhotoItemList.isNotEmpty() &&
                !cacheIsDirty &&
                cachedPhotoItemList.size > offset
            ) {

                // calculate the batch end index
                val endIndex =
                    if ((offset + per_Page) < cachedPhotoItemList.size) {
                        (offset + per_Page)
                    } else {
                        cachedPhotoItemList.size
                    }

                return Flowable.just(cachedPhotoItemList.subList(offset, endIndex))
            }
        }

        return getPhotoSearchResult(query, page, per_Page).map { t: PhotoResult -> t.photo }
    }

    override fun getRecentPhotos(
        page: Int,
        per_Page: Int
    ): Flowable<Response<ResponsePhotoItemHolder>> {
        return FlickrApiClient.FLICKR_API_CLIENT.getRecent(
            page,
            per_Page
        )
    }

    override fun updatePhotoItemList(photoItems: List<PhotoItem>) {
    }

    override fun getRecentPhoto(): Flowable<PhotoResult> {
        TODO("Not yet implemented")
    }

    override fun getCachedPhotoItems(): Flowable<List<PhotoItem>> {
        TODO("Not yet implemented")
    }

    override fun getPaginationStatus(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getPageNumber(): Int {
        TODO("Not yet implemented")
    }

    override fun getMaxPageNumber(): Int {
        TODO("Not yet implemented")
    }

    override fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
        return getItemFromServerDB(query, page, perPage)
    }
}
