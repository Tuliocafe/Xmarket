package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.StatusVendasDao;
import br.com.araujo.xmarket.model.StatusVendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class StatusVendasServiceImpl implements IStatusVendasService {
    @Autowired
    public StatusVendasDao dao;

    @Override
    public StatusVendas criaNovo(StatusVendas novo) {
        if(novo.getStatus()!= null){
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public StatusVendas atualizarDados(StatusVendas dados) {
        if(dados.getStatus()!= null){
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<StatusVendas> buscarTodos() {
        return (ArrayList<StatusVendas>)dao.findAll();
    }

    @Override
    public StatusVendas buscarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirStatus(Integer id) {
        dao.deleteById(id);
    }
}
