package ru.vyakhirev.core_api.mediator

import ru.vyakhirev.core_api.database.DatabaseProvider
import ru.vyakhirev.core_api.datasource.RepositoryProvider

interface ProvidersFacade : MediatorsProvider, DatabaseProvider, AppProvider