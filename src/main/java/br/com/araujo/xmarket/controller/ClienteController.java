package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.model.Endereco;
import br.com.araujo.xmarket.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/clientes")
    public ArrayList<Cliente> recuperaTodosClientes()
    {
        return clienteServiceImpl.buscarTodos();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> recuperaPorId(@PathVariable Integer id) {

        Cliente response = clienteServiceImpl.buscarPeloId(id);

        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> cadastrarNovo( Cliente cliente){

        Cliente res = clienteServiceImpl.criaNovo(cliente);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }


    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> AtualizaCliente(@RequestBody Cliente cliente, @PathVariable("id") Integer id) {
        Cliente response =  clienteServiceImpl.atualizarCliente(cliente, id);

        if(response != null){
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/{id}/enderecos")
    public ArrayList<IEnderecoDTO> buscarEndereco(@PathVariable Integer id){

        return clienteServiceImpl.buscaEnderecoPeloIdCliente(id);

    }

    @GetMapping("/clientes/{id_usuario}/enderecos/{id_endereco}")
    public IEnderecoDTO recuperaPorId(@PathVariable("id_usuario") Integer idUsuario, @PathVariable("id_endereco") Integer idEndereco) {

        return clienteServiceImpl.buscaEnderecoPeloId(idUsuario, idEndereco);

    }
    @PutMapping("/clientes/{id_usuario}/enderecos/{id_endereco}")
    public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco, @PathVariable("id_usuario") Integer idUsuario, @PathVariable("id_endereco") Integer idEndereco) {

        Endereco response =  clienteServiceImpl.atualizarEnderecoDoCliente(endereco, idUsuario, idEndereco);

        if(response != null){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/clientes/busca")
    public ArrayList<Cliente> buscarPorNome(@RequestParam(name = "palavra") String palavra){
        return clienteServiceImpl.buscaPorNome(palavra);
    }
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> excluirCliente( @PathVariable Integer id){
        clienteServiceImpl.excluirCliente(id);
        return ResponseEntity.ok(null);
    }



}
