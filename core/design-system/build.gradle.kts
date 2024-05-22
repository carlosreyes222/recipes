@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.cocinamingle.design_system"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
}

dependencies {
    implementation(libs.bundles.androidx.ui)
    implementation(libs.lottie.compose)
    implementation(libs.accompanist.permissions)
    implementation(libs.bundles.compose)
    implementation(libs.kotlin.collections.immutable)
    implementation(libs.coil.compose)
    implementation(libs.androidx.compose.material)
}