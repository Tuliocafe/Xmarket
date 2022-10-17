package br.com.araujo.xmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TaskController {


    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "paginas/login";
    }

    @GetMapping("/cadastro")
    public String cadastro(){
       return "paginas/cadastro";
    }

    @GetMapping("/marca")
    public String marca(){
        return "paginas/marca";
    }

    @GetMapping("/form")
    public String form(){
        return "paginas/form";
    }


}
