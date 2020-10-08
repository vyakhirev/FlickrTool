package ru.vyakhirev.flickrtool

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class NavigatorModule {
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideNavigator(): Navigator = Navigator()
    }
}