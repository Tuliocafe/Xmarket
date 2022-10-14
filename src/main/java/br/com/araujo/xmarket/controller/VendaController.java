package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.Venda;
import br.com.araujo.xmarket.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class VendaController {

    @Autowired
    private IVendaService service;

    @GetMapping("/vendas")
    public ArrayList<Venda> recuperaTodos(){
        return service.buscarTodas();
    }

    @GetMapping("/vendas/{id}")
    public ResponseEntity<Venda> buscarPeloId(@PathVariable Integer id){
        Venda res = service.buscarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/vendas")
    public ResponseEntity<Venda> incluirNovo(@RequestBody Venda novo){
        Venda res = service.criaNova(novo);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/vendas/{id_venda}")
    public ResponseEntity<Venda> alterarVenda(@RequestBody Venda dados){
        Venda res = service.atualizarDados(dados);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("vendas/{id_venda}")
    public ResponseEntity<Venda> excluirVenda(@PathVariable Integer id_venda){
        service.excluirVenda(id_venda);
        return ResponseEntity.ok(null);
    }




}
