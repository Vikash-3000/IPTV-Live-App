plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose) // 👈 Add this line
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.livetvapp.features"
    compileSdk = 36

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        compose = true
        viewBinding = true
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
}

dependencies {

    // Project Modules
    implementation(project(":commons"))      // themes, colors, fonts, utils
    implementation(project(":core"))         // domain/data layer if using clean arch

    implementation(libs.androidx.compose.material3.material32) // Material 3 for textfields and outlined textfield

    implementation(libs.lottie) // lottie animation

    implementation(libs.sdp.android) // sdp for scalable new side

    implementation(libs.androidx.navigation.compose) // navigation component

    implementation(libs.androidx.material.icons.extended) // Material Icon

    implementation(libs.ui.tooling.preview) //Preview Jetpack Compose

    // Hilt (DI)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    //Google play services
    implementation(libs.firebase.auth.ktx)
    implementation(libs.play.services.auth)

    implementation(libs.androidx.core.ktx.v1120) // core ktx
    implementation(libs.androidx.appcompat) // appcompat
    implementation(libs.material) // material design
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)

}