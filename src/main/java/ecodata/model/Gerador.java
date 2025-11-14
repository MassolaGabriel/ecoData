package ecodata.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "geradores")
public class Gerador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "cnpj_cpf")
    private String cnpjOuCpf;

    private String endereco;

    @JsonManagedReference
    @OneToMany(mappedBy = "gerador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Residuo> residuos = new ArrayList<>();
}
