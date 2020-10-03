package ru.vyakhirev.favorphoto_module

import androidx.fragment.app.FragmentManager
import ru.vyakhirev.core_api.mediator.FavoritesPhotoMediator
import javax.inject.Inject

class FavoritesPhotoMediatorImpl
@Inject constructor() : FavoritesPhotoMediator {

    override fun openFavoritesPhotoScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .setCustomAnimations( R.anim.to_right_in, R.anim.to_right_out,R.anim.to_left_in, R.anim.to_left_out)
            .replace(containerId, FavoritePhotosFragment.newInstance())
            .commit()
    }
}