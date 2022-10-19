package br.com.araujo.xmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "carrinho_de_compras")

public class CarrinhoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrinho_de_compras", nullable = false)
    private Integer id;

    @Column(name="quantidade_produto_carrinho", nullable = false)
    private Integer quantidade;

    @Column(name = "desconto_carrinho", nullable = true)
    private Double desconto;

    @Column(name = "preco_unitario_carrinho", nullable = true)
    private Double precoUnitario;

    @Column(name = "preco_total_carrinho", nullable = true)
    private Double precoTotal;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    @JsonIgnoreProperties("listaItensCarrinho")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public CarrinhoCompra() {
    }

    public CarrinhoCompra(Integer quantidade, Double desconto, Double precoUnitario, Double precoTotal, Venda venda, Produto produto) {
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.precoUnitario = precoUnitario;
        this.precoTotal = precoTotal;
        this.venda = venda;
        this.produto = produto;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
