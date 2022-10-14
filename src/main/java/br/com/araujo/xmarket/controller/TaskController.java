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

    @GetMapping("/marca")
    public String cadastro(){
       return "paginas/marca";
    }

}
