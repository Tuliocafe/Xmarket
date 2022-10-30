package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.CidadeDao;
import br.com.araujo.xmarket.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CidadeServiceImpl implements ICidadeService{
    @Autowired
    private CidadeDao cidadeDao;


    @Override
    public ArrayList<Cidade> buscarTodas() {

        return (ArrayList<Cidade>)cidadeDao.findAll();
    }
}
