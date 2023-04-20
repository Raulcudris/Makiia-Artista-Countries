package com.makiia.crosscutting.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyMessages {
    public static final String TRANSACTION = "Documental";
    public static final String GET_ALL_DOCUMENT_ERROR = "Failed to fetch logs.";
    public static final String LA_COMPANIA_QUE_INTENTA_REGISTRAR_YA_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS
            = "La compania que intenta registrar ya se encuentra en la base de datos";

}
