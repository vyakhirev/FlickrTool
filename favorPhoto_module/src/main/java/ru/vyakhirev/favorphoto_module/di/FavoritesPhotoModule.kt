package ru.vyakhirev.favorphoto_module.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import ru.vyakhirev.core_api.usecases.GetPhotoSearchUseCase
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
            getPhotoSearchUseCase: GetPhotoSearchUseCase
        ): ViewModel = FavoritesPhotoViewModel(getPhotoSearchUseCase).also {
            map[FavoritesPhotoViewModel::class.java] = it
        }
    }
}
