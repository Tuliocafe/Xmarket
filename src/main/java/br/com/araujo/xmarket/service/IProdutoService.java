package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dto.IHistoricoPrecoProdutoDTO;
import br.com.araujo.xmarket.dto.ProdutoDTO;
import br.com.araujo.xmarket.model.Produto;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface IProdutoService {

    public ArrayList<Produto> recuperarTodos();
    public Produto recuperarProdutoId(Integer id);
    public Produto cadastrarNovo(ProdutoDTO novo);

    public ArrayList<Produto> recuperaTodosPorNome(String nome);

    public void excluirProduto(Integer id);

    public Produto atualizaProduto(Produto novo, Integer idAntigo);

    public ArrayList<IHistoricoPrecoProdutoDTO> buscaHistoricoPorPreco(Integer id);


}
