package ru.vyakhirev.flickrtool.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
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

//    @ApplicationContext
//    @Provides
//    internal fun provideViewModelFactory(viewModelProvider: ViewModelProvider.Factory):ViewModelProvider.Factory{
//        return viewModelProvider
//    }
}
