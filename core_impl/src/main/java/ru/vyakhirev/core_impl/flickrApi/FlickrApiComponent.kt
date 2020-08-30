package ru.vyakhirev.core_impl.flickrApi

import dagger.Component
import ru.vyakhirev.core_api.flickrApi.FlickrApiProvider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [FlickrApiModule::class]
)
interface FlickrApiComponent:FlickrApiProvider {
}