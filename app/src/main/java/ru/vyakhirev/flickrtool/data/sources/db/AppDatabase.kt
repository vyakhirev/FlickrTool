package ru.vyakhirev.flickrtool.data.sources.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem

@Database(entities = [PhotoItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun imageItemDao(): PhotoItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "flickrdatabase"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
}
