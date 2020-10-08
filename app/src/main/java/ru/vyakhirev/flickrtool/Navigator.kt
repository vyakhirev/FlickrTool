package ru.vyakhirev.flickrtool

import androidx.fragment.app.FragmentManager
import ru.vyakhirev.listphoto_module.BigPhotoFragment
import ru.vyakhirev.listphoto_module.ListPhotosFragment
import ru.vyakhirev.listphoto_module.R
import ru.vyakhirev.listphoto_module.navigator.OpenBigPhoto
import ru.vyakhirev.listphoto_module.navigator.OpenListPhoto

class Navigator : OpenBigPhoto, OpenListPhoto {
    override fun openBigPhotoScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(containerId, BigPhotoFragment.newInstance())
            .commit()
    }

    override fun openListPhotoScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.to_left_in,
                R.anim.to_left_out,
                R.anim.to_right_in,
                R.anim.to_right_out
            )
            .replace(containerId, ListPhotosFragment.newInstance())
            .commit()
    }

//    override fun openFavoritesPhotoScreen(containerId: Int, fragmentManager: FragmentManager) {
//        fragmentManager.beginTransaction()
//            .setCustomAnimations(
//                ru.vyakhirev.favorphoto_module.R.anim.to_right_in,
//                ru.vyakhirev.favorphoto_module.R.anim.to_right_out,
//                ru.vyakhirev.favorphoto_module.R.anim.to_left_in,
//                ru.vyakhirev.favorphoto_module.R.anim.to_left_out
//            )
//            .replace(containerId, FavoritePhotosFragment.newInstance())
//            .commit()
//    }

}