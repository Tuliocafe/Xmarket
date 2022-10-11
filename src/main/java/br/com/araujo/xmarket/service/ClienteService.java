package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.ClienteDAO;
import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    public ClienteDAO clienteDao;

    @Override
    public Cliente criaNovo(Cliente cliente) {
        if(cliente!= null) {
            return clienteDao.save(cliente);
        }
        return null;
    }

    @Override
    public Cliente atualizarDados(Cliente cliente) {
        if(cliente.getId() != null && cliente.getNome() != null){
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
    public void excluirCliente(Integer id) {

    }


}
