package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.model.Marca;

import java.util.ArrayList;

public interface IMarcaService {
    public Marca criaNovo (Marca novo);
    public Marca atualizarDados (Marca dados, Integer id);
    public ArrayList<Marca> buscarTodos();
    public Marca buscarPeloId(Integer id);
    public void excluirMarca(Integer id);

}
