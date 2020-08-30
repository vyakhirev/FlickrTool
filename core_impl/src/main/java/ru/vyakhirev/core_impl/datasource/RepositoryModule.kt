package ru.vyakhirev.core_impl.datasource

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.vyakhirev.core_api.database.DatabaseContract
import ru.vyakhirev.core_api.datasource.Repository
import ru.vyakhirev.core_impl.db.AppDatabase
import javax.inject.Singleton

private const val APP_DB_NAME = "photos"

@Module
class RepositoryModule {

//    @Provides
//    @Singleton
//    fun provideAppDataSource(): AppDatabase{
//        return
//    }

    @Provides
    @Singleton
    fun providePhotoItemsDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, APP_DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(repositoryImpl: RepositoryImpl):Repository{
        return repositoryImpl
    }

}