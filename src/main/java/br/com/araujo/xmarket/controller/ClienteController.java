package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.*;
import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.model.Endereco;
import br.com.araujo.xmarket.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteServiceImpl;

//    @Autowired
//    ClienteJPA clienteJPA;

    @GetMapping("/clientes")
    public ResponseEntity<?> recuperaTodosClientes() {
        ArrayList<Cliente>  todosClientes = clienteServiceImpl.buscarTodos();

        if(todosClientes == null)
        {
            return new ResponseEntity<>(new ApiMessage("Não existe clientes cadastrados"), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(todosClientes, HttpStatus.OK);

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
    public ResponseEntity<Cliente> cadastrarNovo(@RequestBody ClienteDTO cliente) {
        System.out.println("------------------------------------------------------------" + cliente.getNome());
        if(clienteServiceImpl.verificaEmail(cliente.getEmail())){
            return new ResponseEntity( new ApiMessage("Email já existente na base de dados"), HttpStatus.NOT_FOUND);
        }

        Cliente res = clienteServiceImpl.criaNovo(cliente);

        if (res != null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);

        }
        return ResponseEntity.badRequest().build();
    }


    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> AtualizaCliente(@RequestBody Cliente cliente, @PathVariable("id") Integer id) {
        Cliente response = clienteServiceImpl.atualizarCliente(cliente, id);

        if (response != null) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/{id}/enderecos")
    public ArrayList<IEnderecoDTO> buscarEndereco(@PathVariable Integer id) {
        return clienteServiceImpl.buscaEnderecoPeloIdCliente(id);
    }

    @GetMapping("/clientes/{id_usuario}/enderecos/{id_endereco}")
    public IEnderecoDTO recuperaPorId(@PathVariable("id_usuario") Integer idUsuario, @PathVariable("id_endereco") Integer idEndereco) {

        return clienteServiceImpl.buscaEnderecoPeloId(idUsuario, idEndereco);

    }

    @PutMapping("/clientes/{id_usuario}/enderecos/{id_endereco}")
    public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco, @PathVariable("id_usuario") Integer idUsuario, @PathVariable("id_endereco") Integer idEndereco) {

        Endereco response = clienteServiceImpl.atualizarEnderecoDoCliente(endereco, idUsuario, idEndereco);

        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/clientes/busca")
    public ArrayList<Cliente> buscarPorNome(@RequestParam(name = "palavra") String palavra) {
        return clienteServiceImpl.buscaPorNome(palavra);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {
        clienteServiceImpl.excluirCliente(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/clientes/login")
    public ResponseEntity<Cliente> Logar(@RequestBody LoginDTO clienteLogin)  {

        Cliente cliente = clienteServiceImpl.logar(clienteLogin);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }

//        throw  new Exception("Usuario e senha inválida");
       return new ResponseEntity( new ApiMessage("Usuario e senha inválida"), HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/clientes/{id_usuario}/enderecos")
    public ResponseEntity<Endereco> novoEndereco(@PathVariable("id_usuario") Integer idUsuario, @RequestBody EnderecoSalvarDTO novoEndereco){
        Endereco res = clienteServiceImpl.criaNovoEndereco(novoEndereco);
        if (res != null){
            return new ResponseEntity<>( res, HttpStatus.CREATED);

        }
        return  ResponseEntity.badRequest().build();
    }


}
