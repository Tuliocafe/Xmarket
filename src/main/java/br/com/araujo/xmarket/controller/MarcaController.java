package br.com.araujo.xmarket.controller;


import br.com.araujo.xmarket.model.Marca;
import br.com.araujo.xmarket.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
public class MarcaController {


    @Autowired
    private IMarcaService service;


    @GetMapping("/marcas")
    public ArrayList<Marca> recuperaTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/marcas/{id_marca}")
    public ResponseEntity<Marca> buscarPeloId(@PathVariable Integer id_marca){
        Marca res = service.buscarPeloId(id_marca);
        if(res != null ){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/marcas")
    public ResponseEntity<Void> incluirNovo(Marca novo){
        Marca res = service.criaNovo(novo);
//        return ResponseEntity.status(202).header("Custom-Header", "foo").
//                .body("Custom header set");
        if (res != null){
            return ResponseEntity.status(202).build();
//                    return ResponseEntity.status(202).location(URI.create("http://localhost:8080/index")).build();
        }
        return  ResponseEntity.badRequest().build();
    }



    @PutMapping("/marcas/{id_marca}")
        public ResponseEntity<Marca> alterarMarca(@PathVariable Integer id_marca, @RequestBody Marca dados){
//        Marca antiga = service.buscarPeloId(id_marca);
        Marca nova = service.atualizarDados(dados, id_marca);

        if(nova != null){
            return ResponseEntity.ok(dados);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/marcas/{id_marca}")
    public  ResponseEntity<Marca> excluirMarca(@PathVariable Integer id_marca){

        service.excluirMarca(id_marca);
        return ResponseEntity.ok(null);
    }




}
