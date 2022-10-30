package br.com.araujo.xmarket.controller;

import br.com.araujo.xmarket.dto.IHistoricoPrecoProdutoDTO;
import br.com.araujo.xmarket.dto.ProdutoDTO;
import br.com.araujo.xmarket.model.Produto;
import br.com.araujo.xmarket.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
public class ProdutoController {

    private static String caminhoImagens = "/xmarket/src/main/resources/static/images/";  //como o caminho da imagem nunca muda eu coloco ela static

    @Autowired
    private IProdutoService service;



    @GetMapping("/produtos")
    public ResponseEntity<ArrayList<Produto>> recuperarTodos(){
        ArrayList<Produto> listaProduto = service.recuperarTodos();
        if(listaProduto.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(listaProduto);
    }

    @GetMapping("/produtos/{id_produto}")
    public ResponseEntity<Produto> recuperarPeloId(@PathVariable Integer id_produto){
        Produto res = service.recuperarProdutoId(id_produto);
        if (res != null) {
            return ResponseEntity.ok(res);

        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/produtos/busca/{nome_produto}")
    public ResponseEntity<ArrayList<Produto>>  pesquisaPeloNometeste(@PathVariable String nome_produto){
        ArrayList<Produto>  listProduto = service.recuperaTodosPorNome(nome_produto);
        if(listProduto.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(listProduto);
    }

    @GetMapping("/produtos/{id_produto}/historicos")
    public ResponseEntity<ArrayList<IHistoricoPrecoProdutoDTO>> recuperaHistoricoProduto(@PathVariable Integer id_produto){
    ArrayList<IHistoricoPrecoProdutoDTO> listaHistorico = service.buscaHistoricoPorPreco(id_produto);
    return  ResponseEntity.ok(listaHistorico);
    }



    @PostMapping("/produtos")
    public ResponseEntity<Produto> cadastrarNovo(@RequestBody ProdutoDTO novo){
        Produto res = service.cadastrarNovo(novo);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/produtos/{id_produto}")
    public  ResponseEntity<Produto> excluirMarca(@PathVariable Integer id_produto){
        service.excluirProduto(id_produto);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/produtos/{id_produto}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id_produto, @RequestBody ProdutoDTO novo){
        Produto atualizado = service.atualizaProduto(id_produto, novo);
        if(atualizado != null) return ResponseEntity.ok(atualizado);
        return ResponseEntity.badRequest().build();
    }


}
