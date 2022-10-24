package br.com.araujo.xmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Builder
@Data
@Table(name = "Endereco")
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer id;

    @Column(name = "logradouro_endereco")
    private String logradouro;

    @Column(name = "CEP_endereco")
    private String cep;

    @Column(name = "bairro_endereco")
    private String bairro;

    @Column(name = "complemento_endereco")
    private String complemento;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "tipo_endereco")
    private String tipoEndereco;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties("listaEnderecos")
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

}
