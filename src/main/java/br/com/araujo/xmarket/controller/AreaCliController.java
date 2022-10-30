package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.*;
import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.model.Endereco;
import br.com.araujo.xmarket.service.ClienteServiceImpl;
import br.com.araujo.xmarket.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AreaCliController {
    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/area-cliente")
    public String home(){

        return "paginas/area-cliente";
    }


    @GetMapping("/area-cliente/{id}")
    public String buscarEnderecos(Model m,@PathVariable Integer id){
        ArrayList<IEnderecoDTO> end = clienteService.buscaEnderecoPeloIdCliente(id);
        Cliente cliente = clienteService.buscarPeloId(id);
        m.addAttribute("cliente", cliente);
        m.addAttribute("end", end);
        m.addAttribute("idCliente", id);
        return "paginas/area-cliente";
    }

    @GetMapping("/area-cliente/cadastro-cliente")
    public String areaCadastro(){
        return "paginas/editCadastro";
    }

    @GetMapping("/area-cliente/cadastro-cliente/{id}")
    public String buscaClientePeloId(Model m, @PathVariable Integer id){
        IClienteDTO cliente = clienteService.buscaDadosCliente(id);
        m.addAttribute("cliente", cliente);
        return "/paginas/editCadastro";
    }

    @GetMapping("/area-cliente/altera-senha/{id}")
    public String buscaCliente(Model m, @PathVariable Integer id){
        IClienteDTO cliente = clienteService.buscaDadosCliente(id);
        m.addAttribute("cliente", cliente);
        return "/paginas/alteraSenha";

    }

    @GetMapping("adicionar-endereco")
    public String adicionarnd(){

        return "paginas/novoEndereco";
    }

    @GetMapping("/atualizar/{id_usuario}/enderecos/{id_endereco}")
    private String atualizarEndereco(Model m, @PathVariable("id_usuario") Integer idUsuario, @PathVariable("id_endereco") Integer idEndereco){
        IEnderecoDTO end = clienteService.buscaEnderecoPeloId(idUsuario, idEndereco);
        m.addAttribute("end", end);
        return "paginas/editEndereco";
    }

    //rever a rota de add endereço
    @PostMapping("/adicionar-endereco/{id}/endereco")
    public String endRegister( @PathVariable Integer id,  @ModelAttribute EnderecoSalvarDTO e){
        Endereco res = clienteService.criaNovoEndereco(e);

        return "redirect:/adicionar-endereco";
    }


    @GetMapping("excluir/{id_cliente}/enderecos/{id_endereco}")
    private String excluirEnderecoPeloCliente(@PathVariable("id_cliente")Integer idCliente, @PathVariable("id_endereco") Integer idEndereco){
        clienteService.excluirEnderecoPeloCliente( idEndereco);
        return "redirect:/area-cliente/"+ idCliente;
    }







}
