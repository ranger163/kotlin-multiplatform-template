import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Created by Ahmed Nassar on 5/24/23.
 * Util functions for adding the different type dependencies from build.gradle file
 */

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.ksp(list: List<String>) {
    list.forEach { dependency ->
        add("ksp", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.platformImplementation(dependency: String) {
    add("implementation", platform(dependency))
}

fun DependencyHandler.platformImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", platform(dependency))
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}