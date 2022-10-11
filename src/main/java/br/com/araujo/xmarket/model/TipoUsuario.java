package br.com.araujo.xmarket.model;

public enum TipoUsuario {

    usuario("usuario"),
    administrador("administrador"),
    funcionario("funcionario");

    private final String descricao;

    private TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}