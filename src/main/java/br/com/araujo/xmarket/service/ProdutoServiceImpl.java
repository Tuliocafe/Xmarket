package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.ProdutoDao;
import br.com.araujo.xmarket.dto.IHistoricoPrecoProdutoDTO;
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

    @Override
    public void excluirProduto(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Produto atualizaProduto(Produto novo, Integer idAntigo) {
        novo.setId_produto(idAntigo);
        if(novo.getId_produto() != null && novo.getNome_produto() != null && novo.getPreco_produto()
                != null && novo.getCategoria() != null && novo.getMarca() != null){
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public ArrayList<IHistoricoPrecoProdutoDTO> buscaHistoricoPorPreco(Integer id){
        return dao.buscaHistoricoPorPreco(id);
    }

}
