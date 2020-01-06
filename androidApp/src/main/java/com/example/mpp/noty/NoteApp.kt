package com.example.mpp.noty

import android.app.Application
import com.example.mpp.noty.shared.appContext

class NoteApp : Application() {

    override fun onCreate() {
        super.onCreate()

        appContext = this
    }
}
