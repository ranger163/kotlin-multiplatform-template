package me.inassar.common.config

/**
 * Created by Ahmed Nassar on 8/2/23.
 * Used to get translated string resources when required.
 * It currently has AR and EN languages but you ca always add more languages as you need. But don't
 * forget to update Local.kt enum class with your needed languages.
 * Also you can pass args to append it to your localized string.
 */
interface Localize {
    val en: String
    val ar: String

    /**
     * This is where the translation is happening depending on passed localization.
     * @param locale: is used to pass current localized language.
     * @param args: is used to pass arguments to be added to the localized string resource.
     */
    fun localize(locale: Locales, vararg args: Any): String {
        val builder = StringBuilder().also { stringBuilder ->
            args.forEach { arg ->
                stringBuilder.append("$arg ")
            }
        }

        return when (Locales.valueOf(locale.name)) {
            Locales.ARABIC -> if (builder.isEmpty()) ar else "$ar $builder"
            Locales.ENGLISH -> if (builder.isEmpty()) en else "$en $builder"
            Locales.DEFAULT -> if (builder.isEmpty()) en else "$en $builder"
        }
    }
}