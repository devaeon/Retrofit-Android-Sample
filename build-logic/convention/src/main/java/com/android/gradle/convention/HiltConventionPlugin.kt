package com.android.gradle.convention

import com.android.gradle.core.implementation
import com.android.gradle.core.ksp
import com.android.gradle.core.libs.getLibs
import com.android.gradle.core.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()

        plugins {
            apply(libs.plugins.google.ksp)
            apply(libs.plugins.google.daggerHiltAndroid)
        }

        dependencies {
            implementation(libs.getLibrary("google.dagger.hilt"))
            ksp(libs.getLibrary("google.dagger.hilt.compiler"))
        }
    }
}