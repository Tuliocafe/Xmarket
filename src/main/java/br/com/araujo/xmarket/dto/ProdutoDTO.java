package br.com.araujo.xmarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private String nome;
    private Integer quantidade;
    private String tamanho;
    private String cor;
    private String imagem_path;
    private Double preco;
    private Integer marca;
    private Integer categoria;

}
