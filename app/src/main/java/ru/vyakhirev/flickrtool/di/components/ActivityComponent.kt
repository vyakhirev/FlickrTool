package ru.vyakhirev.flickrtool.di.components

import dagger.Component
import ru.vyakhirev.flickrtool.di.modules.ActivityModule
import ru.vyakhirev.flickrtool.di.modules.ViewModelModule
import ru.vyakhirev.flickrtool.di.scopes.PerActivity
import ru.vyakhirev.flickrtool.presentation.view.ListPhotosFragment
import ru.vyakhirev.flickrtool.presentation.view.MainActivity

@PerActivity
@Component(
    dependencies = [AppComponent::class], modules = [
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(listPhotosFragment: ListPhotosFragment)

//    fun inject(viewModelModule: ViewModelModule)
}
