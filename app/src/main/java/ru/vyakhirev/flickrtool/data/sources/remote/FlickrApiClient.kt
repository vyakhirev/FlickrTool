package ru.vyakhirev.flickrtool.data.sources.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object FlickrApiClient {

    const val BASE_URL = "https://www.flickr.com"

    val FLICKR_API_CLIENT: FlickrApiService by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return@lazy retrofit.create(FlickrApiService::class.java)
    }
}
