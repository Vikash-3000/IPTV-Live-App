import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.livetvapp.core"
    compileSdk = 36

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlin {
        explicitApi() // enables -Xexplicit-api=strict
        // OR: explicitApi = ExplicitApiMode.Strict
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
            freeCompilerArgs.add("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "2.2.10" // match your Compose version
    }
}

dependencies {
    // ✅ BoM first — always required once
    implementation (platform(libs.firebase.bom.v3312))

    // ✅ Firebase products without version
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.common.ktx)
    implementation(libs.firebase.functions.ktx)
    implementation(libs.firebase.firestore.ktx.v24111)
    implementation(libs.play.services.auth)
    implementation(libs.play.services.location)

    // Hilt (DI)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //Datastore (key-value storage) instead of sharedPref
    implementation(libs.androidx.datastore.preferences)

    implementation(libs.androidx.core.ktx.v1120) // core ktx
    implementation(libs.androidx.appcompat) // appcompat
    implementation(libs.material) // material design
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
}