package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.model.Marca;
import br.com.araujo.xmarket.model.Produto;
import br.com.araujo.xmarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TaskController {

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


    @GetMapping("/index")
    public ModelAndView home() {
        Iterable<Produto> produtos = service.recuperarTodos();
        ModelAndView mv = new ModelAndView("index");
        Iterable<Marca> marcas = serviceMarcas.buscarTodos();
        mv.addObject("produtos", produtos);
        mv.addObject("marcas", marcas);
        return mv;
    }

    @GetMapping("/carrinho")
    public ModelAndView carrinho() {
//        Cliente cliente = serviceCliente.buscarPeloId(1);
        Iterable<CarrinhoCompra> carrinhos = serviceCarrinho.buscarTodas();
        ModelAndView mv = new ModelAndView("paginas/carrinho");
        mv.addObject("carrinhos", carrinhos);
        return mv;
    }

    @GetMapping("/cadastroProduto")
    public ModelAndView cadastroMarca() {

        ModelAndView mv = new ModelAndView("paginas/cadastro");
        Iterable<Marca> marcas = serviceMarcas.buscarTodos();

        mv.addObject("marcas", marcas);
        System.out.println("----------------------------------------------------");
        System.out.println(marcas);
        return mv;
    }


    @GetMapping("/login")
    public String login() {
        return "paginas/login";
    }

    @GetMapping("/marca")
    public String cadastro() {

        return "paginas/marca";
    }


//    @GetMapping("/carrinho")
//    public String carrinho() {
//
//        return "paginas/carrinho";
//    }

    @GetMapping("/cadastro")
    public String cadastroUsuario() {
        return "paginas/cadastro";
    }


    @GetMapping("/admin")
    public String admin() {
        return "paginas/administrativa";
    }

}