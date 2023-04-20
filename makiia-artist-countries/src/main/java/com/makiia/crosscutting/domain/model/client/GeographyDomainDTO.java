package com.makiia.crosscutting.domain.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class GeographyDomainDTO {
    private String idCountry;
    private String country;
    private String address;
    private String phone;
    private String idCity;
    private String city;
    private String toAddress;

}
