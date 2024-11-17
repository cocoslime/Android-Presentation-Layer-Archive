plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.cocoslime.presentation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cocoslime.presentation"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.fragment)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.fragment)

    // compose
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)

    //hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.compiler)

    // orbit
    implementation(libs.orbit.core)
    implementation(libs.orbit.compose)
    implementation(libs.orbit.viewmodel)

    // coil
    implementation(libs.coil)
    implementation(libs.coil.compose)

    implementation(libs.paging.runtime)
    implementation(libs.glide)

    // retrofit and okhttp
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.serialization)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
}