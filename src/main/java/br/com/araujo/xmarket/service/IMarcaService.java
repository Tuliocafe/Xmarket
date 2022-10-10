package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.model.Marca;

import java.util.ArrayList;

public interface IMarcaService {
    public Marca criaNovo (Marca novo);
    public Marca AtualizarDados (Marca dados);
    public ArrayList<Marca> buscarTodos();
    public Marca buscarPeloId(Integer id);
    public void excluirMarca(Integer id);

}
