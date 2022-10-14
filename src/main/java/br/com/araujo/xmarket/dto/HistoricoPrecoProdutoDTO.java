package br.com.araujo.xmarket.dto;


import br.com.araujo.xmarket.model.Produto;

import java.time.LocalDateTime;

public class HistoricoPrecoProdutoDTO implements IHistoricoPrecoProdutoDTO {

    private Integer id_historico_preco;
    private Double preco_antigo;
    private Double preco_novo;
    private LocalDateTime data_alteracao;

    private Integer Produto_id_produto;
    private String produto;


    @Override
    public Integer getId_historico_preco() {
        return id_historico_preco;
    }

    public void setId_historico_preco(Integer id_historico_preco) {
        this.id_historico_preco = id_historico_preco;
    }

    @Override
    public Double getPreco_antigo() {
        return preco_antigo;
    }

    public void setPreco_antigo(Double preco_antigo) {
        this.preco_antigo = preco_antigo;
    }

    @Override
    public Double getPreco_novo() {
        return preco_novo;
    }

    public void setPreco_novo(Double preco_novo) {
        this.preco_novo = preco_novo;
    }

    @Override
    public LocalDateTime getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(LocalDateTime data_alteracao) {
        this.data_alteracao = data_alteracao;
    }

    @Override
    public String getProduto() {
        return produto;
    }

    @Override
    public Integer getProduto_id_produto() {
        return Produto_id_produto;
    }

    public void setProduto_id_produto(Integer produto_id_produto) {
        Produto_id_produto = produto_id_produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
