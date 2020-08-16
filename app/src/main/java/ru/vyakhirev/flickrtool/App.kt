package ru.vyakhirev.flickrtool

import androidx.multidex.MultiDexApplication
import ru.vyakhirev.flickrtool.di.components.AppComponent
import ru.vyakhirev.flickrtool.di.components.DaggerAppComponent
import ru.vyakhirev.flickrtool.di.modules.AppModule

class App : MultiDexApplication() {

    companion object {
        var instance: App? = null
            private set
    }

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        component.inject(this)

        instance = this
    }
}
