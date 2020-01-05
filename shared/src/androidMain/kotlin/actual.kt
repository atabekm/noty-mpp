package com.example.mpp.noty.shared

import android.content.Context
import com.example.mpp.noty.NoteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun platformName(): String {
    return "Android"
}

lateinit var appContext: Context

actual fun getDriver(): SqlDriver {
    return AndroidSqliteDriver(NoteDatabase.Schema, appContext, "note.db")
}
