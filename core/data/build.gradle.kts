import com.android.gradle.core.implementation
import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.androidLibrary)
    alias(libs.plugins.android.hilt)
}

android {
    namespace = "com.devaeon.core.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:network"))
    implementation(project(":core:common"))


    implementation(libs.retrofit2.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.json)
}