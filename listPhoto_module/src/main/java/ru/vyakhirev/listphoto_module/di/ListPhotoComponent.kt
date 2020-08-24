package ru.vyakhirev.listphoto_module.di

import dagger.Component
import ru.vyakhirev.core.CoreProvidersFactory
import ru.vyakhirev.core_api.mediator.ProvidersFacade
import ru.vyakhirev.core_api.viewmodel.ViewModelsProvider
import ru.vyakhirev.listphoto_module.ListPhotosFragment
import javax.inject.Singleton


@Singleton
@Component(
    modules = [ListPhotoModule::class],
    dependencies = [ProvidersFacade::class, ViewModelsProvider::class]
)
interface ListPhotoComponent : ViewModelsProvider {

    companion object {

        fun create(providersFacade: ProvidersFacade): ListPhotoComponent {
            return DaggerListPhotoComponent.builder()
                .viewModelsProvider(CoreProvidersFactory.createViewModelBuilder())
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(listPhotosFragment: ListPhotosFragment)
}