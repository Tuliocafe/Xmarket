package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco, Integer> {
    @Transactional
    @Modifying
    @Query(value = """
            delete from endereco where id_endereco = :id""", nativeQuery = true)

    void deletandoEndereco(@Param("id") Integer id);
}
