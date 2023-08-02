package me.inassar.common.locale

import me.inassar.common.config.Locales
import me.inassar.platform.currentDeviceLanguage

/**
 * Created by Ahmed Nassar on 8/2/23.
 * Used to get translated string resources when required.
 * It currently has AR and EN languages but you ca always add more languages as you need. But don't
 * forget to update Local.kt enum class with your needed languages.
 * Also you can pass args to append it to your localized string.
 */
interface Localize {
    val supportedLanguages: SupportedLanguages

    /**
     * This is where the translation is happening depending on passed localization.
     * @param args: is used to pass arguments to be added to the localized string resource.
     */
    fun localize(vararg args: Any): String {
        val builder = StringBuilder().also { stringBuilder ->
            args.forEach { arg ->
                stringBuilder.append("$arg ")
            }
        }

        // TODO: later get language from app's setting instead of device language.
        return when (currentDeviceLanguage) {
            Locales.ARABIC.value -> if (builder.isEmpty()) supportedLanguages.ar
            else "${supportedLanguages.ar} $builder"

            Locales.ENGLISH.value -> if (builder.isEmpty()) supportedLanguages.en
            else "${supportedLanguages.en} $builder"

            else -> if (builder.isEmpty()) supportedLanguages.en
            else "${supportedLanguages.en} $builder"
        }
    }
}