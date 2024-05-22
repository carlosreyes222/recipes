@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.dagger.library)
    kotlin("kapt")
}

android {
    namespace = "com.cocinamingle.navigation"
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

    kapt {
        correctErrorTypes = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
}

dependencies {
    implementation(libs.material3)
    implementation(libs.compose.navigation)
    implementation(libs.bundles.compose)
    implementation(libs.accompanist.navigation)
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
}