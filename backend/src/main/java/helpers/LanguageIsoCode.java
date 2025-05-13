package com.lumine.lumine_translations.helpers;

enum LanguageIsoCode {
    // English Variants
    EN("en"),
    EN_US("en-US"),
    EN_GB("en-GB"),
    EN_AU("en-AU"),
    EN_CA("en-CA"),
    EN_IN("en-IN"),

    // Spanish Variants
    ES("es"),
    ES_ES("es-ES"),
    ES_MX("es-MX"),
    ES_AR("es-AR"),
    ES_CO("es-CO"),
    ES_US("es-US"),

    // French Variants
    FR("fr"),
    FR_FR("fr-FR"),
    FR_CA("fr-CA"),
    FR_BE("fr-BE"),
    FR_CH("fr-CH");

    private final String code;

    LanguageIsoCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
