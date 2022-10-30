package br.com.araujo.xmarket.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.araujo.xmarket.dao.VendaDao;
import br.com.araujo.xmarket.service.JasperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class JasperController {

    @Autowired
    private JasperService service;

    @Autowired
    private VendaDao vendaDao;

    @GetMapping("/admin/pdf/jr1")
    public void exibirRelatorio01(@RequestParam("code") String code, @RequestParam("acao") String acao,
                                  HttpServletResponse response) throws IOException { //resposta em relaçao a nossa requisição, não retornando nada

        byte[] bytes = service.exportarPDF(code);  // meu relatorio sera transformado em uma array e sera retornado para bytes

        response.setContentType(MediaType.APPLICATION_PDF_VALUE); //vai receber o tipo de midia, nesse caso o PDF
        if(acao.equals("v")) {
            //inline:fala com navegador que o pdf será aberto por ele,senão o navegador não for compativel será feito  download

            response.setHeader("Content-disposition","attachment;filename=relatorio-"+code+".pdf");
        }
        else {
            //attachment: fala para o navegador que não deseja abrir o relatorio, mas quer salvar em algum diretorio
            response.setHeader("Content-disposition","attachment;filename=relatorio-"+code+".pdf");
        }
        response.getOutputStream().write(bytes);
    }

    @GetMapping("/admin/pdf/jr2/{code}")
    public void exibirRelatorio02(@PathVariable("code") String code,     //pathvariable recebe o parametro a partir da url
                                  @RequestParam(name="data_inicio",required =false) Date data_inicio,    //coloco required false, porque não é obrigatório para fazer busca no 09
                                  @RequestParam(name="data_final",required =false) Date data_final,
                                  HttpServletResponse response) throws IOException { //resposta em relaçao a nossa requisição, não retornando nada

        service.addParams("inicio", data_inicio);  //como é string deve mandar essa condição para a string não chegar vazio
        service.addParams("fim", data_final);
        byte[] bytes = service.exportarPDF(code);  // meu relatorio sera transformado em uma array e sera retornado para bytes
        response.setHeader("Content-disposition","attachment;filename=relatorio-"+code+".pdf");
        response.setContentType(MediaType.APPLICATION_PDF_VALUE); //vai receber o tipo de midia, nesse caso o PDF
        response.getOutputStream().write(bytes);
    }


    //MEtodos responsaveis por preencher a lista
    @ModelAttribute("data_inicio")
    public List<String> getDataInicio(){
        return vendaDao.findDataInicio();
    }

    @ModelAttribute("data_final")
    public List <String> getDataFinal(){
        return vendaDao.findDataFinal();
    }

}
