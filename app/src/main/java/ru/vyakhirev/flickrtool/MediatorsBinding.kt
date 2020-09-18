package ru.vyakhirev.flickrtool

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.vyakhirev.core_api.mediator.FavoritesPhotoMediator
import ru.vyakhirev.core_api.mediator.ListPhotoMediator
import ru.vyakhirev.favorphoto_module.FavoritesPhotoMediatorImpl
import ru.vyakhirev.listphoto_module.ListPhotoMediatorImpl

@Module
interface MediatorsBindings {
    @Binds
    @Reusable
    fun bindsFavoritesPhotoMediator(favoritesPhotoMediator: FavoritesPhotoMediatorImpl): FavoritesPhotoMediator

    @Binds
    @Reusable
    fun bindsListPhotosMediator(listPhotoMediator: ListPhotoMediatorImpl): ListPhotoMediator
}