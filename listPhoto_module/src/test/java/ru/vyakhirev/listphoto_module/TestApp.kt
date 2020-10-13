package ru.vyakhirev.listphoto_module

import ru.vyakhirev.flickrtool.App

class TestApp : App() {

    override fun onCreate() {
        super.onCreate()
        setTheme(R.style.AppTheme)
        DaggerTestAppComponent.create().inject(this)

    }

}
