package br.com.araujo.xmarket.model;



public enum TipoEndereco {

    RESIDENCIAL("residencial"),
    COMERCIAL("comercial");

    private final String descricao;

    private TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}