package com.innowise.pexelskmp.android.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import com.innowise.pexelskmp.data.local.photos.DatabaseDriverFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver = DatabaseDriverFactory(app).createDriver()
}