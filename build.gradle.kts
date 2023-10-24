@file:Suppress("DSL_SCOPE_VIOLATION")

buildscript{
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(libs.classpath.buildKonfig)
    }
}

plugins {
    alias(libs.plugins.jvm) apply false
    alias(libs.plugins.multiplatform) apply false
    alias(libs.plugins.android) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.compose) apply false
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}
