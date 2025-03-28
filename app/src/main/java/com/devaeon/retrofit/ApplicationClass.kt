package com.devaeon.retrofit

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass : Application(){

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate: called")
    }
}

private const val TAG = "ApplicationClassLogs"
