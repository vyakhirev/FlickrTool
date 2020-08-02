package ru.vyakhirev.flickrtool.data.sources.remote

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApiService {

    @GET("/services/rest/?method=flickr.photos.getRecent")
    fun getRecent(
        @Query("api_key") key: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("nojsoncallback") noJsonCallback: String = "nojsoncallback",
        @Query("format") format: String = "json"
    ): Single<Response<FlickrResponse>>
}
