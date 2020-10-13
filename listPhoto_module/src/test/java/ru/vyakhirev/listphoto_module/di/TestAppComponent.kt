package ru.vyakhirev.listphoto_module.di

import dagger.Component
import retrofit2.Retrofit
import ru.vyakhirev.flickrtool.App
import ru.vyakhirev.flickrtool.AppComponent
import ru.vyakhirev.listphoto_module.ListPhotosFragmentTest
import javax.inject.Singleton

@Singleton
@Component(modules = [TestFlickrApiModule::class])
interface TestAppComponent : AppComponent {
    fun inject(listPhotosFragmentTest: ListPhotosFragmentTest)

//    companion object {
//
//        fun create(): TestAppComponent {
//            return DaggerTestAppComponent.builder().build()
//        }
//    }

    fun provideRetrofit(): Retrofit

    fun inject(app: App)


}
