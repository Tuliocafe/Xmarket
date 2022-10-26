package br.com.araujo.xmarket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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
    private String nome;
    @Column(name = "preco_produto", nullable = false)
    private Double preco;
    @Column(name = "tamanho", length = 4)
    private String tamanho;
    @Column(name = "cor", length = 45)
    private String cor;


    @Column(name = "imagem_path", length = 2555)
    private String imagem_path;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_categoria_produto")
    private Categoria categoria;



}
