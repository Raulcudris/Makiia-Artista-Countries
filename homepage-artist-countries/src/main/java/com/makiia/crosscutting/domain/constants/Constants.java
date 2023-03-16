package com.makiia.crosscutting.domain.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final Integer ADDED_TIME_START_BLOKADE = 60;
    public static final String SIMPLE_DATE_FORMAT_UNION = "yyyyMMdd";
    public static final String SIMPLE_DATE_FORMAT = "dd-MM-yyyy";
    public static final String SIMPLE_DATE_FORMAT_US = "yyyy-MM-dd";
    public static final String SIMPLE_TIME_FORMAT = "HH:mm:ss";
    public static final String SIMPLE_DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String SIMPLE_DATE_TIME_FORMAT_T = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String ISO_DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String US_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String US_DATE_TIME_FORMAT_SSS = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final String LOCALE_LANGUAGE = "locale.language";
    public static final String LOCALE_COUNTRY = "locale.country";
    public static final String SEPARATOR = "|";
    public static final String SLASH = "/";
    public static final String BREAKLINE = "\n";
    public static final String USER_SYSTEM = "SYSTEM";
    public static final String DETAIL_CLARIFICACION = "VENCIMIENTO";

    public static final String EXECUTING_GET = "executing GET {}";
    public static final String EXECUTING_POST = "executing POST {}";
    public static final String EXECUTING_PUT = "executing POST {}";
    public static final String EXECUTING_DELETE = "executing DELETE {}";

    public static final String MESSAGE_IN = "Mensaje de entrada { }";
    public static final String MESSAGE_OUT = "Mensaje de salida { }";

    public static final String RESILIENCE4J_INSTANCE_NAME = "cron";
    public static final String RESILIENCE4J_FALLBACK_METHOD = "fallback";

    public static final String ERROR_REST = "error";
    public static final String PROCESS_REST = "process";
    public static final String START_DATE_REST = "startdate";
    public static final String END_DATE_REST = "enddate";
    public static final String START_DATE_REST_PARAM = START_DATE_REST + SLASH + "{startdate}";
    public static final String END_DATE_REST_PARAM = END_DATE_REST + SLASH + "{enddate}";

   public static final String ID_REST = "id";
   public static final String ID_PRICES_PARAM = "{id}";

    public static final String PRICES_REST = "Prices";
    public static final String PRICES_REST_PARAM = PRICES_REST + SLASH + "{id}";

}