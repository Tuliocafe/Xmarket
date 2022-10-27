package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dto.CarrinhoDTO;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Venda;

import java.util.ArrayList;

public interface ICarrinhoService {

    public CarrinhoCompra criaNovo (CarrinhoCompra novo);
    public CarrinhoCompra atualizarDados (CarrinhoDTO dados);
    public ArrayList<CarrinhoCompra> buscarTodas();
    public CarrinhoCompra buscarPeloId(Integer id);
    public boolean excluirCarrinho(Integer id);
}
