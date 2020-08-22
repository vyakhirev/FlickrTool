package ru.vyakhirev.flickrtool

import androidx.multidex.MultiDexApplication
import ru.vyakhirev.core_api.mediator.AppWithFacade
import ru.vyakhirev.core_api.mediator.ProvidersFacade
import ru.vyakhirev.flickrtool.di.components.AppComponent

class App : MultiDexApplication(), AppWithFacade {

    companion object {
        var instance: App? = null
            private set

        private var facadeComponent: FacadeComponent? = null
    }

    lateinit var component: AppComponent


    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    //    override fun onCreate() {
//        super.onCreate()
//
//        component = DaggerAppComponent.builder()
//            .appModule(AppModule(this))
//            .build()
//
//        component.inject(this)
//
//        instance = this
//    }
    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }
}
