package ru.vyakhirev.core_impl.datasource

import io.reactivex.Completable
import io.reactivex.Flowable
import ru.vyakhirev.core_api.datasource.Repository
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.dto.PhotoResult
import javax.inject.Inject

class RepositoryImpl @Inject
constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {

//    @VisibleForTesting
    internal var cachedPhotoItemList: MutableList<PhotoItem> = mutableListOf()

    internal var currentPageNumber: Int = 0

    internal var maxPageNumber: Int = 0

    var paginationEndPoint = true

    internal var cacheIsDirty = true

    override fun getPhotoSearchResult(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
        return if (cacheIsDirty)
            getItemFromServerDB(query, page, perPage)
        else
            getItemFromLocalDB(query, page, perPage)
    }

    private fun getItemFromServerDB(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
        return remoteDataSource
            .getPhotoSearchResult(query, page, perPage)
            .doOnNext {
//                localDataSource.updatePhotoItemList(it.photo)
                if (page <= 1)
                    cachedPhotoItemList.clear()
                if (it.page >= it.pages)
                    paginationEndPoint = true
                currentPageNumber = it.page
                maxPageNumber = it.pages
                cachedPhotoItemList.addAll(it.photo)
                cacheIsDirty = false
            }
    }

    private fun getItemFromLocalDB(
        query: String,
        page: Int,
        perPage: Int
    ): Flowable<PhotoResult> {
        return localDataSource
            .getPhotoSearchResult(query, page, perPage)
            .doOnNext {
                if (page <= 1)
                    cachedPhotoItemList.clear()
                if (it.page >= it.pages)
                    paginationEndPoint = true
                currentPageNumber = it.page
                maxPageNumber = it.pages
                cachedPhotoItemList.addAll(it.photo)
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

//    override fun getRecentPhotos(
//        page: Int,
//        per_Page: Int
//    ): Flowable<Response<ResponsePhotoItemHolder>> {
//        return getSearchResults("fs",page,per_Page)
//        return FlickrApiClient.getRecent(
//            page,
//            per_Page
//        )
//    }

    override fun updatePhotoItemList(photoItems: List<PhotoItem>) {
    }

    override fun getRecentPhoto(): Flowable<PhotoResult> {
        TODO("Not yet implemented")
    }

    override fun getCachedPhotoItems(): Flowable<List<PhotoItem>> {
        return Flowable.just(cachedPhotoItemList)
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

    override fun switchFavorite(photoItem: PhotoItem): Completable {
        return localDataSource.switchFavorite(photoItem)
    }

    override fun getFavorites(): Flowable<List<PhotoItem>> {
        return localDataSource.getFavorites()
    }


//    override fun getPhotoSearchResult(
//        query: String,
//        page: Int,
//        perPage: Int
//    ): Flowable<PhotoResult> {
//        return getItemFromLocalDB(query,page,perPage)
//    }
//    override fun getPhotoSearchResult(
//        query: String,
//        page: Int,
//        perPage: Int
//    ): Flowable<PhotoResult> {
//        return getItemFromServerDB(query,page,perPage)
//    }
}


