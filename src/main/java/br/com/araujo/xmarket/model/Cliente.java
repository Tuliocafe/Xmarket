package br.com.araujo.xmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public Cliente() {
    }

    public void cloneCliente(Cliente cliente) {
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefoneUm = cliente.getTelefoneUm();
        this.telefoneDois = cliente.getTelefoneDois();
        this.rg = cliente.getRg();
        this.dataCriacaoUsuario = cliente.getDataCriacaoUsuario();
        this.listaEnderecos = cliente.getListaEnderecos();
        this.senha = cliente.getSenha();
        this.tipoUsuario = cliente.getTipoUsuario();
        this.status = cliente.getStatus();
        this.email = cliente.getEmail();

    }


    public List<Endereco> getListaEnderecos() {
        return listaEnderecos;
    }

    public void setListaEnderecos(List<Endereco> listaEnderecos) {
        this.listaEnderecos = listaEnderecos;
    }

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



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return status == cliente.status && Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(sobrenome, cliente.sobrenome) && Objects.equals(cpf, cliente.cpf) && Objects.equals(dataNascimento, cliente.dataNascimento) && Objects.equals(telefoneUm, cliente.telefoneUm) && Objects.equals(telefoneDois, cliente.telefoneDois) && Objects.equals(rg, cliente.rg) && Objects.equals(dataCriacaoUsuario, cliente.dataCriacaoUsuario) && Objects.equals(senha, cliente.senha) && Objects.equals(email, cliente.email) && tipoUsuario == cliente.tipoUsuario && Objects.equals(listaEnderecos, cliente.listaEnderecos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, cpf, dataNascimento, telefoneUm, telefoneDois, rg, dataCriacaoUsuario, senha, email, tipoUsuario, status, listaEnderecos);
    }
}
