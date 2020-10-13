package ru.vyakhirev.listphoto_module.di

import dagger.Component
import ru.vyakhirev.core_api.mediator.ProvidersFacade
import ru.vyakhirev.listphoto_module.ListPhotosFragment
import ru.vyakhirev.listphoto_module.di.viewmodel.DaggerViewModelComponent
import ru.vyakhirev.listphoto_module.di.viewmodel.ViewModelsProvider
import javax.inject.Singleton


@Singleton
@Component(
    modules = [ListPhotoModule::class],
    dependencies = [ProvidersFacade::class,ViewModelsProvider::class]
)
interface ListPhotoComponent : ViewModelsProvider {

    companion object {

        fun create(providersFacade: ProvidersFacade): ListPhotoComponent {
            val vmComponent = DaggerViewModelComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
            return DaggerListPhotoComponent
                .builder()
                .viewModelsProvider(vmComponent)
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(listPhotosFragment: ListPhotosFragment)

}