plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "me.daemon.devsuite.demo"
        minSdk = 19
        targetSdk = 30
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(libs.kotlin)
    implementation(libs.x.core.ktx)
    implementation(libs.x.appcompat)
    implementation(libs.x.constraintlayout)
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    testImplementation(libs.junit)
    androidTestImplementation(libs.x.junit)
    androidTestImplementation(libs.x.espresso.core)
}