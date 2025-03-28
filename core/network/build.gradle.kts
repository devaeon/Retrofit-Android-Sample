import com.android.gradle.core.implementation

plugins {
    alias(libs.plugins.android.androidLibrary)
    alias(libs.plugins.android.hilt)
}

android {
    namespace = "com.devaeon.network"

    buildFeatures.buildConfig = true
    defaultConfig{
        buildConfigField(
            "String",
            "BASE_URL",
            "\"${project.findProperty("baseUrl") ?: "https://jsonplaceholder.typicode.com/"}\""
        )
    }
}

dependencies {
    implementation(project(":core:common"))

    implementation(libs.okhttp)
    implementation(libs.retrofit2.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.json)
}