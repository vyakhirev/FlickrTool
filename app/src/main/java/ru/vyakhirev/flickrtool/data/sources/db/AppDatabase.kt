package ru.vyakhirev.flickrtool.data.sources.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PhotoItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun imageItemDao(): PhotoItemDao
}
