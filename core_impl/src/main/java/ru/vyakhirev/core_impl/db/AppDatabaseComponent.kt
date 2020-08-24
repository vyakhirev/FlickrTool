package ru.vyakhirev.core_impl.db

import dagger.Component
import ru.vyakhirev.core_api.database.DatabaseProvider
import ru.vyakhirev.core_api.mediator.AppProvider
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [AppDatabaseModule::class]
)
interface AppDatabaseComponent : DatabaseProvider