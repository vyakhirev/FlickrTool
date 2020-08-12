package ru.vyakhirev.flickrtool.data.sources.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem

@Database(entities = [PhotoItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun imageItemDao(): PhotoItemDao
}
