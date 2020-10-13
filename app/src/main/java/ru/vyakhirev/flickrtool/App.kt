package ru.vyakhirev.flickrtool

import android.app.Application
import ru.vyakhirev.core_api.mediator.AppWithFacade
import ru.vyakhirev.core_api.mediator.ProvidersFacade

open class App : Application(), AppWithFacade {

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
