package ru.vyakhirev.flickrtool

import dagger.Component
import ru.vyakhirev.core_api.mediator.ProvidersFacade

@Component(
    dependencies = [ProvidersFacade::class]
)
interface MainComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): MainComponent {
            return DaggerMainComponent.builder().providersFacade(providersFacade).build()
        }
    }

    fun inject(mainActivity: MainActivity)
}