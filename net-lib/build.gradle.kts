plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp.android)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.netlib"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 34
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField ("String", "BASE_URL", "\"http://10.61.60.79:8000/api/\"")
        }
        release {
            buildConfigField ("String", "BASE_URL", "\"http://10.61.60.79:8000/api/\"")
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
    buildFeatures {
        android.buildFeatures.buildConfig = true
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    api(libs.retrofit)
    api(libs.converter.gson)
    implementation(libs.kotlinx.coroutines.android)
    api(libs.logging.interceptor)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    testImplementation(libs.core.ktx)
    testImplementation(libs.junit)
    testImplementation(libs.mockwebserver)
    testImplementation(libs.apollo.mockserver)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.hilt.android.testing)
    kspTest(libs.dagger.hilt.android.compiler)
    testImplementation(libs.robolectric)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}