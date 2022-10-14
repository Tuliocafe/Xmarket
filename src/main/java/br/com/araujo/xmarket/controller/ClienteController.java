package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.model.Endereco;
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
    public ResponseEntity<Cliente> cadastrarNovo(@RequestBody Cliente cliente){

        Cliente res = clienteService.criaNovo(cliente);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes")
    public ResponseEntity<Cliente> alterarVenda(@RequestBody Cliente cliente){
        Cliente response = clienteService.atualizarDados(cliente);
        if(response != null){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> AtualizaCliente(@RequestBody Cliente cliente, @PathVariable("id") Integer id) {
        Cliente response =  clienteService.atualizarCliente(cliente, id);

        if(response != null){
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/{id}/enderecos")
    public ArrayList<IEnderecoDTO> buscarEndereco(@PathVariable Integer id){

        return clienteService.buscaEnderecoPeloIdCliente(id);

    }

    @GetMapping("/clientes/{id_usuario}/enderecos/{id_endereco}")
    public IEnderecoDTO recuperaPorId(@PathVariable("id_usuario") Integer idUsuario, @PathVariable("id_endereco") Integer idEndereco) {

        return clienteService.buscaEnderecoPeloId(idUsuario, idEndereco);

    }
    @PutMapping("/clientes/{id_usuario}/enderecos/{id_endereco}")
    public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco, @PathVariable("id_usuario") Integer idUsuario, @PathVariable("id_endereco") Integer idEndereco) {

        Endereco response =  clienteService.atualizarEnderecoDoCliente(endereco, idUsuario, idEndereco);

        if(response != null){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }



    @PostMapping("/clientes/{id_usuario}/enderecos")
    public ResponseEntity<Endereco> cadastrarNovo(@RequestBody Endereco endereco, @PathVariable("id_usuario") Integer idUsuario){

//        return clienteService.salvaEndereco(endereco);
        return null;

    }

    @GetMapping("/clientes/busca")
    public ArrayList<Cliente> buscarPorNome(@RequestParam(name = "palavra") String palavra){
        return clienteService.buscaPorNome(palavra);
    }
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> excluirCliente( @PathVariable Integer id){
        clienteService.excluirCliente(id);
        return ResponseEntity.ok(null);
    }



}
