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
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.livetvapp"
        minSdk = 24
        targetSdk = 35
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
    }
}

dependencies {

    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.activity.compose.v181)
    implementation(platform(libs.androidx.compose.bom.v20230300))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.compose.material3.material32)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(platform(libs.androidx.compose.bom.v20250600))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    //Material
    implementation (libs.androidx.material.icons.extended)

    //Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)

    //Firebase Remote Config
    implementation("com.google.firebase:firebase-config-ktx:22.1.1")

    // Paging 3 + Compose integration
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)
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

    //Exoplayer
    implementation (libs.androidx.media3.exoplayer)
    implementation (libs.androidx.media3.ui)
    //HLS for Streaming of m3u8 files
    implementation(libs.androidx.media3.exoplayer.hls)

    //firebase auth
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.functions.ktx)
    implementation(libs.androidx.security.crypto)

    implementation (libs.lottie) // Use the latest version

    implementation(libs.sdp.android) //sdp for scalable new side

}