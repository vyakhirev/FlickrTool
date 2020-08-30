package ru.vyakhirev.core

import ru.vyakhirev.core_api.database.DatabaseProvider
import ru.vyakhirev.core_api.mediator.AppProvider
import ru.vyakhirev.core_api.viewmodel.ViewModelsProvider
import ru.vyakhirev.core_impl.db.DaggerDatabaseComponent
import ru.vyakhirev.core_impl.viewmodel.DaggerViewModelComponent

object CoreProvidersFactory {

    fun createDatabaseBuilder(appProvider: AppProvider): DatabaseProvider {
        return DaggerDatabaseComponent.builder().appProvider(appProvider).build()
    }

    fun createViewModelBuilder(): ViewModelsProvider {
        return DaggerViewModelComponent.create()
    }
}