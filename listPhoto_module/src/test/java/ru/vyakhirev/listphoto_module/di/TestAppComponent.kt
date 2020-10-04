package ru.vyakhirev.listphoto_module.di

import dagger.Component
import ru.vyakhirev.core_api.mediator.AppWithFacade
import ru.vyakhirev.listphoto_module.ListPhotosFragmentTest
import javax.inject.Singleton

@Component(modules = [TestFlickrApiModule::class])
@Singleton
interface TestAppComponent : AppWithFacade {

    fun inject(listPhotosFragment: ListPhotosFragmentTest)
}
//@Component
//@Singleton
//interface TestAppComponent : AppWithFacade {
//    companion object {
//
//        @Component.Builder
//        internal interface Builder {
//            @BindsInstance
//            fun application(application: Application?): Builder?
//            fun build(): TestAppComponent?
//        }
//    }
//
//    fun inject(favorClickTest: FavorClickTest)
//    fun inject(listPhotosFragment: ListPhotosFragment)
//}
//companion object {
//
//    fun create(providersFacade: ProvidersFacade): ListPhotoComponent {
//        val vmComponent = DaggerViewModelComponent
//            .builder()
//            .providersFacade(providersFacade)
//            .build()
//        return DaggerListPhotoComponent
//            .builder()
//            .viewModelsProvider(vmComponent)
//            .providersFacade(providersFacade)
//            .build()
//    }
//}