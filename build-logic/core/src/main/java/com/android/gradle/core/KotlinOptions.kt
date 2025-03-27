package com.android.gradle.core

import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Action
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

fun LibraryExtension.kotlinOptions(configure: Action<KotlinJvmOptions>): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)

fun BaseAppModuleExtension.kotlinOptions(configure: Action<KotlinJvmOptions>): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)