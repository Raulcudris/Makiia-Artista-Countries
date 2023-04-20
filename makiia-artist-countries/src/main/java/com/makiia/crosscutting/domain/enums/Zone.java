package com.makiia.crosscutting.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Zone {

    CO("America/Bogota"),
    MX("America/Mexico_City");

    private final String zoneId;

    public static Zone getByCountry(String country) {
        try {
            return Zone.valueOf(country);
        } catch (Exception ex) {
            return null;
        }
    }
}