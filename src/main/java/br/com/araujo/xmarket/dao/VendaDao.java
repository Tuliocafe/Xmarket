package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Venda;
import org.springframework.data.repository.CrudRepository;

public interface VendaDao extends CrudRepository <Venda, Integer> {


}
