@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.com.android.application) apply false
    id("com.android.library").version("8.0.0").apply(false)
    kotlin("android").version("1.8.21").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
    alias(libs.plugins.sql.delight) apply false
    alias(libs.plugins.dagger.hilt) apply false
}

buildscript {
    dependencies {
        classpath(libs.kotlin.serialization)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
