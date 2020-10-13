package ru.vyakhirev.listphoto_module.di

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import ru.vyakhirev.listphoto_module.TestApp

class MyCustomTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, name: String?, context: Context): Application {
        return super.newApplication(cl, TestApp::class.java.name, context)
    }
}