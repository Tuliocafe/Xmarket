//package br.com.araujo.xmarket.model;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//public class HistoricoPrecoProduto {
//
//    @Id
//    @Column
//    private Integer id_historico_preco;
//
//    @Column
//    private Double preco_antigo;
//    @Column
//    private Double preco_novo;
//    //@Temporal(TemporalType.TIMESTAMP)
//    @Column
//    private LocalDateTime data_alteracao;
//    @ManyToOne
//    @JoinColumn (name = "id_produto")
//    private Produto produto;
//
//
//    public Integer getId_historico_preco() {
//        return id_historico_preco;
//    }
//
//    public void setId_historico_preco(Integer id_historico_preco) {
//        this.id_historico_preco = id_historico_preco;
//    }
//
//    public LocalDateTime getData_alteracao() {
//        return data_alteracao;
//    }
//
//    public void setData_alteracao(LocalDateTime data_alteracao) {
//        this.data_alteracao = data_alteracao;
//    }
//
//    public Double getPreco_antigo() {
//        return preco_antigo;
//    }
//
//    public void setPreco_antigo(Double preco_antigo) {
//        this.preco_antigo = preco_antigo;
//    }
//
//    public Double getPreco_novo() {
//        return preco_novo;
//    }
//
//    public void setPreco_novo(Double preco_novo) {
//        this.preco_novo = preco_novo;
//    }
//
//    public Produto getProduto() {
//        return produto;
//    }
//
//    public void setProduto(Produto produto) {
//        this.produto = produto;
//    }
//}
