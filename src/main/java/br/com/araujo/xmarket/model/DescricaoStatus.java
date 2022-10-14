package br.com.araujo.xmarket.model;

public enum DescricaoStatus {

    cancelada ("cancelada"),
    pendente ("pendente"),
    finalizada ("finalizada");


    private final String descricao;

private DescricaoStatus(String descricao){
    this.descricao = descricao;
}

    public String getDescricao() {
        return descricao;
    }


}