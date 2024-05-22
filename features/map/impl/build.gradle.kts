@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.dagger.library)
    kotlin("kapt")
}

android {
    namespace = "com.cocina.mingle.features.map.impl"
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
    api(project(":features:map:api"))
    implementation(project(":core:navigation"))
    implementation(project(":core:network:api"))
    implementation(project(":core:design-system"))
    implementation(libs.compose.navigation)
    implementation(libs.kotlin.collections.immutable)
    implementation(libs.hilt)
    implementation(libs.hilt.view.model)
    kapt(libs.hilt.compiler)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.compose)
    implementation(libs.material3)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.android.maps)
    testImplementation(libs.bundles.testing)
}