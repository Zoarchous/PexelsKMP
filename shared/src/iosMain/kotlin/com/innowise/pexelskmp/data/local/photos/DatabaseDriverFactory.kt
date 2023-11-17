package com.innowise.pexelskmp.data.local.photos

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.innowise.pexelskmp.database.PhotosDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PhotosDatabase.Schema, "photo.db")
    }
}