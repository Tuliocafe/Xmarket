package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoDao extends CrudRepository<Produto, Integer> {
}
