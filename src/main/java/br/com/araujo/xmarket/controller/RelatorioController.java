package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.IRelatorioVendaDTO;
import br.com.araujo.xmarket.service.IVendaService;
import br.com.araujo.xmarket.service.JasperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class RelatorioController {
    @Autowired
    private IVendaService serviceRelatorioVendaDTO;

    @Autowired
    private JasperService service;

    @GetMapping("/relatorioPorData/{data1}/{data2}")
    public List<IRelatorioVendaDTO> buscarPorData(@PathVariable String data1, @PathVariable String data2){
        List<IRelatorioVendaDTO> res = serviceRelatorioVendaDTO.buscarPorData(data1, data2);

      return res;
  }




}
