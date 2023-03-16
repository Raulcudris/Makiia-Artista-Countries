package com.makiia.crosscutting.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class SetStatusMessages {
    /**
     * Mensajes al crear registro
     */
    public static final String CREATE_ERROR_ID = "CD000";
    public static final String CREATE_ERROR_DESCRIPTION = "Error al crear nuevo registro";

    /**
     * Mensajes de gestion
     */
    public static final String ACCEPTED_ERROR_ID = "60113";
    public static final String ACCEPTED_ERROR_DESCRIPTION = "La solicitud no se puede aceptar";
    public static final String REJECTED_ERROR_ID = "60106";
    public static final String REJECTED_ERROR_DESCRIPTION = "La solicitud no se puede rechazar";
    public static final String CLARIFICATION_ERROR_ID = "60107";
    public static final String CLARIFICATION_ERROR_DESCRIPTION = "No se puede solicitar aclaración";
    public static final String CLEAREDUP_ERROR_ID = "59983";
    public static final String CLEAREDUP_ERROR_DESCRIPTION = "No se puede registrar la aclaración";
    public static final String ACCEPTEDBYEXPIRATION_ERROR_ID = "60113";
    public static final String ACCEPEXPIRATION_ERROR_DESCRIPTION = "La solicitud no se puede aceptar por vencimiento";
    public static final String FINALIZE_ERROR_ID = "60288";
    public static final String FINALIZE_ERROR_DESCRIPTION = "La solicitud no se puede finalizar";
    public static final String RELATED_ERROR_ID = "60288";
    public static final String RELATED_ERROR_DESCRIPTION = "No se puede recibir aprobaciones con UUID, Folio y Serier";


}
