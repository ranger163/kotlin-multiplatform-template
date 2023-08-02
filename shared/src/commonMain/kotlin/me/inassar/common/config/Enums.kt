package me.inassar.common.config

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
enum class Platform {
    IOS, ANDROID, DESKTOP
}

enum class Locales(val value: String) {
    ARABIC(ARABIC_LANGUAGE), ENGLISH(ENGLISH_LANGUAGE)
}