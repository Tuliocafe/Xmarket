package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.ProdutoDao;
import br.com.araujo.xmarket.dao.VendaDao;
import br.com.araujo.xmarket.dto.ItemDTO;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Produto;
import br.com.araujo.xmarket.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class VendaServiceImpl implements IVendaService {
    @Autowired
    public VendaDao vendaDao;

    @Autowired
    ProdutoDao produtoDao;

    @Override
    public Venda criaNova(Venda novo) {
        if(novo.getPrecoTotal() != null)
        {
            return vendaDao.save(novo);
        }
        return null;
    }

    @Override
    public Venda atualizarDados(Venda dados) {
        if(dados.getId()!=null ){
            return vendaDao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Venda> buscarTodas() {
        return (ArrayList<Venda>) vendaDao.findAll();
    }

    @Override
    public Venda buscarPeloId(Integer id) {
        return vendaDao.findById(id).orElse(null);
    }

    @Override
    public void excluirVenda(Integer id) {
        vendaDao.deleteById(id);
    }

    @Override
    public CarrinhoCompra incluirItemNaVenda(ItemDTO itemDto) {


        Venda venda = buscarPeloId(itemDto.getIdVenda());

        if (venda.getStatusVendas().getStatus().name().equals("finalizada") ||
                venda.getStatusVendas().getStatus().name().equals("cancelada")
        ){
            throw new RuntimeException("O pedido está fechado");
        }


       Produto produto =  produtoDao.findById(itemDto.getIdProduto()).orElseThrow(
                () -> {
                    throw new RuntimeException("Esse Produto não existe");
                });

        // usando padrão builder do lombok
        CarrinhoCompra novoItem = CarrinhoCompra.builder()
                .quantidade(itemDto.getQuantidade())
                .desconto(itemDto.getDesconto())
                .precoUnitario(produto.getPreco_produto())
                .venda(venda)
                .produto(produto)
                .build();

        venda.getListaItensCarrinho().add(novoItem);
        vendaDao.save(venda);
        return novoItem;

    }
}
