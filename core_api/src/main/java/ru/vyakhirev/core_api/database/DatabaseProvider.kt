package ru.vyakhirev.core_api.database

interface DatabaseProvider {

    fun provideAppDb(): DatabaseContract

    fun providesPhotoDao(): PhotoItemDao

}