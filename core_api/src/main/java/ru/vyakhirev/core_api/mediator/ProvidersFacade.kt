package ru.vyakhirev.core_api.mediator

import ru.vyakhirev.core_api.database.DatabaseProvider

interface ProvidersFacade : MediatorsProvider, DatabaseProvider, AppProvider