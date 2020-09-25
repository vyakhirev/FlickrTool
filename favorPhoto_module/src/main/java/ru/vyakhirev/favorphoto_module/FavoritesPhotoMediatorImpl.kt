package ru.vyakhirev.favorphoto_module

import androidx.fragment.app.FragmentManager
import ru.vyakhirev.core_api.mediator.FavoritesPhotoMediator
import javax.inject.Inject

class FavoritesPhotoMediatorImpl
@Inject constructor() : FavoritesPhotoMediator {

    override fun openFavoritesPhotoScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(containerId, FavoritePhotosFragment.newInstance())
            .commit()
    }
}