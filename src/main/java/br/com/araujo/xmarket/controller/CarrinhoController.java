package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.CarrinhoDTO;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.service.ICarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CarrinhoController {

    @Autowired
    private ICarrinhoService carrinhoService;

    @GetMapping("/carrinhos")
    public ArrayList<CarrinhoCompra> recuperaTodos() {
        return carrinhoService.buscarTodas();
    }

    @GetMapping("/carrinhos/{id}")
    public ResponseEntity<CarrinhoCompra> buscarPeloId(@PathVariable Integer id){
        CarrinhoCompra res = carrinhoService.buscarPeloId(id);
        if(res !=null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/carrinhos/{id}")
    public ResponseEntity<CarrinhoCompra> alterarCarrinho(@RequestBody CarrinhoDTO dados){
        CarrinhoCompra res = carrinhoService.atualizarDados(dados);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/carrinhos/{id}")
    public ResponseEntity<CarrinhoCompra> excluirCarrinho(@PathVariable Integer id){

        boolean respostaDelete =  carrinhoService.excluirCarrinho(id);

        if (respostaDelete)
        {
            return  ResponseEntity.status(204).build();

        }

        return  ResponseEntity.status(412).build();

    }







}
