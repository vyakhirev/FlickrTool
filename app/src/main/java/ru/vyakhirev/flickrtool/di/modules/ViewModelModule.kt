package ru.vyakhirev.flickrtool.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.vyakhirev.flickrtool.di.ViewModelKey
import ru.vyakhirev.flickrtool.di.scopes.PerActivity
import ru.vyakhirev.flickrtool.presentation.viewmodel.ListPhotosViewModel
import ru.vyakhirev.flickrtool.presentation.viewmodel.factory.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    @PerActivity
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListPhotosViewModel::class)
    @PerActivity
    abstract fun bindsListPhotosViewModel(listPhotosViewModel: ListPhotosViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(FavoritesPhotosViewModel::class)
//    @PerActivity
//    abstract fun bindsFavoritesPhotosViewModel(favoritesPhotosViewModel: FavoritesPhotosViewModel): ViewModel
}
