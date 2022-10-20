package br.com.araujo.xmarket.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Table(name = "venda")

public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda", nullable = false)
    private Integer id;

    @Column(name = "data_venda")
    private String dataVenda;

    @Column(name = "preco_total_vendas")
    private Double precoTotal;

    @Column(name = "descricao_venda")
    private String descricao;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("venda")
    List<CarrinhoCompra> listaItensCarrinho;

    @ManyToOne
    @JoinColumn(name = "id_status_vendas")
    @JsonIgnoreProperties("listaVendas")
    private StatusVendas statusVendas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Cliente cliente;



    public Venda(Integer id, String dataVenda, Double precoTotal, String descricao, List<CarrinhoCompra> listaItensCarrinho, StatusVendas statusVendas, Cliente cliente) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.precoTotal = precoTotal;
        this.descricao = descricao;
        this.listaItensCarrinho = listaItensCarrinho;
        this.statusVendas = statusVendas;
        this.cliente = cliente;
    }

    public Venda() {
    }



    public List<CarrinhoCompra> getListaItensCarrinho() {
        return listaItensCarrinho;
    }

    public void setListaItensCarrinho(List<CarrinhoCompra> listaItensCarrinho) {
        this.listaItensCarrinho = listaItensCarrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusVendas getStatusVendas() {
        return statusVendas;
    }

    public void setStatusVendas(StatusVendas statusVendas) {
        this.statusVendas = statusVendas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



}
