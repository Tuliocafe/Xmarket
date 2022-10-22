package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJPA extends JpaRepository<Cliente, Integer> {


}
