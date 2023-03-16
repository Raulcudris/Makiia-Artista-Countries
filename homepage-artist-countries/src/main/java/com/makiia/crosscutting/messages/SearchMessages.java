package com.makiia.crosscutting.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchMessages {

    /**
     * Mensajes al crear registro
     */
    public static final String CREATE_ERROR_ID = "CD001";
    public static final String CREATE_ERROR_DESCRIPTION = "Error al crear nuevo registro";

    /**
     * Mensajes al crear registro
     */
    public static final String UPDATE_ERROR_ID = "CD002";
    public static final String UPDATE_ERROR_DESCRIPTION = "Error al actualizar el registro";

    /**
     * Mensajes al crear registro
     */
    public static final String DELETE_ERROR_ID = "CD003";
    public static final String DELETE_ERROR_DESCRIPTION = "Error al eliminar el registro";

    /**
     * Mensajes de busqueda
     */
    public static final String SEARCH_ERROR_ID = "CD004";
    public static final String SEARCH_ERROR_DESCRIPTION = "Error buscando el registro";
    public static final String SEARCH_NO_FOUND_ID = "CD005";
    public static final String SEARCH_NO_FOUND_DESCRIPTION = "El registro no fue encontrado";

    /**
     * Mensajes Generar indice
     */
    public static final String GETINDEX_ERROR_ID = "CD006";
    public static final String GETINDEX_ERROR_DESCRIPTION = "Error al generar nuevo indice";

}
