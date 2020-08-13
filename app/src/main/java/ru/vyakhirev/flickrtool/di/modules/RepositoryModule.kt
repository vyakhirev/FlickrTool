package ru.vyakhirev.flickrtool.di.modules

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import ru.vyakhirev.flickrtool.data.sources.repository.RepositoryImpl
import ru.vyakhirev.flickrtool.data.sources.repository.db.LocalDataSource
import ru.vyakhirev.flickrtool.data.sources.repository.remote.RemoteDataSource
import ru.vyakhirev.flickrtool.domain.Repository

@Module(includes = [DataModule::class])
// @Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        appLocalDataSource: LocalDataSource,
        appRemoteDataSource: RemoteDataSource
    ): Repository = RepositoryImpl(remoteDataSource = appRemoteDataSource)
}
