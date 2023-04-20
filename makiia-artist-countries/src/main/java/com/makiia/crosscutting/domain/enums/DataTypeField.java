package com.makiia.crosscutting.domain.enums;

import lombok.Getter;

@Getter
public enum DataTypeField {
    ALPHANUMERIC("AlfaNumerico", "[a-zA-Z0-9]+"),
    ALPHABETICAL("Alfabetico", "^[a-zA-Z]*$"),
    NUMERIC("Numerico", "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?"),
    FREETEXT("TextoLibre", "^[^'\"\\n\\t]*$"),
    DATE("Fecha", "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$"),
    LIST("List", "list"),
    OBJECT("Object", "object");
    private final String regexPattern;
    private final String type;

    DataTypeField(final String type, final String regexPattern) {
        this.type = type;
        this.regexPattern = regexPattern;
    }
}
