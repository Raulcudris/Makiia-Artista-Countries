package com.makiia.crosscutting.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class DocumentalMessages {
    
    public static final String TRANSACTION = "Documental";
    public static final String GET_ALL_DOCUMENT_ERROR = "Failed to fetch logs.";
    public static final String NOT_CONTENT = "No record found";
    public static final String ERROR_INSERT_DB = "The id #id# that was tried to save in the documentId is not "
            + "available in the document table";
    public static final CharSequence ID_REPLACE = "#id#";

}
