package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.ItemDTO;
import br.com.araujo.xmarket.model.*;
import br.com.araujo.xmarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;


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



    @GetMapping("/index")
    public ModelAndView home() {
        Iterable<Produto> produtos = service.recuperarTodos();
        ModelAndView mv = new ModelAndView("index");
        Iterable<Marca> marcas = serviceMarcas.buscarTodos();
        mv.addObject("produtos", produtos);
        mv.addObject("marcas", marcas);
        return mv;
    }

    @GetMapping("/form")
    public ModelAndView clientes(){
        ModelAndView mv = new ModelAndView("paginas/form");
        Cliente clientes = clienteServiceImpl.buscarPeloId(210);
        mv.addObject("clientes", clientes);
        return mv;
    }



    @GetMapping("/carrinho")
    public ModelAndView carrinho(){
//        Cliente cliente = serviceCliente.buscarPeloId(1);
        Venda vendas = serviceVenda.buscarPeloId(13);
//        Iterable<CarrinhoCompra> carrinhos = serviceCarrinho.buscarTodas();
        ModelAndView mv = new ModelAndView("paginas/carrinho");
        mv.addObject("vendas",vendas );
//        mv.addObject("carrinhos",carrinhos );
        return mv;}


    @GetMapping("/login")
    public String login() {
        return "paginas/login";
    }

    @GetMapping("/marca")
    public String cadastro() {

        return "paginas/marca";
    }

    @GetMapping("/cadastro")
    public String cadastroUsuario() {
        return "paginas/cadastro";
    }


    @GetMapping("/admin")
    public String admin() {
        return "paginas/administrativa";
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
