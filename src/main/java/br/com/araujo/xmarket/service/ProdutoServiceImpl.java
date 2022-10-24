package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.CategoriaDao;
import br.com.araujo.xmarket.dao.MarcaDao;
import br.com.araujo.xmarket.dao.ProdutoDao;
import br.com.araujo.xmarket.dto.IHistoricoPrecoProdutoDTO;
import br.com.araujo.xmarket.dto.ProdutoDTO;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Categoria;
import br.com.araujo.xmarket.model.Marca;
import br.com.araujo.xmarket.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private MarcaDao marcaDao;

    @Autowired
    private CategoriaDao categoriaDao;
    @Autowired
    private ProdutoDao produtoDao;

    @Override
    public ArrayList<Produto> recuperarTodos() {
        return (ArrayList<Produto>) produtoDao.findAll();
    }

    @Override
    public Produto recuperarProdutoId(Integer id) {
        return produtoDao.findById(id).orElse(null);
    }

    @Override
    public Produto cadastrarNovo(ProdutoDTO produto) {

        Marca marca = marcaDao.findById(produto.getMarca()).orElse(null);

        Categoria categoria =  categoriaDao.findById(produto.getCategoria()).orElse(null);


        Produto novoProduto = Produto.builder()
                .quantidade_produto(produto.getQuantidade())
                .preco(produto.getPreco())
                .imagem_path(produto.getImagem_path())
                .nome(produto.getNome())
                .tamanho(produto.getTamanho())
                .cor(produto.getCor())
                .marca(marca)
                .categoria(categoria)
                .build();

        produtoDao.save(novoProduto);
        return novoProduto;
    }

    public ArrayList<Produto> recuperaTodosPorNome(String nome){
        return produtoDao.findByNomeContaining(nome);
    }

    @Override
    public void excluirProduto(Integer id) {
        produtoDao.deleteById(id);
    }

    @Override
    public Produto atualizaProduto(Produto novo, Integer idAntigo) {
        novo.setId_produto(idAntigo);
        if(novo.getId_produto() != null && novo.getNome_produto() != null && novo.getPreco_produto()
                != null && novo.getCategoria() != null && novo.getMarca() != null){
            return produtoDao.save(novo);
        }
        return null;
    }

    @Override
    public ArrayList<IHistoricoPrecoProdutoDTO> buscaHistoricoPorPreco(Integer id){
        return produtoDao.buscaHistoricoPorPreco(id);
    }

}
