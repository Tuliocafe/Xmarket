package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.model.Produto;

import java.util.ArrayList;

public interface IProdutoService {

    public ArrayList<Produto> recuperarTodos();
    public Produto recuperarProdutoId(Integer id);
    public Produto cadastrarNovo(Produto novo);

    public ArrayList<Produto> recuperaTodosPorNome(String nome);
}
