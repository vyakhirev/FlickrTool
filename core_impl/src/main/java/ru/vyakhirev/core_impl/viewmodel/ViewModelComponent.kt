package ru.vyakhirev.core_impl.viewmodel

import dagger.Component
import ru.vyakhirev.core_api.viewmodel.ViewModelsProvider
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class])
interface ViewModelComponent : ViewModelsProvider