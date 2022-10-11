package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.VendaDao;
import br.com.araujo.xmarket.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class VendaServiceImpl implements IVendaService {
    @Autowired
    public VendaDao dao;

    @Override
    public Venda criaNova(Venda novo) {
        if(novo.getPrecoTotal() != null)
        {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Venda atualizarDados(Venda dados) {
        if(dados.getId()!=null ){
            return
                    dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Venda> buscarTodas() {
        return (ArrayList<Venda>)dao.findAll();
    }

    @Override
    public Venda buscarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirVenda(Integer id) {
        dao.deleteById(id);
    }
}
