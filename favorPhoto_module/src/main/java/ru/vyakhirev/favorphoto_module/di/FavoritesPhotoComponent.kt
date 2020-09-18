package ru.vyakhirev.favorphoto_module.di

import dagger.Component
import ru.vyakhirev.core_api.mediator.ProvidersFacade
import ru.vyakhirev.favorphoto_module.FavoritePhotosFragment
import ru.vyakhirev.favorphoto_module.di.viewmodel.DaggerViewModelComponent
import ru.vyakhirev.favorphoto_module.di.viewmodel.ViewModelsProvider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ListPhotoModule::class],
    dependencies = [ProvidersFacade::class, ViewModelsProvider::class]
)
interface FavoritesPhotoComponent : ViewModelsProvider {

    companion object {

        fun create(providersFacade: ProvidersFacade): FavoritesPhotoComponent {
            val vmComponent = DaggerViewModelComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
            return DaggerFavoritesPhotoComponent
                .builder()
                .viewModelsProvider(vmComponent)
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(listPhotosFragment: FavoritePhotosFragment)

}