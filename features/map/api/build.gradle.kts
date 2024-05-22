@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")
}

android {
    compileSdk = 34
    defaultConfig {
        minSdk = 25
    }
    namespace = "com.cocina.mingle.features.map.api"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.navigation.common.ktx)
}