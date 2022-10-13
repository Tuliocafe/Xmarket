package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.ClienteDAO;
import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    public ClienteDAO clienteDao;

    @Override
    public Cliente criaNovo(Cliente cliente) {
        if (cliente != null) {
            return clienteDao.save(cliente);
        }
        return null;
    }

    @Override
    public Cliente atualizarDados(Cliente cliente) {
        if (cliente.getId() != null && cliente.getNome() != null) {
            return clienteDao.save(cliente);
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> buscarTodos() {
        return (ArrayList<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente buscarPeloId(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public ArrayList<Cliente> buscaPorNome(String nome) {
        return clienteDao.findByNomeContaining(nome);
    }

    @Override
    public void excluirCliente(Integer id) {
        clienteDao.deleteById(id);
    }

    @Override
    public ArrayList<IEnderecoDTO> buscaEnderecoPeloIdCliente(Integer id) {
        return clienteDao.buscaEnderecoPeloIdCliente(id);
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente, Integer id) {

        Cliente novoCliente = clienteDao.findById(id).orElse(null);

        if (novoCliente != null) {

            novoCliente.setNome(cliente.getNome());
            novoCliente.setCpf(cliente.getCpf());
            novoCliente.setSobrenome(cliente.getSobrenome());
            novoCliente.setDataNascimento(cliente.getDataNascimento());
            novoCliente.setTelefoneUm(cliente.getTelefoneUm());
            novoCliente.setTelefoneDois(cliente.getTelefoneDois());
            novoCliente.setRg(cliente.getRg());
            novoCliente.setDataCriacaoUsuario(cliente.getDataCriacaoUsuario());
            clienteDao.save(novoCliente);

            // TODO
            // Atualizar Enderecos Usuario
            return novoCliente;
        }
        return null;
    }



}
