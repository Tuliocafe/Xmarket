package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.dto.EnderecoDTO;
import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
    ArrayList<Cliente> findByNomeContaining(String palavra);


    @Query(value = """
            select logradouro_endereco as logradouro,
            CEP_endereco as cep,
            bairro_endereco as bairro,
            complemento_endereco as complemento,
            referencia as referencia,
            tipo_endereco as tipo,
            cidade.nome_cidade as cidade,
            estado.nome_estado as estado
            from usuario_cadastro inner join endereco on (usuario_cadastro.id_usuario = endereco.id_usuario)
            inner join cidade on (cidade.id_cidade = endereco.id_cidade)
            inner join estado on (cidade.id_estado = estado.id_estado)
            where usuario_cadastro.id_usuario = :id""", nativeQuery = true)
    ArrayList<IEnderecoDTO> buscaEnderecoPeloIdCliente(@Param("id") Integer id);
}
