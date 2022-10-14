package br.com.araujo.xmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario_login")
public class ClienteLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_login")
    private Integer id;

    @Column(name = "senha_login")
    private String senha;

    @Column(name = "tipo_usuario_login")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Column(name = "status_usuario_login", columnDefinition = "TINYINT")
    private boolean status;

    @Column(name = "dataLogin")
    private String DataLogin;

    @Column(name = "email_usuario")
    private String email;

    @OneToOne(mappedBy = "clienteLogin")
    @JsonIgnoreProperties("clienteLogin")
    private Cliente cliente;

    public ClienteLogin() {
    }

    public ClienteLogin(Integer id, String senha, TipoUsuario tipoUsuario, boolean status, String dataLogin, String email, Cliente cliente) {
        this.id = id;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.status = status;
        DataLogin = dataLogin;
        this.email = email;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDataLogin() {
        return DataLogin;
    }

    public void setDataLogin(String dataLogin) {
        DataLogin = dataLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
