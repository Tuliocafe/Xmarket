package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.CarrinhoDao;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarrinhoServiceImpl implements ICarrinhoService{
    @Autowired
    public CarrinhoDao dao;

    @Override
    public CarrinhoCompra criaNovo(CarrinhoCompra novo) {
        if(novo.getPrecoTotal() != null)
        {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public CarrinhoCompra atualizarDados(CarrinhoCompra dados) {
        if(dados.getId()!= null){
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<CarrinhoCompra> buscarTodas() {
        return (ArrayList<CarrinhoCompra>)dao.findAll();
    }

    @Override
    public CarrinhoCompra buscarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirCarrinho(Integer id) {
        dao.deleteById(id);
    }
}
