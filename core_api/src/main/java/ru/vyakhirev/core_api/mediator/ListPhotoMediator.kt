package ru.vyakhirev.core_api.mediator

import android.content.Context
import androidx.fragment.app.FragmentManager


interface ListPhotoMediator {

    fun openListPhotoScreen(containerId:Int,fragmentManager: FragmentManager)
}