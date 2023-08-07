package me.inassar.features.feature.presentation.data

import me.inassar.common.locale.Localize
import me.inassar.common.locale.SupportedLanguages

/**
 * Created by Ahmed Nassar on 8/5/23.
 */
enum class FeatureStrings(override val supportedLanguages: SupportedLanguages) : Localize {
    PRODUCT_LIST_SCREEN_TITLE(SupportedLanguages(en = "Product List", ar = "قائمة المنتجات")),
}