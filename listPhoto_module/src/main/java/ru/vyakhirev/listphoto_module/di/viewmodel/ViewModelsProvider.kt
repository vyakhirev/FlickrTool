package ru.vyakhirev.listphoto_module.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.vyakhirev.core_api.datasource.Repository

interface ViewModelsProvider {

    fun provideMap(): @JvmSuppressWildcards HashMap<Class<out ViewModel>, ViewModel>

    fun provideViewModel(): ViewModelProvider.Factory
}