package br.com.araujo.xmarket.model;

import javax.persistence.*;

@Entity
@Table(name = "Endereco")
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
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

//    id_cidade	int
//    id_usuario	int


}
