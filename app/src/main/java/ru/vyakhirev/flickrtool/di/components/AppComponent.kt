package ru.vyakhirev.flickrtool.di.components

import android.app.Application
import android.content.Context
import dagger.Component
import javax.inject.Singleton
import ru.vyakhirev.flickrtool.App
import ru.vyakhirev.flickrtool.data.sources.remote.FlickrApiService
import ru.vyakhirev.flickrtool.di.modules.*
import ru.vyakhirev.flickrtool.di.qualifiers.ApplicationContext

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        ApiModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

//    fun getAppRepository(): Repository

    fun getApiService(): FlickrApiService

    fun inject(app: App)

    @ApplicationContext
    fun context(): Context

    @ApplicationContext
    fun application(): Application
}
