package ru.vyakhirev.listphoto_module

import android.transition.Slide
import android.view.Gravity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import ru.vyakhirev.core_api.mediator.ListPhotoMediator
import javax.inject.Inject

class ListPhotoMediatorImpl
@Inject constructor() : ListPhotoMediator {

    override fun openListPhotoScreen(containerId: Int, fragmentManager: FragmentManager) {

        fragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.to_left_in, R.anim.to_left_out, R.anim.to_right_in, R.anim.to_right_out)
            .replace(containerId, ListPhotosFragment.newInstance())
            .commit()
    }
}