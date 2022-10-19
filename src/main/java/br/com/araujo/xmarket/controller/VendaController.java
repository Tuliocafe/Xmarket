package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.ItemDTO;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Venda;
import br.com.araujo.xmarket.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class VendaController {

    @Autowired
    private IVendaService vendaService;

    @GetMapping("/vendas")
    public ArrayList<Venda> recuperaTodos(){
        return vendaService.buscarTodas();
    }

    @GetMapping("/vendas/{id}")
    public ResponseEntity<Venda> buscarPeloId(@PathVariable Integer id){
        Venda res = vendaService.buscarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/vendas")
    public ResponseEntity<Venda> incluirNovo(@RequestBody Venda novo){
        Venda res = vendaService.criaNova(novo);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/vendas/{id_venda}")
    public ResponseEntity<Venda> alterarVenda(@RequestBody Venda dados){
        Venda res = vendaService.atualizarDados(dados);
        if(res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("vendas/{id_venda}")
    public ResponseEntity<Venda> excluirVenda(@PathVariable Integer id_venda){
        vendaService.excluirVenda(id_venda);
        return ResponseEntity.ok(null);
    }

    @PostMapping("vendas/{id_venda}")
    public CarrinhoCompra incluirItemNaVenda(@RequestBody ItemDTO itemDto) {
        return vendaService.incluirItemNaVenda(itemDto);
    }

}
