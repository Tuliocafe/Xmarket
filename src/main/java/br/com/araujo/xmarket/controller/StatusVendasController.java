package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.StatusVendas;
import br.com.araujo.xmarket.service.IStatusVendasService;
import jdk.jshell.Snippet;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StatusVendasController {
    @Autowired
    private IStatusVendasService service;

    @GetMapping("/status")
    public ArrayList<StatusVendas> recuperaTodos(){
        return service.buscarTodos();
    }


    @GetMapping("/status/{id}")
    public ResponseEntity<StatusVendas> buscarPeloId(@PathVariable Integer id){
        StatusVendas res = service.buscarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/status")
    public ResponseEntity<StatusVendas> incluiNovo(@RequestBody StatusVendas novo){
        StatusVendas res = service.criaNovo(novo);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }


    @PutMapping("/status")
    public ResponseEntity<StatusVendas> alteraStatus(@RequestBody StatusVendas dados){
        StatusVendas res = service.atualizarDados(dados);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("status/{id}")
    public ResponseEntity<StatusVendas> excluirStatus(@PathVariable Integer id){
        service.excluirStatus(id);
        return ResponseEntity.ok(null);
    }





}
