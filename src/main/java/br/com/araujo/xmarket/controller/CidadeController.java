package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.ApiMessage;
import br.com.araujo.xmarket.model.Cidade;
import br.com.araujo.xmarket.service.CidadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CidadeController {

    @Autowired
    CidadeServiceImpl cidadeService;

    @GetMapping("/cidades")
    public ResponseEntity<?> recuperaTodos(){
        ArrayList<Cidade> todasCidades = cidadeService.buscarTodas();
        if(todasCidades == null){
            return new ResponseEntity<>(new ApiMessage("Não existe cidade cadastrada"), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(todasCidades, HttpStatus.OK);
    }

}
