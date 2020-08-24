package ru.vyakhirev.core_api.datasource

interface RepositoryProvider {
    fun provideRepository():Repository
}