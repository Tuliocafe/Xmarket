package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.model.StatusVendas;

import java.util.ArrayList;

public interface IStatusVendasService {


    public StatusVendas criaNovo(StatusVendas novo);
    public StatusVendas atualizarDados (StatusVendas dados);
    public ArrayList<StatusVendas> buscarTodos();
    public StatusVendas buscarPeloId(Integer id);
    public void excluirStatus(Integer id);

}
