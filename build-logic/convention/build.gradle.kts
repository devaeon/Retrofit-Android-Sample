import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.android.gradle.buildlogic.convention"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    implementation(project(":core"))
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.android.gradle.android.application"
            implementationClass = "com.android.gradle.convention.AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "com.android.gradle.android.library"
            implementationClass = "com.android.gradle.convention.AndroidLibraryConventionPlugin"
        }

        register("androidHilt") {
            id = "com.android.gradle.android.hilt"
            implementationClass = "com.android.gradle.convention.HiltConventionPlugin"
        }

    }
}
