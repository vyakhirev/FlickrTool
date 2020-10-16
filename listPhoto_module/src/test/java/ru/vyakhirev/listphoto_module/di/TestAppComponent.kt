package ru.vyakhirev.listphoto_module.di

import dagger.Component
import ru.vyakhirev.core_api.mediator.AppWithFacade
import ru.vyakhirev.listphoto_module.ListPhotosFragmentTest
import ru.vyakhirev.listphoto_module.TestApp
import javax.inject.Singleton

@Singleton
@Component(modules = [TestFlickrApiModule::class])
interface TestAppComponent : AppWithFacade {

    fun inject(listPhotosFragmentTest: ListPhotosFragmentTest)

    fun inject(testApp: TestApp)

}
