package ru.vyakhirev.core_impl.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Reusable
import ru.vyakhirev.core_api.database.DatabaseContract
import ru.vyakhirev.core_api.database.PhotoItemDao
import javax.inject.Singleton

private const val APP_DB_NAME = "photos"

@Module
class AppDatabaseModule {

    @Provides
    @Reusable
    fun providePhotoItemDao(photoItemsDatabaseContract: DatabaseContract): PhotoItemDao {
        return photoItemsDatabaseContract.photosItemDao()
    }

    @Provides
    @Singleton
    fun providePhotoItemsDatabase(context: Context): DatabaseContract {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, APP_DB_NAME
        ).build()
    }
}