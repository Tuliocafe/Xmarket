package br.com.araujo.xmarket.model;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id_produto;
    @Column (name = "quantidade_produto")
    private Integer quantidade_produto;
    @Column (name = "nome_produto", length = 45, nullable = false)
    private String nome_produto;

    @Column(name = "preco_produto", nullable = false)
    private Double preco_produto;
    @Column(name = "tamanho", length = 4)
    private String tamanho;
    @Column(name = "cor", length = 45)
    private String cor;
    @Column(name = "imagem_path", length = 2555)
    private String imagem_path;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @Column(name = "id_categoria_produto")
    private Integer id_categoria_produto;



    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Integer getId_categoria_produto() {
        return id_categoria_produto;
    }

    public void setId_categoria_produto(Integer id_categoria_produto) {
        this.id_categoria_produto = id_categoria_produto;
    }

    public String getImagem_path() {
        return imagem_path;
    }

    public void setImagem_path(String imagem_path) {
        this.imagem_path = imagem_path;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public Integer getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(Integer quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(Double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
