package br.com.araujo.xmarket.dto;

import br.com.araujo.xmarket.model.Produto;
import br.com.araujo.xmarket.model.Venda;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoDTO {

    private Integer id;

    private Integer quantidade;

    private String desconto;

    private String precoUnitario;

    private Double precoTotal;

    private Integer venda;

    private Integer produto;
}
