package br.com.araujo.xmarket.model;

import javax.persistence.*;

@Entity
@Table(name="categoria_produto")
public class Categoria {





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_produto")
    private Integer id_categoria_produto;

    @Column(name="nome_categoria")
    private String nome_categoria;

    @Column(name="descricao")
    private String descricao;

    public Integer getId_categoria_produto() {
        return id_categoria_produto;
    }

    public void setId_categoria_produto(Integer id_categoria_produto) {
        this.id_categoria_produto = id_categoria_produto;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}