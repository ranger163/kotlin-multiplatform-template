package me.inassar.common.config

/**
 * Created by Ahmed Nassar on 8/2/23.
 * This class is used to get general translated string resources when required.
 * @sample GeneralStrings.Network.NETWORK_UNKNOWN_ERROR.localize(local = Local.ARABIC)
 */
enum class GeneralStrings {
    ;

    enum class Network(
        override val en: String,
        override val ar: String,
    ) : Localize {
        NETWORK_UNKNOWN_ERROR(
            en = "Unknown error has occurred.",
            ar = "حدث خطأ غير مُتوقع",
        )
    }

    enum class UI(
        override val en: String,
        override val ar: String,
    ) : Localize {
        IMAGE_CONTENT_DESC_WITH_ERROR(
            en = "Default image placeholder with error",
            ar = "صوره إفتراضية تظهر خطأ"
        )
    }
}