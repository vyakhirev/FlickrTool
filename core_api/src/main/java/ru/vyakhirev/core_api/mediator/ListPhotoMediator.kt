package ru.vyakhirev.core_api.mediator

import androidx.fragment.app.FragmentManager


interface ListPhotoMediator {

    fun openListPhotoScreen(containerId:Int,fragmentManager: FragmentManager)
}