plugins {
    kotlin("jvm") version Versions.kotlinVersion apply false
    kotlin("multiplatform") version Versions.kotlinVersion apply false
    kotlin("android") version Versions.kotlinVersion apply false

    id("com.android.application") version Versions.agpVersion apply false
    id("com.android.library") version Versions.agpVersion apply false
    id("org.jetbrains.compose") version Versions.composeMultiplatformVersion apply false
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}
