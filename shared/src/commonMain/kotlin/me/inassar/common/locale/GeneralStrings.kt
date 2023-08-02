package me.inassar.common.locale

/**
 * Created by Ahmed Nassar on 8/2/23.
 * This class is used to get general translated string resources when required.
 * @sample GeneralStrings.Network.NETWORK_UNKNOWN_ERROR.localize()
 */
enum class GeneralStrings {
    ;

    enum class Network(
        override val supportedLanguages: SupportedLanguages
    ) : Localize {
        NETWORK_UNKNOWN_ERROR(
            SupportedLanguages(
                en = "Unknown error has occurred.",
                ar = "حدث خطأ غير مُتوقع"
            )
        )
    }

    enum class UI(
        override val supportedLanguages: SupportedLanguages
    ) : Localize {
        IMAGE_CONTENT_DESC_WITH_ERROR(
            SupportedLanguages(
                en = "Default image placeholder with error",
                ar = "صوره إفتراضية تظهر خطأ"
            )
        )
    }
}