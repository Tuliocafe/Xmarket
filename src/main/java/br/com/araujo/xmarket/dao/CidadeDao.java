package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeDao extends JpaRepository<Cidade, Integer> {

}
