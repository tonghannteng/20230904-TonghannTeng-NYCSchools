package com.example.nycschool.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @author: Tonghann Teng
 * @since: 9/4/2023
 */
@HiltAndroidApp
class NYCSchoolApp: Application() {

    override fun onCreate() {
        super.onCreate()

    }
}