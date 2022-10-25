package br.com.araujo.xmarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EnderecoSalvarDTO {


    private String logradouro;
    private String cep;
    private String bairro;
    private String complemento;
    private String referencia;
    private String tipo;
    private Integer cidade;
    private Integer idUsuario;
}
