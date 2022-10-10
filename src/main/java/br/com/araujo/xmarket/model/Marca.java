package br.com.araujo.xmarket.model;


import javax.persistence.*;

@Entity
@Table(name="marca")
public class Marca {

    @Column(name="id_marca")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_marca;

    @Column(name="nome_marca", length = 255, nullable = false)
    private String nome_marca;

    @Column(name="descricao", length = 255, nullable = true)
    private String descricao;


    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getNome_marca() {
        return nome_marca;
    }

    public void setNome_marca(String nome_marca) {
        this.nome_marca = nome_marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
