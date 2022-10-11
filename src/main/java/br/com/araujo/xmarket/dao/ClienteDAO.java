package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
}
