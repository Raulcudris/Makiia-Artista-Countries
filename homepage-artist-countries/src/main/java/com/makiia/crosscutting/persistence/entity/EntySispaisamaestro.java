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
    @Column(name = "sis_codmun_simu")
    private String sisCodmunSimu;

    @Basic(optional = false)
    @Column(name = "sis_idedpt_sidp")
    private String sisIdedptSidp;

    @Basic(optional = false)
    @Column(name = "sis_codpai_Sipa")
    private String  sisCodpaiSipa;

    @Basic(optional = false)
    @Column(name = "sis_nombre_simu")
    private String  sisNombreSimu;

    @Basic(optional = false)
    @Column(name = "sis_secdet_simu")
    private int  sisSecdetSimu;

    @Basic(optional = false)
    @Column(name = "sis_estreg_simu")
    private String sisEstregSimu;
}
