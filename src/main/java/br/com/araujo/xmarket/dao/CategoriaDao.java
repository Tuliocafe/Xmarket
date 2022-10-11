package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaDao extends CrudRepository<Categoria, Integer> {

}
