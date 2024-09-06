plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.appexam"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appexam"
        minSdk = 24
        targetSdk = 34
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

    //Activación del viewBinding
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Menu
    implementation("androidx.drawerlayout:drawerlayout:1.2.0")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")

    //DaggerHilt
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    // Fragment
    implementation ("androidx.fragment:fragment-ktx:1.8.3")

    // Activity
    implementation ("androidx.activity:activity-ktx:1.9.1")
    /*MVVM Live Data*/
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")
    //Corrutinas
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    //Gson
    implementation ("com.google.code.gson:gson:2.10.1")


}