package ru.vyakhirev.flickrtool

import dagger.Binds
import dagger.Module

@Module
abstract class NavigatorModule {
    @Binds
    abstract fun provideNavigator(navigator: Navigator): Navigator
}