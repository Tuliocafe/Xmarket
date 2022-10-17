package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoDAO extends CrudRepository<Endereco, Integer> {
}
