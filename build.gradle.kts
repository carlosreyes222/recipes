// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.com.android.library) apply false
    alias(libs.plugins.dagger.library) apply false
    alias(libs.plugins.google.gms.services) apply false
}

