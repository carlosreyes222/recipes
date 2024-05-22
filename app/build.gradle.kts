plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.dagger.library)
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.cocina.mingle"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cocina.mingle"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":core:network:impl"))
    implementation(project(":core:design-system"))
    implementation(project(":features:home:impl"))
    implementation(project(":features:map:impl"))
    implementation(project(":features:recipe-detail:impl"))

    implementation(libs.hilt)
    implementation(libs.hilt.view.model)
    kapt(libs.hilt.compiler)
    implementation(libs.compose.navigation)
    implementation(libs.bundles.androidx.ui)
    implementation(libs.bundles.retrofit)
    implementation(libs.accompanist.permissions)
    implementation (libs.lifecycle.viewmodel.ktx)
    implementation (libs.lifecycle.runtime.ktx)
    implementation(libs.ui.tooling.preview)
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.kotlin.collections.immutable)

}