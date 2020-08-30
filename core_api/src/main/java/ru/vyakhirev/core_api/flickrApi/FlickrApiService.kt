package ru.vyakhirev.core_api.flickrApi

import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.vyakhirev.core_api.dto.ResponsePhotoItemHolder

interface FlickrApiService {

    @GET("/services/rest/?method=flickr.photos.getRecent")
    fun getRecent(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("nojsoncallback") noJsonCallback: String = "nojsoncallback",
        @Query("format") format: String = "json"
    ): Flowable<Response<ResponsePhotoItemHolder>>

    @GET("/services/rest/?method=flickr.photos.search")
    fun getPhotoSearch(
        @Query("text") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("nojsoncallback") noJsonCallback: String = "nojsoncallback",
        @Query("format") format: String = "json"
    ): Flowable<Response<ResponsePhotoItemHolder>>
}
