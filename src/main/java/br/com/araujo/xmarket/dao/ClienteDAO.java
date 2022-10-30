package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.dto.IClienteDTO;
import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.dto.LoginDTO;
import br.com.araujo.xmarket.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer> {
    ArrayList<Cliente> findByNomeContaining(String palavra);


    @Query(value = """
            select id_endereco as id,
            logradouro_endereco as logradouro,
            CEP_endereco as cep,
            bairro_endereco as bairro,
            numero as numero,
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

    @Query(value = """
            select id_endereco as id,
            logradouro_endereco as logradouro,
            CEP_endereco as cep,
            bairro_endereco as bairro,
            numero as numero,
            complemento_endereco as complemento,
            referencia as referencia,
            tipo_endereco as tipo,
            cidade.nome_cidade as cidade,
            estado.nome_estado as estado
            from usuario_cadastro inner join endereco on (usuario_cadastro.id_usuario = endereco.id_usuario)
            inner join cidade on (cidade.id_cidade = endereco.id_cidade)
            inner join estado on (cidade.id_estado = estado.id_estado)
            where usuario_cadastro.id_usuario = :idUsuario and endereco.id_endereco = :idEndereco""", nativeQuery = true)
    IEnderecoDTO buscaEnderecoPeloId(@Param("idUsuario") Integer idUsuario, @Param("idEndereco") Integer idEndereco);

        Cliente getByEmail(String email);

    public boolean existsByEmail(String email);


    @Query(value = """
            select id_usuario as id,
            nome_usuario as nome,
            sobrenome_usuario as sobrenome,
            CPF_usuario as cpf,
            rg_usuario as rg,
            dataNascimento_usuario as dataNascimento,
            telefoneDois_usuario as telefoneUm,
            telefoneDois_usuario as telefoneDois,
            senha as senha,
            email as email
            from usuario_cadastro
            where usuario_cadastro.id_usuario = :id""", nativeQuery = true)
        IClienteDTO buscaDadosCliente(@Param("id") Integer id);

}
