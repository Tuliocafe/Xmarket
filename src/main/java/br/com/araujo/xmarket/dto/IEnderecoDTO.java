package br.com.araujo.xmarket.dto;

import br.com.araujo.xmarket.model.Cidade;

public interface IEnderecoDTO {

    public String getId();
    public String getLogradouro();
    public String getCep();
    public String getBairro();
    public String getComplemento();
    public String getReferencia();
    public String getTipo();
    public String getCidade();
    public String getEstado();

}
