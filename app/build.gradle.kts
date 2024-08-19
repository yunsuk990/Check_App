plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.check_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.check_app"
        minSdk = 24
        targetSdk = 33
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

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    //hilt
    implementation("com.google.dagger:hilt-android:2.52")
    kapt("com.google.dagger:hilt-android-compiler:2.52")

    //retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

    //okhttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    //gson
    implementation ("com.google.code.gson:gson:2.11.0")

    //GsonConverter
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    //loggingInterceptor
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //RealtimeDatabase
    implementation("com.google.firebase:firebase-database:21.0.0")

    //Firestore
    implementation("com.google.firebase:firebase-firestore:25.0.0")


}