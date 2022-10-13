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

    @GetMapping("/produtos")
    public ResponseEntity<ArrayList<Produto>> recuperarTodos(){
        ArrayList<Produto> listaProduto = service.recuperarTodos();
        if(listaProduto.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(listaProduto);
    }

    @GetMapping("/produtos/{id_produto}")
    public ResponseEntity<Produto> recuperarPeloId(@PathVariable Integer id_produto){
        Produto res = service.recuperarProdutoId(id_produto);
        if (res != null) {
            return ResponseEntity.ok(res);

        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> cadastrarNovo(@RequestBody Produto novo){
        Produto res = service.cadastrarNovo(novo);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/produtos/busca/{nome_produto}")
    public ResponseEntity<ArrayList<Produto>>  pesquisaPeloNometeste(@PathVariable String nome_produto){
        ArrayList<Produto>  listProduto = service.recuperaTodosPorNome(nome_produto);
        if(listProduto.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(listProduto);
    }
}
