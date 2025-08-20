import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.livetvapp.commons"
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

    implementation(libs.androidx.compose.material3.material32) // Material 3 for textfields and outlined textfield
    implementation(platform(libs.androidx.compose.bom.v20230300)) // bom for compose
    implementation(libs.androidx.ui.text.google.fonts) // for google fonts

    implementation(libs.androidx.core.ktx.v1120) // core ktx
    implementation(libs.androidx.appcompat) // appcompat
    implementation(libs.material) // material design
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)

}