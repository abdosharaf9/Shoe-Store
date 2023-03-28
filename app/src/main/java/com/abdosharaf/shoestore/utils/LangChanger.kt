package com.abdosharaf.shoestore.utils

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

object LangChanger {

    private val arabicAppLocale: LocaleListCompat = LocaleListCompat.forLanguageTags("ar-EG")

    private val englishAppLocale: LocaleListCompat = LocaleListCompat.forLanguageTags("en-UK")

    fun changeLang() {
        if (AppCompatDelegate.getApplicationLocales() == arabicAppLocale)
            changeLang(englishAppLocale)
        else
            changeLang(arabicAppLocale)
    }

    fun createLocale(lang: String): LocaleListCompat {
        return LocaleListCompat.forLanguageTags(lang)
    }

    fun changeLang(locale: LocaleListCompat) {
        AppCompatDelegate.setApplicationLocales(locale)
    }
}