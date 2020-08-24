package ru.vyakhirev.core_api.datasource

interface AppDataSourceProvider {
    fun provideDataSource():AppDataSource
}