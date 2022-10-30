package br.com.araujo.xmarket.dto;

import br.com.araujo.xmarket.model.TipoUsuario;

public interface IClienteDTO {

    public Integer getId();
    public String getNome();
    public String getSobrenome();
    public String getCpf();
    public String getRg();
    public String getDataNascimento();
    public String getTelefoneUm();
    public String getTelefoneDois();
    public String getDataCriacaoUsuario();
    public String getSenha();
    public String getEmail();
    public String getTipoUsuario();
    public Integer getStatus();

}
