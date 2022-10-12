package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.Produto;
import br.com.araujo.xmarket.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProdutoController {

    @Autowired
    private IProdutoService service;

    @GetMapping("/produto")
    public ArrayList<Produto> recuperarTodos(){
        return service.recuperarTodos();
    }

    @GetMapping("/produto/{id_produto}")
    public ResponseEntity<Produto> recuperarPeloId(@PathVariable Integer id_produto){
        Produto res = service.recuperarProdutoId(id_produto);
        if (res != null) {
            return ResponseEntity.ok(res);

        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/produto")
    public ResponseEntity<Produto> cadastrarNovo(@RequestBody Produto novo){
        Produto res = service.cadastrarNovo(novo);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

}
