package ru.vyakhirev.core

import ru.vyakhirev.core_api.database.DatabaseProvider
import ru.vyakhirev.core_api.datasource.AppDataSourceProvider
import ru.vyakhirev.core_api.datasource.RepositoryProvider
import ru.vyakhirev.core_api.mediator.AppProvider
import ru.vyakhirev.core_impl.datasource.DaggerAppDataSourceComponent
import ru.vyakhirev.core_impl.datasource.DaggerRepositoryComponent
import ru.vyakhirev.core_impl.db.DaggerAppDatabaseComponent

object CoreProvidersFactory {

    fun createDatabaseBuilder(appProvider: AppProvider): DatabaseProvider {
        return DaggerAppDatabaseComponent.builder().appProvider(appProvider).build()
    }

    fun createRepositoryBuilder(appProvider: AppProvider):RepositoryProvider {
        return DaggerRepositoryComponent.builder().appProvider(appProvider).build()
    }

    fun createAppDataSourceBuilder():AppDataSourceProvider{
        return DaggerAppDataSourceComponent.builder().build()
    }

//    fun createViewModelBuilder(): ViewModelsProvider {
//        return DaggerViewModelComponent.create()
//    }
}