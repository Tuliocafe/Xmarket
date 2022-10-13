package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.model.Venda;

import java.util.ArrayList;

public interface IVendaService {

    public Venda criaNova (Venda novo);
    public Venda atualizarDados (Venda dados);
    public ArrayList<Venda> buscarTodas();
    public Venda buscarPeloId(Integer id);
    public void excluirVenda(Integer id);

}
