package ru.vyakhirev.core_impl.datasource

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.vyakhirev.core_api.datasource.AppDataSource
import ru.vyakhirev.core_impl.db.AppDatabase
import javax.inject.Singleton

private const val APP_DB_NAME = "photos"

@Module
class AppDatasourceModule {

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
    fun provideLocalDataSource(localDataSource: LocalDataSource): AppDataSource {
        return localDataSource
    }


//    @Provides
//    @Singleton
//    fun provideRemoteDataSource(remoteDataSource: RemoteDataSource): AppDataSource {
//        return remoteDataSource
//    }
}