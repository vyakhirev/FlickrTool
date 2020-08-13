package ru.vyakhirev.flickrtool.di.modules

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import ru.vyakhirev.flickrtool.data.sources.db.FlickrDatabase
import ru.vyakhirev.flickrtool.data.sources.repository.RepositoryImpl
import ru.vyakhirev.flickrtool.data.sources.repository.db.LocalDataSource
import ru.vyakhirev.flickrtool.data.sources.repository.remote.RemoteDataSource
import ru.vyakhirev.flickrtool.di.qualifiers.DatabaseInfo
import ru.vyakhirev.flickrtool.di.qualifiers.Local
import ru.vyakhirev.flickrtool.di.qualifiers.Remote
import ru.vyakhirev.flickrtool.domain.AppDataSource
import ru.vyakhirev.flickrtool.domain.usecases.GetPhotoSearchUseCase

@Module
class DataModule {

    @Provides
    @Singleton
    @DatabaseInfo
    internal fun provideDatabaseName(): String {
        return "flickrdatabase"
    }

    @Provides
    @Singleton
    @Local
    internal fun provideLocalDataSource(appLocalDataSource: LocalDataSource): AppDataSource {
        return appLocalDataSource
    }

    @Provides
    @Singleton
    @Remote
    internal fun provideRemoteDataSource(appRemoteDataSource: RemoteDataSource): AppDataSource {
        return appRemoteDataSource
    }

//    @Provides
//    @Singleton
//    internal fun provideAppRepository(dataRepository: RepositoryImpl): Repository {
//        return dataRepository
//    }

    @Provides
    @Singleton
    internal fun provideAppDb(flickrDatabase: FlickrDatabase): FlickrDatabase {
        return flickrDatabase
    }

    @Provides
    @Singleton
    internal fun provideGetPhotoUseCase(dataRepository: RepositoryImpl): GetPhotoSearchUseCase {
        return GetPhotoSearchUseCase(dataRepository)
    }
}

//    @Provides
//    @Singleton
//    @PreferenceInfo
//    internal fun providePreferenceName(): String {
//        return AppConstants.PREF_NAME
//    }

//    @Provides
//    @Singleton
//    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PrefsHelper {
//        return appPreferencesHelper
//    }
