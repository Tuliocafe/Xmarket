package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.dto.IHistoricoPrecoProdutoDTO;
import br.com.araujo.xmarket.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ProdutoDao extends CrudRepository<Produto, Integer> {

    public ArrayList<Produto> findByNomeContaining(String palavraPesquisada);

    @Query(value = """
            select id_historico_preco, preco_antigo, preco_novo, data_alteracao, Produto_id_produto, produto.nome_produto as produto
            from historico_preco
            inner join produto on (historico_preco.Produto_id_produto = produto.id_produto)
            where Produto_id_produto = :id""", nativeQuery = true)
    ArrayList<IHistoricoPrecoProdutoDTO> buscaHistoricoPorPreco(@Param("id") Integer id);
}
