package ru.vyakhirev.core_api.flickrApi

interface FlickrApiProvider {
    fun provideFlickrApi():FlickrApiService
}