package br.com.araujo.xmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.Date;

@Entity()
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

    @Column(name = "dataNascimento_usuario", columnDefinition="DATE")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "telefone_usuario")
    private String telefoneUm;

    @Column(name = "telefoneDois_usuario")
    private String telefoneDois;

    @Column(name = "rg_usuario")
    private String rg;

    @Column(name = "dataCriacao_usuario", nullable = true)
    private String dataCriacaoUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_login", referencedColumnName = "id_usuario_login")
    @JsonIgnoreProperties("cliente")
    private ClienteLogin clienteLogin;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneUm() {
        return telefoneUm;
    }

    public void setTelefoneUm(String telefoneUm) {
        this.telefoneUm = telefoneUm;
    }

    public String getTelefoneDois() {
        return telefoneDois;
    }

    public void setTelefoneDois(String telefoneDois) {
        this.telefoneDois = telefoneDois;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataCriacaoUsuario() {
        return dataCriacaoUsuario;
    }

    public void setDataCriacaoUsuario(String dataCriacaoUsuario) {
        this.dataCriacaoUsuario = dataCriacaoUsuario;
    }

    public ClienteLogin getClienteLogin() {
        return clienteLogin;
    }

    public void setClienteLogin(ClienteLogin clienteLogin) {
        this.clienteLogin = clienteLogin;
    }
}
