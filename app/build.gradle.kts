import com.android.gradle.core.android
import com.android.gradle.core.implementation

plugins {
    alias(libs.plugins.android.androidApplication)
    alias(libs.plugins.androidxNavigationSafeArgs)
    alias(libs.plugins.android.hilt)
}

android{
    namespace = "com.devaeon.retrofit"


    buildFeatures.viewBinding = true
    buildFeatures.buildConfig= true

    defaultConfig {
        applicationId = "com.devaeon.retrofit"

        versionCode = 1
        versionName = "1.0.0"
    }

}


dependencies {
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.datastore)
    implementation(libs.androidx.recyclerView)
    implementation(libs.androidx.fragment.ktx)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.common.java8)

    implementation(libs.retrofit2.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.logging.interceptor)
}
