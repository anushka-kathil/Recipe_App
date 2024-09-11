plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-parcelize") // Adding the Parcelize plugin
}


android {
    namespace = "com.example.recipeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.recipeapp"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
   // compose viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-android:2.6.2")

    // Network calls
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Jason to kotlin object mapping - to convert jason file to kotlin file
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Image loading - to load image from the internet
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Navigation
    val nav_version = "2.8.0"
    implementation("androidx.navigation:navigation-compose:$nav_version")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")



//    implementation ("androidx.activity:activity-compose:1.8.0") // Match with Compose version
//    implementation ("androidx.navigation:navigation-compose:2.7.0") // Match with Compose version

//    def compose_version = "1.5.0" // Iguana
//    implementation ("androidx.compose.ui:ui:$compose_version")
//    implementation ("androidx.compose.material3:material3:$compose_version")
//    implementation ("androidx.compose.foundation:foundation:$compose_version")
//    implementation ("androidx.compose.animation:animation:$compose_version")
//    implementation ("androidx.compose.runtime:runtime:$compose_version")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0") // Example lifecycle version





    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.room.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}