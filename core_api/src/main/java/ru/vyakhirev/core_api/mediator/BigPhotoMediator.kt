package ru.vyakhirev.core_api.mediator

import androidx.fragment.app.FragmentManager

interface BigPhotoMediator {

    fun openBigPhotoScreen(containerId:Int,fragmentManager: FragmentManager)
}