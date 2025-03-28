plugins {
    alias(libs.plugins.android.androidLibrary)
    alias(libs.plugins.android.hilt)
}

android {
    namespace = "com.devaeon.core.domain"
}

dependencies {
    implementation(project(":core:common"))

}