package com.makiia.crosscutting.utils;

import com.makiia.crosscutting.domain.constants.Constants;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

@Log4j2
@UtilityClass
public class DateUtility {
    public static Date getActualDateTime() {
        try {
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat(Constants.US_DATE_TIME_FORMAT_SSS, Locale.US);

            return dateTimeFormat.parse(dateTimeFormat.format(new Date()));
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return new Date();
    }

    public static String completeWithHours(String date, String hours) {
        return date.length() < 11 ? date.concat(hours) : date;
    }

    public static Date parseUsDateTime(String date) {
        return parseUsDateTime(date, null);
    }

    public static Date parseUsDateTime(String date, String format) {
        if (Objects.nonNull(format) && !format.isEmpty()) {
            try {
                return new SimpleDateFormat(format, Locale.US).parse(date);
            } catch (Exception e) {
                log.debug(e.getMessage());
            }
        } else {
            try {
                return new SimpleDateFormat(Constants.US_DATE_TIME_FORMAT_SSS, Locale.US).parse(date);
            } catch (Exception e) {
                log.debug(e.getMessage());
            }

            try {
                return new SimpleDateFormat(Constants.US_DATE_TIME_FORMAT, Locale.US).parse(date);
            } catch (Exception e) {
                log.debug(e.getMessage());
            }

            try {
                return new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT_US, Locale.US).parse(date);
            } catch (Exception e) {
                log.debug(e.getMessage());
            }
        }

        return new Date();
    }

}
