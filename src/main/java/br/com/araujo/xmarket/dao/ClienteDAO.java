package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
    ArrayList<Cliente> findByNomeContaining(String palavra);
}
