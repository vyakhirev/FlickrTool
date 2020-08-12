package ru.vyakhirev.flickrtool.data.sources.db

import android.content.Context
import androidx.room.Room

// @Singleton
// class AppDbHelper @Inject
// constructor(@ApplicationContext context: Context, @DatabaseInfo name: String) {
class AppDbHelper(context: Context, name: String) {
    val database: AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, name)
        .build()
}
