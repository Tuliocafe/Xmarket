package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.CarrinhoCompra;
import org.springframework.data.repository.CrudRepository;

public interface CarrinhoDao extends CrudRepository<CarrinhoCompra, Integer> {

}
