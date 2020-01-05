package com.example.mpp.noty.shared

import com.example.mpp.noty.NoteDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.ios.NativeSqliteDriver
import platform.UIKit.UIDevice

actual fun platformName(): String {
    return "${UIDevice.currentDevice.systemName()} ${UIDevice.currentDevice.systemVersion}"
}

actual fun getDriver(): SqlDriver {
    return NativeSqliteDriver(NoteDatabase.Schema, "note.db")
}
