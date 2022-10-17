package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.Marca;
import br.com.araujo.xmarket.model.Produto;
import br.com.araujo.xmarket.service.IMarcaService;
import br.com.araujo.xmarket.service.IProdutoService;
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

    @GetMapping("/index")
    public ModelAndView home() {
        Iterable<Produto> produtos = service.recuperarTodos();
        ModelAndView mv = new ModelAndView("index");
        Iterable<Marca> marcas = serviceMarcas.buscarTodos();
        mv.addObject("produtos",produtos);
        mv.addObject("marcas", marcas);
        return mv;
    }


    @GetMapping("/login")
    public String login(){
        return "paginas/login";
    }

    @GetMapping("/marca")
    public String cadastro(){
       return "paginas/marca";
    }

    @GetMapping("/admin")
    public String admin(){return "paginas/administrativa";}

}
