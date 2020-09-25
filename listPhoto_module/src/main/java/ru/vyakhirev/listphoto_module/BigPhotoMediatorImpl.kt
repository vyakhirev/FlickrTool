package ru.vyakhirev.listphoto_module

import androidx.fragment.app.FragmentManager
import ru.vyakhirev.core_api.mediator.BigPhotoMediator
import ru.vyakhirev.core_api.mediator.ListPhotoMediator
import javax.inject.Inject

class BigPhotoMediatorImpl
@Inject constructor() : BigPhotoMediator {

    override fun openBigPhotoScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(containerId, BigPhotoFragment.newInstance())
            .commit()
    }
}