package br.com.araujo.xmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "usuario_cadastro")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nome_usuario")
    private String nome;

    @Column(name = "sobrenome_usuario")
    private String sobrenome;

    @Column(name = "CPF_usuario")
    private String cpf;

    @Column(name = "dataNascimento_usuario")
    private String dataNascimento;

    @Column(name = "telefone_usuario")
    private String telefoneUm;

    @Column(name = "telefoneDois_usuario")
    private String telefoneDois;

    @Column(name = "rg_usuario")
    private String rg;

    @Column(name = "dataCriacao_usuario", nullable = true)
    private String dataCriacaoUsuario;

    //colunas que vieram de de usuario_login:

    @Column(name = "senha")
    private String senha;

    @Column(name = "email")
    private String email;

    @Column(name = "tipo_usuario")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Column(name = "status", columnDefinition = "TINYINT")
    private Integer status;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("cliente")
    List<Endereco> listaEnderecos;

}
