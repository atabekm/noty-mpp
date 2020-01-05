package com.example.mpp.noty.shared

import com.squareup.sqldelight.db.SqlDriver

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${platformName()}"
}

expect fun getDriver(): SqlDriver
