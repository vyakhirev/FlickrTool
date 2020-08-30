package ru.vyakhirev.core_impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.vyakhirev.core_api.database.DatabaseContract
import ru.vyakhirev.core_api.dto.PhotoItem

@Database(entities = [PhotoItem::class], version = 1)
abstract class AppDatabase : RoomDatabase(), DatabaseContract