package ru.vyakhirev.flickrtool

import androidx.multidex.MultiDexApplication
import ru.vyakhirev.core_api.mediator.AppWithFacade
import ru.vyakhirev.core_api.mediator.ProvidersFacade

class App : MultiDexApplication(), AppWithFacade {

    companion object {
        private var facadeComponent: FacadeComponent? = null
    }

    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }
}
