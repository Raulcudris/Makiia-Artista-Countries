package com.makiia.crosscutting.domain.enums;

public enum ProcessName {
    START("START", "Inicio procesamiento CTS"),
    RECEPTION("RECEPTION", "Recibido por CT&S"),
    GENERATED_CTS("GENERATED_CTS", "Generado por CT&S"),
    TRANSFORMATION("TRANSFORMATION", "Transformación"),
    SIGN("SIGN", "Firma"),
    RESPONSE_FILE("RESPONSE_FILE", "Creacion archivo response file datos basicos"),
    DIAN_RESULT("DIAN_RESULT", "Creacion archivo dian result"),
    DIAN_RESULT_PROCESS("DIAN_RESULT_PROCESS", "Se esta generando el Dian Result"),
    DIAN_RESULT_OK("DIAN_RESULT_OK", "El Dian Result se genero  satisfactoriamente"),
    DIAN_RESULT_ERROR("DIAN_RESULT_ERROR", " Ocurrió un error al generar el Dian Result"),

    SUCCESS_MESSAGE_VALIDATION(
            "SUCCESS_MESSAGE_VALIDATION", "El archivo cumple las validaciones evento."),

    ERROR_IS_NOT_ACTIVE("ERROR_IS_NOT_ACTIVE_EVENT", "El evento no se encuentra activo."),

    ERROR_IS_NOT_CODE("ERROR_IS_NOT_CODE", "El codigo no concide, con los registrados."),

    ERROR_IS_NOT_DESCRIPTION(
            "ERROR_IS_NOT_DESCRIPTION", "El nombre corto no concide con los registrados."),

    EMPTY_CODE_EVENT("EMPTY_CODE_EVENT", "El codigo viene vacio en el documento"),

    EMPTY_DESCRIPTION("EMPTY_DESCRIPTION", "El nombre corto viene vacio"),

    SEND_TO_CFDI("SEND_TO_CFDI", "Envío a servicio CFDI"),
    HASH_CREATION("HASH_CREATION", "Creación de Hash"),
    BARCODE_CREATION("BARCODE_CREATION", "Creación de Barcode"),
    QR_CREATION("QR_CREATION", "Creación de QR"),
    XML_DIAN(
            "CUDE_CREATION",
            "Se está calculando y generando los datos que se requieren para completar el XML DIAN"),
    CUDE_CREATION("CUDE_CREATION", "Creación de CUDE Y QR"),
    NOT_CUDE_CREATION("NOT_CUDE_CREATION", "Error creación de CUDE Y QR"),
    PDF_CREATION("PDF_CREATION", "Creación de Pdf"),
    PDF_INPUT_CREATION("PDF_INPUT_CREATION", "Creación de Insumo PDF"),
    SEND_GOVERNMENT("SEND_GOVERNMENT", "Envío entidad gubernamental"),
    RESPONSE_GOVERNMENT("RESPONSE_GOVERNMENT", "Respuesta entidad gubernamental"),
    RESPONSE_CFDI("RESPONSE_CFDI", "Respuesta servicio CFDI"),
    PUBLISH("PUBLISH", "Publicado al Receptor"),
    SEND_TO_RECEIVER("SEND_TO_RECEIVER", "Entrega al Canal Automático del Receptor"),
    SEND_TO_SENDER("SEND_TO_SENDER", "Envío al emisor"),
    SEND_TO_FACTORING("SEND_TO_FACTORING", "Envío a la entidad Factoring"),
    SEND_NOTIFICATION("SEND_NOTIFICATION", "Envío por Correo al Receptor"),

    RENAME_FILE("RENAME_FILE", "Renombramiento de archivo"),
    ACCEPTANCE_REJECTION("ACCEPTANCE_REJECTION", "Aceptación y Rechazo"),
    QR_CODE_STRING_CREATION("QR_CODE_STRING_CREATION", "Creación de Cadena Código QR"),
    APPLICATION_RESPONSE("APPLICATION_RESPONSE", "Acuse de Recibo"),

    CLIENT_ERROR("CLIENT_ERROR", "Error al cliente"),
    FACTORING("FACTORING", "Factoring"),
    FACTORING_START("FACTORING_START", "Inicio de Factoring"),
    FACTORING_FINISH("FACTORING_FINISH", "Fin de Factoring"),
    FACTORING_BUSINESS_RELATIONSHIPS(
            "FACTORING_BUSINESS_RELATIONSHIPS", "Factoring Relaciones Comerciales"),
    FACTORING_LOAD_INVOICES("FACTORING_LOAD_INVOICES", "Factoring Carga de Facturas"),
    FACTORING_LOAD_INVOICES_START("FACTORING_LOAD_INVOICES", "Factoring Inicio de Carga de Facturas"),
    FACTORING_LOAD_INVOICES_FINISH(
            "FACTORING_LOAD_INVOICES_FINISH", "Factoring Fin de Carga de Facturas"),
    FACTORING_LOAD_INVOICES_RESPONSE(
            "FACTORING_LOAD_INVOICES_RESPONSE", "Factoring Respuesta de Carga de Facturas"),
    FACTORING_TRACING("FACTORING_TRACING", "Factoring Seguimiento de Estados"),
    DOCUMENT_PROCESSED("DOCUMENT_PROCESSED", "Documento Procesado"),
    ACCEPTANCE_REJECTION_REPORT("ACCEPTANCE_REJECTION_REPORT", "Reporte de Aceptación y Rechazo"),
    APPLICATION_RESPONSE_REPORT("APPLICATION_RESPONSE_REPORT", "Reporte de Acuse de Recibo"),
    PAYMENT("PAYMENT", "Pagos Bancolombia"),
    PROCESS_FINISHED("PROCESS_FINISHED", "Finalizado"),
    PROCESS_FINISHED_MAIL("PROCESS_FINISHED_MAIL", "Finalizado descarga correo"),
    PACKING_FILES("PACKING_FILES", "Archivo"),
    EMAIL_RECEIVED("EMAIL_RECEIVED", "Email Recibido"),
    INTEROPERABILITY_START("INTEROPERABILITY_START", "Inicio de Interoperabilidad"),
    INTEROPERABILITY_FINISH("INTEROPERABILITY_FINISH", "Fin de Interoperabilidad"),
    INTEROPERABILITY_STATUS("INTEROPERABILITY_STATUS", "Consulta de estado de interoperabilidad"),
    INTEROPERABILITY_GET_APP_RESPONSE(
            "INTEROPERABILITY_GET_APP_RESPONSE", "Obtener ApplicationResponse de interoperabilidad"),
    CHECK_DELIVERY("CHECK_DELIVERY", "Condiciones de Entrega"),
    CHECK_DELIVERY_PROCESSING("CHECK_DELIVERY_PROCESSING", "Condicion de Entrega"),
    ISSUANCE_CHECK_DELIVERY("ISSUANCE_CHECK_DELIVERY", "Condicion Entrega"),
    ISSUANCE_CHECK_DELIVERY_PROCESSING(
            "ISSUANCE_CHECK_DELIVERY_PROCESSING", "Condiciones de Entrega"),
    COMMERCIAL_VALIDATIONS("COMMERCIAL_VALIDATIONS", "Validaciones Comerciales"),
    SEND_TO_SIGN("SEND_TO_SIGN", "Envio a firma"),
    SEMIAUTOMATIC("SEMIAUTOMATIC", "proceso semiautomatico"),
    SEND_TO_OUTBOX("SEND_TO_OUTBOX", "Envio a outbox desde semiautomatico"),
    TRANSFORMATION_OUTPUT_SENDER(
            "TRANSFORMATION_OUTPUT_SENDER", "Transformación a la salida para el emisor"),
    TRANSFORMATION_OUTPUT_RECEIVER(
            "TRANSFORMATION_OUTPUT_RECEIVER", "Transformación a la salida para el receptor"),
    RECEIVER_PDF("RECEIVER_PDF", "Recepción de PDF"),
    DELIVERED_PDF("DELIVERED_PDF", "Entrega de PDF"),
    REQUEST_NOTES("REQUEST_NOTES", "Solicitud Notas Credito"),
    PHYSICAL_DOCUMENT("PHYSICAL_DOCUMENT", "Carga de documentos fisicos"),
    ADVANCED_REFERENCES_START_PROCESS(
            "ADVANCED_REFERENCES_START_PROCESS", "Inicio de procesamiento de referencias avanzadas"),
    ADVANCED_REFERENCES_VALIDATE_ESTRUCTURE_FILE(
            "ADVANCED_REFERENCES_VALIDATE_ESTRUCTURE_FILE",
            "Validacion de estructura de referencias avanzadas"),
    ADVANCED_REFERENCES_SAVE_ESTRUCTURE_ERRORS_FILE(
            "ADVANCED_REFERENCES_SAVE_ESTRUCTURE_ERRORS_FILE",
            "Almacenamiento  de errores de estructura de referencias avanzadas"),
    ADVANCED_REFERENCES_LOAD_DATA_FILE(
            "ADVANCED_REFERENCES_LOAD_DATA_FILE",
            "Almacenamiento de registros de referencias avanzadas en base de datos"),
    ADVANCED_REFERENCES_CREATE_ERROR_FILE(
            "ADVANCED_REFERENCES_CREATE_ERROR_FILE",
            "Creacion de archivo de error de referencias avanzadas"),
    ADVANCED_REFERENCES_UPLOAD_ERROR_FILE(
            "ADVANCED_REFERENCES_UPLOAD_ERROR_FILE",
            "Guardado de archivo de error de referencias avanzadas en almacen de documentos"),
    ADVANCED_REFERENCES_SEND_FILE_TO_DELIVERY(
            "ADVANCED_REFERENCES_SEND_FILE_TO_DELIVERY",
            "Envío de mensaje dereferencias avanzadas al Delivery para entrega."),
    ADVANCED_REFERENCES_FILENAME_VALIDATION(
            "ADVANCED_REFERENCES_FILENAME_VALIDATION",
            "Validación de Nombre de Archivo de referencias avanzadas"),
    ADVANCED_REFERENCE_FINISH(
            "ADVANCED_REFERENCE_FINISH", "Fin de procesamiento de referencias avanzadas"),
    BUSINESS_VALIDATION("BUSINESS_VALIDATION", "Validaciones de Negocio CT&S"),
    REQUEST_STATE_GOVERNMENT(
            "REQUEST_STATE_GOVERNMENT", "Solicitar estado en la entidad gubernamental"),
    RESPONSE_STATE_GOVERNMENT("RESPONSE_STATE_GOVERNMENT", "Respuesta Estado Entidad Reguladora"),
    PACKAGES("PACKAGES", "Descomprimiendo  paquete documentos"),
    PACKAGES_COMPLETED("PACKAGES_COMPLETED", "Completo  paquete de documentos"),
    STOP_BEFORE_SIGN("STOP_BEFORE_SIGN", "Retenido antes de firmar"),
    PACKAGE_DOWNLOADED("PACKAGE_DOWNLOADED", "Descargando archivo"),
    CONNECTION_SFTP("CONNECTION_SFTP", "Conectando al servidor sftp"),
    SEND_FILE_SFTP("SEND_FILE_SFTP", "Enviando archivo al servidor sftp"),
    GRAPHIC_REPRESENTATION("GRAPHIC_REPRESENTATION", "Representación Gráfica"),
    PACKAGE_STOPPED("PACKAGE_STOPPED", "Retenido por el emisor"),
    PACKAGE_CANCELLED(
            "PACKAGE_CANCELLED",
            "Se canceló el procesamiento del documento, según lo enviado por el emisor"),
    PACKAGE_ACCEPTED("PACKAGE_ACCEPTED", "Aprobado por el emisor."),
    PACKAGES_RECEIVER("PACKAGES_RECEIVER", "Enviado por el emisor externo."),
    SIZE_EXTENSION("SIZE_EXTENSION", "Validación de peso y extensión de xml"),
    NOT_SIZE_EXTENSION("NOT_SIZE_EXTENSION", "No cumple validación de peso y extensión de xml"),

    SCHEMA("SCHEMA", "Validación de estructura al validarlo contra esquema"),
    NOT_SCHEMA("NOT_SCHEMA", "Error de estructura al validarlo contra esquema"),

    XML_TO_DOMAIN("XML_TO_DOMAIN", "Transformación de XML a DOMAIN"),
    DATA_TO_XML("DATA_TO_XML", "Se está transformando el archivo de entrada a un XML DIAN"),
    DATA_TO_XML_OK("DATA_TO_XML_OK", "El documento se transformo satisfactoriamente"),
    DATA_TO_XML_ERROR("DATA_TO_XML_ERROR", "Ocurrió un error al transformar el documento"),
    EVENT_NOT_EXIST("EVENT_NOT_EXIST", "Evento no existe en Radian"),
    JSON_TO_DOMAIN("JSON_TO_DOMAIN", "Transformación de JSON a DOMAIN"),
    NOT_XML_TO_DOMAIN("NOT_XML_TO_DOMAIN", "Transformación XML a DOMAIN"),
    DELIVERY_NEXT_COMPONENT("DELIVERY_NEXT_COMPONENT", "Entrega el mensaje al siguiente componente"),
    DELIVERY_DIAN_RESULT("DELIVERY_DIAN_RESULT", "DIAN result Generado"),

    DOMAIN_TO_XML("DOMAIN_TO_XML", "Transformación de XML to DOMAIN"),
    NOT_DOMAIN_TO_XML("NOT_DOMAIN_TO_XML", "Transformación XML a DOMAIN"),

    INTERNAL("INTERNAL", "INTERNAL"),
    EXTERNAL("EXTERNAL", "EXTERNAL"),

    ATTACHMENT_DOCUMENT("ATTACHMENT_DOCUMENT", "Attachment Document generado."),
    ATTACHMENT_DOCUMENT_SIGNED("ATTACHMENT_DOCUMENT_SIGNED", "Attachment Document firmado."),
    RENAME_DOCUMENT("RENAME_DOCUMENT", "se esta renombrando XML DIAN."),
    RENAME_DOCUMENT_OK("RENAME_DOCUMENT_OK", "se termino exitosamente renombrado XML DIAN."),
    RENAME_DOCUMENT_FAIL("RENAME_DOCUMENT_FAIL", "fallo renombrado XML DIAN."),
    LEGAL_CREATION_OK("LEGAL_CREATION", "El documento se  completo satisfactoriamente"),
    LEGAL_CREATION_ERROR("LEGAL_CREATION", "Ocurrió un error al completar el XML DIAN"),
    DIAN_RESULT_READER("DIAN_RESULT", "Leyendo Dian Response para la Creacion archivo dian result"),
    DIAN_RESULT_WRITER(
            "DIAN_RESULT", "Construyendo archivo dian result desde Dian Response y ApplicationResponse "),
    MANDATO_WRITER("MANDATO_WRITER", "Construyendo archivo Mandato"),

    XML_READER("XML_READER", "Error transformando Dian Response"),
    CHANNEL_CONFIGURATION_ACTIVE(
            "CHANNEL_CONFIGURATION_ACTIVE", "La empresa no tiene la configuracion del canal activa"),
    CHANNELCONFIGURATION_VALIDATION(
            "CHANNELCONFIGURATION_VALIDATION", "La empresa no tiene configurado ningun canal"),
    SERVICE_RADIAN(
            "SERVICE_RADIAN", "La empresa no tiene configurado el servicio Radian o no esta activo"),
    COMPANY_VALIDATION("COMPANY_VALIDATION", "La empresa no se encuentra activa"),
    CERTIFICATE_VALIDATION("CERTIFICATE_VALIDATION", "Error obteniendo certificado"),
    VALIDATIONS_CLIENT("VALIDATION_CLIENT", "El archivo cumple las validaciones básicas."),
    VALIDATIONS_DOCUMENT("VALIDATION_DOCUMENT", "El archivo cumple las validaciones básicas."),
    VALIDATIONS_NOTIFICATION("NOTIFICATION_MAIL", "Se envio exitosamente notificaciones a: "),
    NOTIFICATION_ERROR("NOTIFICATION_MAIL_ERROR", "Ocurrio un error al enviar notificacion");
    private final String name;
    private final String description;

    ProcessName(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static ProcessName getByName(String name) {
        try {
            return ProcessName.valueOf(name);
        } catch (Exception ex) {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
