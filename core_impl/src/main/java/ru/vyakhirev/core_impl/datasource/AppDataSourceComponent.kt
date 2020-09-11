package ru.vyakhirev.core_impl.datasource

import dagger.Component
import ru.vyakhirev.core_api.datasource.AppDataSource
import ru.vyakhirev.core_api.datasource.AppDataSourceProvider
import ru.vyakhirev.core_api.mediator.AppProvider
import ru.vyakhirev.core_impl.db.AppDatabase
import ru.vyakhirev.core_impl.db.AppDatabaseModule
import ru.vyakhirev.core_impl.flickrApi.FlickrApiModule
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [AppDatasourceModule::class,AppDatabaseModule::class]
)
interface AppDataSourceComponent:AppDataSourceProvider{
    fun provideAppDataSource(): AppDataSource
}
