package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.model.*;
import br.com.araujo.xmarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TaskController {
    @Autowired
    ClienteServiceImpl clienteServiceImpl;
    @Autowired
    private IProdutoService service;

    @Autowired
    private IMarcaService serviceMarcas;

    @Autowired
    private IClienteService serviceCliente;

    @Autowired
    private IVendaService serviceVenda;

    @Autowired
    private ICarrinhoService serviceCarrinho;

    @Autowired
    private IProdutoService serviceProduto;


    @GetMapping("/index")
    public ModelAndView home() {
        Iterable<Produto> produtos = service.recuperarTodos();
        ModelAndView mv = new ModelAndView("../static/index");
        Iterable<Marca> marcas = serviceMarcas.buscarTodos();
        mv.addObject("produtos", produtos);
        mv.addObject("marcas", marcas);
        return mv;
    }

    @GetMapping("/area_cliente/{id}")
    public ModelAndView clientes(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView( "paginas/areaCliente");
        Cliente clientes = clienteServiceImpl.buscarPeloId(id);
        mv.addObject("clientes", clientes);
        return mv;
    }



    @GetMapping("/carrinho")
    public ModelAndView carrinho(){
        Venda vendas = serviceVenda.buscarPeloId(13);
        ModelAndView mv = new ModelAndView("paginas/carrinho");
        mv.addObject("vendas",vendas );
        return mv;}

    @GetMapping("/carrinho/{id}")
    public ModelAndView carrinhoId(@PathVariable Integer id){
        Venda vendas = serviceVenda.buscarPeloId(id);
        ModelAndView mv = new ModelAndView("paginas/carrinho");
        mv.addObject("vendas",vendas );
        return mv;}


    @GetMapping("/login")
    public String login() {
        return "../templates/paginas/login";
    }

    @GetMapping("/marca")
    public String cadastro() {

        return "paginas/marca";
    }

    @GetMapping("/novoCadastro")
    public String cadastroUsuario() {
        return "paginas/novoCadastro";
    }


    @GetMapping("/admin")
    public ModelAndView cadastroMarca() {

        ModelAndView mv = new ModelAndView("paginas/administrativa");
        Iterable<Marca> marcas = serviceMarcas.buscarTodos();

        mv.addObject("marcas", marcas);
        return mv;
    }

    @GetMapping("/paginaLogin")
    public ModelAndView paginaLogin() {
        Iterable<Produto> produtos = service.recuperarTodos();
        ModelAndView mv = new ModelAndView("paginas/cliente");
        Iterable<Marca> marcas = serviceMarcas.buscarTodos();
        mv.addObject("produtos", produtos);
        mv.addObject("marcas", marcas);
        return mv;
    }




}
