package com.makiia.crosscutting.domain.model;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EntySispaisamaestroDto {
    private String sisCodmunSimu;
    private String sisIdedptSidp;
    private String sisCodpaiSipa;
    private String sisNombreSimu;
    private Integer sisSecdetSimu;
    private String sisEstregSimu;
}
