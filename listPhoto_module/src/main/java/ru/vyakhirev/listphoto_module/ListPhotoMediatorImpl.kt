package ru.vyakhirev.listphoto_module

import androidx.fragment.app.FragmentManager
import ru.vyakhirev.core_api.mediator.ListPhotoMediator
import javax.inject.Inject

class ListPhotoMediatorImpl
@Inject constructor() : ListPhotoMediator {

    override fun openListPhotoScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(containerId, ListPhotosFragment.newInstance())
            .commit()
    }
}