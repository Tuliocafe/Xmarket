package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Marca;
import org.springframework.data.repository.CrudRepository;

public interface MarcaDao extends CrudRepository<Marca, Integer> {

}
