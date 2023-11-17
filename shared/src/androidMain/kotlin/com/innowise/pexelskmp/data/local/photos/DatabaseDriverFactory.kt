package com.innowise.pexelskmp.data.local.photos

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.innowise.pexelskmp.database.PhotosDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(PhotosDatabase.Schema, context, "photo.db")
    }
}