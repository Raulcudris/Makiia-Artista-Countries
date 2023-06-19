package com.makiia.crosscutting.domain.model;
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
public class EntySispaisamaestroDto {
    private Integer  recUnikeySipa;
    private String   sisCodpaiSipa;
    private String   sisAbreviSipa;
    private String   sisNombreSipa;
    private String   sisIndicaSipa;
    private String   sisNombrelSipa;
    private String   sisCodconSico;
    private String   sisTimezoSipa;
    private Integer  sisEaradiSipa;
    private Integer  sisSecdetSipa;
    private Integer  sisEstregSipa;
}
