package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.CategoriaDao;
import br.com.araujo.xmarket.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    public CategoriaDao dao;

    @Override
    public Categoria criaNovo(Categoria novo) {
       if(novo.getNome_categoria() !=null){
        return dao.save(novo);
       }
        return null;
    }

    @Override
    public Categoria AtualizarDados(Categoria dados) {
        if(dados.getId_categoria_produto() != null && dados.getNome_categoria() !=null){
         return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Categoria> buscarTodos() {
        return (ArrayList<Categoria>)dao.findAll();
    }

    @Override
    public Categoria buscarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }
}
