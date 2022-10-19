package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.service.ICarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CarrinhoController {

    @Autowired
    private ICarrinhoService service;

    @GetMapping("/carrinhos")
    public ArrayList<CarrinhoCompra> recuperaTodos() {
        return service.buscarTodas();
    }

    @GetMapping("/carrinhos/{id}")
    public ResponseEntity<CarrinhoCompra> buscarPeloId(@PathVariable Integer id){
    CarrinhoCompra res = service.buscarPeloId(id);
    if(res !=null){
        return ResponseEntity.ok(res);
    }
    return ResponseEntity.status(404).build();
    }

    @PutMapping("/carrinhos/{id}")
    public ResponseEntity<CarrinhoCompra> alterarCarrinho(@RequestBody CarrinhoCompra dados){
        CarrinhoCompra res = service.atualizarDados(dados);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/carrinhos/{id}")
    public ResponseEntity<CarrinhoCompra> excluirCarrinho(@PathVariable Integer id){
        service.excluirCarrinho(id);
        return  ResponseEntity.ok(null);
    }







}
