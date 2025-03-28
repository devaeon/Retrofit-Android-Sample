import com.android.gradle.core.android
import com.android.gradle.core.implementation

plugins {
    alias(libs.plugins.android.androidApplication)
    alias(libs.plugins.androidxNavigationSafeArgs)
    alias(libs.plugins.android.hilt)
}

android{
    namespace = "com.devaeon.retrofit"

    defaultConfig {
        applicationId = "com.devaeon.retrofit"

        versionCode = 1
        versionName = "1.0.0"
    }
}


dependencies {
    implementation(project(":features:post"))

    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
}
