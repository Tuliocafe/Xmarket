package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.Categoria;
import br.com.araujo.xmarket.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService service;

    @GetMapping("/categorias")
    public ArrayList<Categoria> recuperarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/categorias/{id}")
    public Categoria buscarPeloId(@PathVariable Integer id){
        return service.buscarPeloId(id);
    }

    @PostMapping("/categorias")
    public Categoria incluirNovo(@RequestBody Categoria novo){
        Categoria res = service.criaNovo(novo);
        return res;
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria dados, @PathVariable Integer id){
        Categoria res = service.AtualizarDados(dados, id);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/categorias/{id}")
    public void removerCategoria(@PathVariable Integer id){
        service.excluirCategoria(id);
    }

}
