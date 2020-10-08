package ru.vyakhirev.listphoto_module.navigator

import androidx.fragment.app.FragmentManager

interface OpenListPhoto {
    fun openListPhotoScreen(containerId: Int, fragmentManager: FragmentManager)
}