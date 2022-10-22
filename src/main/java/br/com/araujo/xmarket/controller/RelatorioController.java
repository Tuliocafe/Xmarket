package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.dto.IRelatorioVendaDTO;
import br.com.araujo.xmarket.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelatorioController {
    @Autowired
    private IVendaService serviceRelatorioVendaDTO;

    @GetMapping("/relatorioPorData/{data1}/{data2}")
    public List<IRelatorioVendaDTO> buscarPorData(@PathVariable String data1, @PathVariable String data2){
        List<IRelatorioVendaDTO> res = serviceRelatorioVendaDTO.buscarPorData(data1, data2);
        return res;
    }
}
