package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.CarrinhoDao;
import br.com.araujo.xmarket.dao.ProdutoDao;
import br.com.araujo.xmarket.dao.VendaDao;
import br.com.araujo.xmarket.dto.CarrinhoDTO;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Produto;
import br.com.araujo.xmarket.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarrinhoServiceImpl implements ICarrinhoService{
    @Autowired
    public CarrinhoDao carrinhoDao;

    @Autowired
    public VendaDao vendaDao;

    @Autowired
    public ProdutoDao produtoDao;


    @Override
    public CarrinhoCompra criaNovo(CarrinhoCompra novo) {
        if(novo.getPrecoTotal() != null)
        {
            return carrinhoDao.save(novo);
        }
        return null;
    }



    @Override
    public CarrinhoCompra atualizarDados(CarrinhoDTO dados) {

        Venda venda = vendaDao.findById(dados.getVenda()).orElse(null);

        Produto produto =  produtoDao.findById(dados.getProduto()).orElse(null);

        assert produto != null;
        if(produto.getQuantidade_produto() < dados.getQuantidade())
        {
            throw new RuntimeException("Quantidade em estoque insuficiente");

        }

        produto.setQuantidade_produto(produto.getQuantidade_produto() - dados.getQuantidade());

        produtoDao.save(produto);



        CarrinhoCompra novoItem = CarrinhoCompra.builder()
                .id(dados.getId())
                .precoTotal(dados.getPrecoTotal())
                .quantidade(dados.getQuantidade())
                .precoUnitario(produto.getPreco())
                .venda(venda)
                .produto(produto)
                .build();

        carrinhoDao.save(novoItem);
        return novoItem;


    }

    @Override
    public ArrayList<CarrinhoCompra> buscarTodas() {
        return (ArrayList<CarrinhoCompra>) carrinhoDao.findAll();
    }

    @Override
    public CarrinhoCompra buscarPeloId(Integer id) {
        return carrinhoDao.findById(id).orElse(null);
    }

    @Override
    public boolean excluirCarrinho(Integer id) {

        CarrinhoCompra carrinhoCompra = carrinhoDao.findById(id).orElse(null);

        if(carrinhoCompra == null) {return false;}

        Integer idProduto = carrinhoCompra.getProduto().getId_produto();



        Produto produto = produtoDao.findById(idProduto).orElse(null);

        if(produto == null) {return false;}

        Integer quantidadeProdutoCarrinho = carrinhoCompra.getQuantidade();

        Integer quantidadeProduto = produto.getQuantidade_produto();

        produto.setQuantidade_produto(quantidadeProduto + quantidadeProdutoCarrinho);

        produtoDao.save(produto);

        carrinhoDao.deleteById(id);

        return true;

    }
}
