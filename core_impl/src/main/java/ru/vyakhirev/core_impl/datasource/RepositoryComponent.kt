package ru.vyakhirev.core_impl.datasource

import dagger.Component
import ru.vyakhirev.core_api.datasource.AppDataSource
import ru.vyakhirev.core_api.datasource.RepositoryProvider
import ru.vyakhirev.core_api.mediator.AppProvider
import ru.vyakhirev.core_impl.db.AppDatabase
import ru.vyakhirev.core_impl.db.AppDatabaseModule
import ru.vyakhirev.core_impl.flickrApi.FlickrApiModule
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [FlickrApiModule::class, RepositoryModule::class, AppDatabaseModule::class]
)
interface RepositoryComponent : RepositoryProvider {

    fun provideAppDataSource(): AppDatabase

}
