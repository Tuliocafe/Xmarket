package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dto.ItemDTO;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Venda;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public interface IVendaService {

    public Venda criaNova (Venda novo);
    public Venda atualizarDados (Venda dados);
    public ArrayList<Venda> buscarTodas();
    public Venda buscarPeloId(Integer id);
    public void excluirVenda(Integer id);
    public CarrinhoCompra incluirItemNaVenda( ItemDTO itemDto);




}
