package ru.vyakhirev.favorphoto_module.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import ru.vyakhirev.core_api.usecases.getfavoritesphoto.GetFavoritesPhotoUseCase
import ru.vyakhirev.core_api.usecases.getphotosearch.GetPhotoSearchUseCase
import ru.vyakhirev.core_api.usecases.switchFavoriteUseCase.SwitchFavoritesUseCase
import ru.vyakhirev.favorphoto_module.viewmodel.FavoritesPhotoViewModel
import javax.inject.Singleton

@Module
abstract class ListPhotoModule {

    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideListPhotoViewModel(
            map: @JvmSuppressWildcards HashMap<Class<out ViewModel>, ViewModel>,
            getFavoritesPhotoUseCase: GetFavoritesPhotoUseCase,
            switchFavoritesUseCase: SwitchFavoritesUseCase
        ): ViewModel = FavoritesPhotoViewModel(getFavoritesPhotoUseCase,switchFavoritesUseCase).also {
            map[FavoritesPhotoViewModel::class.java] = it
        }
    }
}
