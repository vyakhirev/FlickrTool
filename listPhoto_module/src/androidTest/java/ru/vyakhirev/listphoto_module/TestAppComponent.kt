package ru.vyakhirev.listphoto_module

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.vyakhirev.core_api.mediator.AppWithFacade
import javax.inject.Singleton


@Component
@Singleton
interface TestAppComponent : AppWithFacade {
    companion object {

        @Component.Builder
        internal interface Builder {
            @BindsInstance
            fun application(application: Application?): Builder?
            fun build(): TestAppComponent?
        }
    }

    fun inject(favorClickTest: FavorClickTest)
    fun inject(listPhotosFragment: ListPhotosFragment)
}