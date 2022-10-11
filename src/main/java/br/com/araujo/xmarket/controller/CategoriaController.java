package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.Categoria;
import br.com.araujo.xmarket.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService service;

    @GetMapping("/categoria")
    public ArrayList<Categoria> recuperarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/categoria/{id}")
    public Categoria buscarPeloId(@PathVariable Integer id){
        return service.buscarPeloId(id);
    }

    @PostMapping("/categoia")
    public Categoria incluirNovo(@RequestBody Categoria novo){
        Categoria res = service.criaNovo(novo);
        return res;
    }

}
