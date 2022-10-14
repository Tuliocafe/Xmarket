package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.model.Categoria;

import java.util.ArrayList;
//Feito Por Luccas
public interface ICategoriaService {
    public Categoria criaNovo(Categoria novo);

    public Categoria AtualizarDados(Categoria dados, Integer id);

    public ArrayList<Categoria> buscarTodos();

    public Categoria buscarPeloId(Integer id);

    public void excluirCategoria(Integer id);

}
