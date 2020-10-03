package ru.vyakhirev.listphoto_module.animations

import io.reactivex.Single

interface AnimatedTransitionFragment {
    fun exit() : Single<Boolean>
    
}