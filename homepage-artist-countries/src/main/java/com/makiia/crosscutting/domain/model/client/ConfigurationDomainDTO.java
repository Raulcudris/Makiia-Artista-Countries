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

public class ConfigurationDomainDTO {
    private String id;
    private String code;
    private String description;
    private String active;
    private String codeParent;

}
