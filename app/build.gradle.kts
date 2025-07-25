plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services") // ✅ Apply here
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.livetvapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.livetvapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
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
    }

}

dependencies {

    // Project Modules
    implementation(project(":commons"))      // themes, colors, fonts, utils
    implementation(project(":core"))         // domain/data layer if using clean arch
    implementation(project(":features"))      // features


    // Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)

    // Firebase Remote Config
    implementation(libs.firebase.config.ktx)

    // Paging 3 + Compose integration
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.androidx.room.compiler)

    // Retrofit (API)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Hilt (DI)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // Accompanist Pager (optional, for tabs/swipe UI)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    // Optional Shimmer
    implementation(libs.compose.shimmer)

    // Exoplayer
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.ui)
    // HLS for Streaming of m3u8 files
    implementation(libs.androidx.media3.exoplayer.hls)


    implementation(libs.androidx.security.crypto)


    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)

    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}