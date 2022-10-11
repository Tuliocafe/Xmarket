package br.com.araujo.xmarket.controller;


import br.com.araujo.xmarket.model.Marca;
import br.com.araujo.xmarket.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MarcaController {


    @Autowired
    private IMarcaService service;

    @GetMapping("/marca")
    public ArrayList<Marca> recuperaTodos(){
        return service.buscarTodos();
    }

    @PostMapping("/marca")
    public Marca incluirNovo(@RequestBody Marca novo){
       return service.criaNovo(novo);
    }



}
