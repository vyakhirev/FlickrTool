package ru.vyakhirev.core_impl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun viewModelsHolder(): @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel> {
        return mutableMapOf()
    }

    @Provides
    @Singleton
    fun bindsFactory(map: @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel>): ViewModelProvider.Factory {
        return ViewModelFactoryProvider(map)
    }
}
//@Module
//abstract class ViewModelModule {
//
//    @Binds
//    @PerActivity
//    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(ListPhotosViewModel::class)
//    @PerActivity
//    abstract fun bindsListPhotosViewModel(listPhotosViewModel: ListPhotosViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(FavoritesPhotosViewModel::class)
//    @PerActivity
//    abstract fun bindsFavoritesPhotosViewModel(favoritesPhotosViewModel: FavoritesPhotosViewModel): ViewModel
//}