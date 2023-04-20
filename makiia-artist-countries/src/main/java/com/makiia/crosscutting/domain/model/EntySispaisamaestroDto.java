package com.makiia.crosscutting.domain.model;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EntySispaisamaestroDto {
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
