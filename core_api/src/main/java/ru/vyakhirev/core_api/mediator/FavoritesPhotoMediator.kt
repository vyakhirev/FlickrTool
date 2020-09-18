package ru.vyakhirev.core_api.mediator

import androidx.fragment.app.FragmentManager

interface FavoritesPhotoMediator {

    fun openFavoritesPhotoScreen(containerId:Int,fragmentManager: FragmentManager)
}