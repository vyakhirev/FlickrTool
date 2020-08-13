package ru.vyakhirev.flickrtool.data.sources.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlickrApiHelper @Inject
constructor(private val flickrApiService: FlickrApiService) : NetworkApiService {

    override fun getAPIService(): FlickrApiService {
        return flickrApiService
    }
}
