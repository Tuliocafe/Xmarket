package br.com.araujo.xmarket.dto;


import br.com.araujo.xmarket.model.Produto;

import java.time.LocalDateTime;

public interface IHistoricoPrecoProdutoDTO {

    public Integer getId_historico_preco();
    public Double getPreco_antigo();
    public Double getPreco_novo();
    public LocalDateTime getData_alteracao();
    public String getProduto();

    public Integer getProduto_id_produto();


}
