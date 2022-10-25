package br.com.araujo.xmarket.dto;

import br.com.araujo.xmarket.model.Endereco;
import br.com.araujo.xmarket.model.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String telefoneUm;
    private String telefoneDois;
    private String dataCriacaoUsuario;
    private String senha;
    private String email;
    private TipoUsuario tipoUsuario;
    private Integer status;
//    private Endereco endereco;


}
