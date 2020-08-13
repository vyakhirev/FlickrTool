package ru.vyakhirev.flickrtool.di.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import ru.vyakhirev.flickrtool.di.scopes.PerActivity

@Module
class ActivityModule(private val mainActivity: AppCompatActivity) {

    @Provides
    @PerActivity
    internal fun provideContext(): Context {
        return mainActivity
    }

    @Provides
    @PerActivity
    internal fun provideActivity(): AppCompatActivity {
        return mainActivity
    }

//    @Provides
//    internal fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory {
//        return factory
//    }
}
