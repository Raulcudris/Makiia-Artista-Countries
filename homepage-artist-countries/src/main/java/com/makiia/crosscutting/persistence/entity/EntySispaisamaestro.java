package com.makiia.crosscutting.persistence.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sispaisamaestro")
public class EntySispaisamaestro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sis_codpai_sipa")
    private String  sisCodpaiSipa;

    @Basic(optional = false)
    @Column(name = "sis_abrevi_sipa")
    private String sisAbreviSipa;

    @Basic(optional = false)
    @Column(name = "sis_nombre_sipa")
    private String sisNombreSipa;

    @Basic(optional = false)
    @Column(name = "sis_indica_sipa")
    private String sisIndicaSipa;

    @Basic(optional = false)
    @Column(name = "sis_nombrl_sipa")
    private String sisNombrelSipa;

    @Basic(optional = false)
    @Column(name = "sis_codcon_sico")
    private String  sisCodconSico;

    @Basic(optional = false)
    @Column(name = "sis_timezo_sipa")
    private String  sisTimezoSipa;

    @Basic(optional = false)
    @Column(name = "sis_earadi_sipa")
    private Integer  sisEaradiSipa;

    @Basic(optional = false)
    @Column(name = "sis_secdet_sipa")
    private Integer  sisSecdetSipa;

    @Basic(optional = false)
    @Column(name = "sis_estreg_sipa")
    private Integer  sisEstregSipa;

}
