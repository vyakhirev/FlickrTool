package ru.vyakhirev.flickrtool

import android.app.Application
import dagger.Component
import ru.vyakhirev.core.CoreProvidersFactory
import ru.vyakhirev.core_api.database.DatabaseProvider
import ru.vyakhirev.core_api.datasource.RepositoryProvider
import ru.vyakhirev.core_api.mediator.AppProvider
import ru.vyakhirev.core_api.mediator.ProvidersFacade

@Component(
    dependencies = [AppProvider::class, DatabaseProvider::class, RepositoryProvider::class],
    modules = [MediatorsBindings::class]
)
interface FacadeComponent : ProvidersFacade {

    companion object {

        fun init(application: Application): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvider(AppComponent.create(application))
                .repositoryProvider(CoreProvidersFactory.createRepositoryBuilder(AppComponent.create(application)))
                .databaseProvider(CoreProvidersFactory.createDatabaseBuilder(AppComponent.create(application)))
                .build()
    }

    fun inject(app: App)
}