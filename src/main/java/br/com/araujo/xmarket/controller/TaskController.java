package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.model.Produto;
import br.com.araujo.xmarket.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class TaskController {

    @Autowired
    private IProdutoService service;
    @GetMapping("/index")
    public ModelAndView home() {
        Iterable<Produto> produtos = service.recuperarTodos();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("produtos",produtos);
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

}
