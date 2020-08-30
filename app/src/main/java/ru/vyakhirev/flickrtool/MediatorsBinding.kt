package ru.vyakhirev.flickrtool

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.vyakhirev.core_api.mediator.FavoritesPhotoMediator
import ru.vyakhirev.core_api.mediator.ListPhotoMediator
import ru.vyakhirev.core_api.mediator.MainMediator

@Module
interface MediatorsBindings {

    @Binds
    @Reusable
    fun bindsListPhotoMediator(listPhotoMediator: ListPhotoMediatorImpl): ListPhotoMediator

    @Binds
    @Reusable
    fun bindsFavoritesPhotoMediator(favoritesPhotoMediator: FavoritesPhotoMediatorImpl): FavoritesPhotoMediator

//    @Binds
//    @Reusable
//    fun bindsHomeMediator(homeMediatorImpl: HomeMediatorImpl): HomeMediator
}