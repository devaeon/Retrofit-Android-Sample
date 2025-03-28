plugins {
    alias(libs.plugins.android.androidLibrary)
    alias(libs.plugins.android.hilt)
}

android {
    namespace = "com.devaeon.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}