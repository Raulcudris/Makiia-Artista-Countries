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
public class CompanyDomainDTO {
    private String id;
    private Integer identification;
    private Integer verificationDigit;
    private String name;
    private String ean;
    private String isCompanyParnert;
    private String companyParnert;
    private String creationUser;
    private String modificationUser;
    private String creationDate;
    private String modificationDate;
    private String securityVerification;
    private Integer userNumber;
    private ConfigurationDomainDTO identificationType;
    private ConfigurationDomainDTO category;
    private GeographyDomainDTO geography;
    private ConfigurationDomainDTO status;
}
