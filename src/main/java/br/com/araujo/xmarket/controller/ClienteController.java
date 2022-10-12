package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes")
    public ArrayList<Cliente> recuperaTodosClientes()
    {
        return clienteService.buscarTodos();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> recuperaPorId(@PathVariable Integer id) {

        Cliente response = clienteService.buscarPeloId(id);

        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> cadastrarNovo(@RequestBody Cliente produto){
        Cliente res = clienteService.criaNovo(produto);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/busca")
    public ArrayList<Cliente> buscarPorNome(@RequestParam(name = "palavra") String palavra){
        return clienteService.buscaPorNome(palavra);

    }
}
