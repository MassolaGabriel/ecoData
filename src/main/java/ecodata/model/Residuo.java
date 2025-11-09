package ecodata.model;

import ecodata.model.enums.StatusResiduo;
import ecodata.model.enums.UnidadeMedida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "residuos")
public class Residuo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoResiduo;
    private Double pesoOuVolume;

    @Enumerated(EnumType.ORDINAL)
    private UnidadeMedida unidadeMedida;

    private LocalDateTime dataRegistro;

    @Enumerated(EnumType.ORDINAL)
    private StatusResiduo statusResiduo;

    private String localizacao;

    @ManyToOne
    @JoinColumn(name = "gerador_id", referencedColumnName = "id")
    private Gerador gerador;
}
