@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.dagger.library)
    kotlin("kapt")
}

android {
    namespace = "com.cocinamingle.network.impl"
    compileSdk = 34
    defaultConfig {
        minSdk = 25
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    api(project(":core:network:api"))
    implementation(libs.bundles.retrofit)
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
}