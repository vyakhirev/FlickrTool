package ru.vyakhirev.listphoto_module.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.vyakhirev.listphoto_module.viewmodel.ListPhotosViewModel

@Module
abstract class ViewModelModule {

    //    @Provides
//    @Singleton
//    fun viewModelsHolder(): @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel> {
//        return mutableMapOf()
//    }
//
//    @Provides
//    @Singleton
//    fun bindsFactory(map: @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel>): ViewModelProvider.Factory {
//        return ru.vyakhirev.listphoto_module.di.viewmodel.ViewModelFactoryProvider(map)
//    }
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactoryProvider): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListPhotosViewModel::class)
    abstract fun bindsListPhotosViewModel(listPhotosViewModel: ListPhotosViewModel): ViewModel

}
