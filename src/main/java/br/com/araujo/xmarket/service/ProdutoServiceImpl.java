package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.ProdutoDao;
import br.com.araujo.xmarket.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoDao dao;

    @Override
    public ArrayList<Produto> recuperarTodos() {
        return (ArrayList<Produto>) dao.findAll();
//    return dao.findByNomeContaining("Politico");
//    return dao.findByOrderByPreco();
    }

    @Override
    public Produto recuperarProdutoId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Produto cadastrarNovo(Produto novo) {
        return dao.save(novo);
    }

    public ArrayList<Produto> recuperaTodosPorNome(String nome){
        return dao.findByNomeContaining(nome);
    }

}
