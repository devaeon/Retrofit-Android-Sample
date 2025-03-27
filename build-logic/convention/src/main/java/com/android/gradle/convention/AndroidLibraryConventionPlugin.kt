package com.android.gradle.convention

import com.android.gradle.core.androidLib
import com.android.gradle.core.kotlinOptions
import com.android.gradle.core.libs.getLibs
import com.android.gradle.core.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()

        plugins {
            apply(libs.plugins.android.library)
            apply(libs.plugins.jetBrains.kotlin.android)
        }

        androidLib {
            compileSdk = libs.versions.android.compileSdk

            defaultConfig.apply {
                targetSdk = libs.versions.android.compileSdk
                minSdk = libs.versions.android.minSdk
            }

            compileOptions.apply {
                sourceCompatibility = libs.versions.java
                targetCompatibility = libs.versions.java
            }

            kotlinOptions {
                jvmTarget = libs.versions.jvmTarget
            }
        }
    }
}
