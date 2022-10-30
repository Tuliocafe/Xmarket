package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dto.*;
import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.model.Endereco;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


public interface IClienteService {

    public Cliente criaNovo(ClienteDTO cliente);

    public Cliente atualizarDados(Cliente cliente);

    public ArrayList<Cliente> buscarTodos();

    public Cliente buscarPeloId(Integer id);

    public ArrayList<Cliente> buscaPorNome(String nome);

    public void excluirCliente(Integer id);

    public ArrayList<IEnderecoDTO> buscaEnderecoPeloIdCliente(Integer id);

    public Cliente atualizarCliente(Cliente cliente, Integer id);

    public Endereco atualizarEnderecoDoCliente(IEnderecoDTO endereco, Integer idUsuario, Integer idEndereco);

    IEnderecoDTO buscaEnderecoPeloId(Integer idUsuario, Integer idEndereco);

    Cliente logar(LoginDTO login);

    public boolean verificaEmail(String email);

    public Endereco criaNovoEndereco (EnderecoSalvarDTO endereco);

    public void excluirEnderecoPeloCliente( Integer idEndereco);

    public IClienteDTO buscaDadosCliente(Integer id);




}
