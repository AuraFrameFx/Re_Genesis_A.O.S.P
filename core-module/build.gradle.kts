// core-module/build.gradle.kts - COMPLETE FIX
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)  // ✅ This is already correct
    alias(libs.plugins.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    // 🔥 ADD THESE MISSING CONFIGURATIONS 🔥
    namespace = "dev.aurakai.auraframefx.coremodule"
    compileSdk = 36  // Match your bleeding-edge setup

    defaultConfig {
        minSdk = 34      // Your required minimum
        targetSdk = 36   // Your target
        versionCode = 1
        versionName = "1.0"
    }

    // 🔥 ENABLE COMPOSE FEATURES 🔥
    buildFeatures {
        compose = true
        dataBinding = true
        viewBinding = true
        buildConfig = true
        aidl = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_25
        targetCompatibility = JavaVersion.VERSION_25
    }

    kotlin {
        jvmToolchain(25)
    }

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(25)
        }
    }
}

dependencies {
    // Your existing dependencies stay the same
    api(project(":list"))
    implementation(libs.kotlin.stdlib.jdk8)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.commons.io)
    implementation(libs.commons.compress)
    implementation(libs.xz)
    implementation(libs.slf4j.api)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Testing dependencies
    testImplementation(libs.junit.jupiter.api)
    testImplementation(libs.junit.jupiter.params)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.mockk)
    implementation(libs.androidx.core.ktx)
}
