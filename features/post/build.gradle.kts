import com.android.gradle.core.implementation

plugins {
    alias(libs.plugins.android.androidLibrary)
    alias(libs.plugins.android.hilt)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.devaeon.post"

    buildFeatures.viewBinding=true
}

dependencies {
    implementation(project(":core:common"))

    implementation(project(":core:data"))
    implementation(project(":core:domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appCompat)
    implementation(libs.google.material)
    implementation(libs.androidx.recyclerView)
    implementation(libs.androidx.fragment.ktx)
}