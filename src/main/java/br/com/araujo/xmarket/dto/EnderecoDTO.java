package br.com.araujo.xmarket.dto;


public class EnderecoDTO {

    private String logradouro;
    private String cep;
    private String bairro;
    private String complemento;
    private String referencia;
    private String tipo;
    private String cidade;
    private String estado;

    public EnderecoDTO() {
    }

    public EnderecoDTO(String logradouro, String cep, String bairro, String complemento, String referencia, String tipo, String cidade, String estado) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.complemento = complemento;
        this.referencia = referencia;
        this.tipo = tipo;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
