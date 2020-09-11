package ru.vyakhirev.listphoto_module.di

import dagger.Binds
import dagger.Component
import ru.vyakhirev.core_api.datasource.Repository
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
    @Binds
    @Singleton
    abstract fun bindsRepo(repository: RepositoryImpl): Repository
    companion object {

        fun create(providersFacade: ProvidersFacade): ListPhotoComponent {
            return DaggerListPhotoComponent
                .builder()
                .viewModelsProvider(DaggerViewModelComponent.builder().build())
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(listPhotosFragment: ListPhotosFragment)

}