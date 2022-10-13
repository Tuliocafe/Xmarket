package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.model.Cliente;

import java.util.ArrayList;

public interface IClienteService {

    public Cliente criaNovo (Cliente cliente);
    public Cliente atualizarDados (Cliente cliente);
    public ArrayList<Cliente> buscarTodos();
    public Cliente buscarPeloId(Integer id);

    public ArrayList<Cliente> buscaPorNome(String nome);

    public void excluirCliente(Integer id);

    public ArrayList<IEnderecoDTO> buscaEnderecoPeloIdCliente(Integer id);

    public Cliente atualizarCliente(Cliente cliente, Integer id);

}
