plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "fpt.edu.vn.tingstoreapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "fpt.edu.vn.tingstoreapp"
        minSdk = 27
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    //glide
    implementation ("com.github.bumptech.glide:glide:4.15.1")

    //flexbox
    implementation ("com.google.android.flexbox:flexbox:3.0.0")

    //circle indicator
    implementation ("me.relex:circleindicator:2.1.6")

    // gson for decode api
    implementation ("com.google.code.gson:gson:2.10.1")
    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //RxJava
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("io.reactivex.rxjava2:rxjava:2.2.2")
    //recylerview
    implementation ("androidx.recyclerview:recyclerview:1.3.0")
    //cardview
    implementation ("androidx.cardview:cardview:1.0.0")
    //Important
    implementation (platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.annotation)
    implementation(libs.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}