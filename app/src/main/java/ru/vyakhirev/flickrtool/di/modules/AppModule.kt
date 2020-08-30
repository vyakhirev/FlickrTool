package ru.vyakhirev.flickrtool.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import ru.vyakhirev.flickrtool.data.sources.db.AppDatabase
import ru.vyakhirev.flickrtool.data.sources.db.PhotoItemDao
import ru.vyakhirev.flickrtool.di.qualifiers.ApplicationContext

@Module
class AppModule(private val application: Application) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return application
    }

    @Provides
    @ApplicationContext
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    internal fun provideAppDb(): AppDatabase {
        return AppDatabase.getDatabase(application)
    }

    @Singleton
    @Provides
    fun providesProductDao(flickrDatabase: AppDatabase): PhotoItemDao {
        return flickrDatabase.imageItemDao()
    }
}
