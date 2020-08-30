package ru.vyakhirev.flickrtool.di.components

import android.app.Application
import android.content.Context
import dagger.Component
import javax.inject.Singleton
import ru.vyakhirev.flickrtool.App
import ru.vyakhirev.flickrtool.data.sources.db.AppDatabase
import ru.vyakhirev.flickrtool.data.sources.remote.FlickrApiService
import ru.vyakhirev.flickrtool.di.modules.ApiModule
import ru.vyakhirev.flickrtool.di.modules.AppModule
import ru.vyakhirev.flickrtool.di.modules.viewmodels.ViewModelModule
import ru.vyakhirev.flickrtool.di.qualifiers.ApplicationContext

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun getApiService(): FlickrApiService

    fun getAppDatabase(): AppDatabase

    fun inject(app: App)

    @ApplicationContext
    fun context(): Context

    @ApplicationContext
    fun application(): Application
}
