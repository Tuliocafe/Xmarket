package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProdutoDao extends CrudRepository<Produto, Integer> {

    public ArrayList<Produto> findByNomeContaining(String palavraPesquisada);

}
