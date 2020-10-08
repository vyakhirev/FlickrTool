package ru.vyakhirev.listphoto_module.navigator

import androidx.fragment.app.FragmentManager

interface OpenBigPhoto {
    fun openBigPhotoScreen(containerId: Int, fragmentManager: FragmentManager)
}