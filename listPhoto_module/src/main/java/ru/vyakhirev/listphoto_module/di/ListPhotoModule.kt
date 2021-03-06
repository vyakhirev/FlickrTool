package ru.vyakhirev.listphoto_module.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import ru.vyakhirev.core_api.usecases.getphotosearch.GetPhotoSearchUseCase
import ru.vyakhirev.core_api.usecases.switchFavoriteUseCase.SwitchFavoritesUseCase
import ru.vyakhirev.listphoto_module.viewmodel.ListPhotosViewModel
import javax.inject.Singleton


@Module
abstract class ListPhotoModule {

    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideListPhotoViewModel(
            map: @JvmSuppressWildcards HashMap<Class<out ViewModel>, ViewModel>,
            getPhotoSearchUseCase: GetPhotoSearchUseCase,
            switchFavoritesUseCase: SwitchFavoritesUseCase
        ): ViewModel = ListPhotosViewModel(getPhotoSearchUseCase,switchFavoritesUseCase).also {
            map[ListPhotosViewModel::class.java] = it
        }
    }
}

