package ru.vyakhirev.favorphoto_module.di.viewmodel

import dagger.Component
import ru.vyakhirev.core_api.mediator.ProvidersFacade
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelModule::class],
    dependencies = [ProvidersFacade::class]
)
interface ViewModelComponent : ViewModelsProvider