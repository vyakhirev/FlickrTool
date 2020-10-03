package ru.vyakhirev.favorphoto_module.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.vyakhirev.favorphoto_module.viewmodel.FavoritesPhotoViewModel
import javax.inject.Singleton

@Module
interface ViewModelModule {

    companion object {
        @Provides
        @Singleton
        fun viewModelsHolder(): @JvmSuppressWildcards HashMap<Class<out ViewModel>, ViewModel> {
            return HashMap()
        }
    }

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactoryProvider): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesPhotoViewModel::class)
    fun bindsListPhotosViewModel(favoritesPhotosViewModel: FavoritesPhotoViewModel): ViewModel
}