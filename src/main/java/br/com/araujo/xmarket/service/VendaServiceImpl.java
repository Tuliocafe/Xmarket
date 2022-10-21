package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.ClienteDAO;
import br.com.araujo.xmarket.dao.ProdutoDao;
import br.com.araujo.xmarket.dao.StatusVendasDao;
import br.com.araujo.xmarket.dao.VendaDao;
import br.com.araujo.xmarket.dto.IRelatorioVendaDTO;
import br.com.araujo.xmarket.dto.ItemDTO;
import br.com.araujo.xmarket.dto.VendaDTO;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.model.Produto;
import br.com.araujo.xmarket.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaServiceImpl implements IVendaService {
    @Autowired
    public VendaDao vendaDao;

    @Autowired
    public ProdutoDao produtoDao;

    @Autowired
    public ClienteDAO clienteDao;

    @Autowired
    public StatusVendasDao statusVendasDao;
    @Override
    public Venda criaNova(VendaDTO novaVendaDTO) {

        Cliente cliente =  clienteDao.findById(novaVendaDTO.getIdCliente()).orElseThrow(
                () -> {
                    throw new RuntimeException("Esse usuário não existe");
                }
        );

        LocalDateTime dataAgora = LocalDateTime.now();

        Venda novaVenda = Venda.builder()
                .cliente(cliente)
                .statusVendas(    statusVendasDao.findById(novaVendaDTO.getStatusVenda()).orElseThrow(
                        () -> {
                            throw new RuntimeException("Status de venda inexistente");
                        }
                ))
                .dataVenda(dataAgora.toString())
                .build();

       return vendaDao.save(novaVenda);

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

        if(produto.getQuantidade_produto() < itemDto.getQuantidade())
        {
            throw new RuntimeException("Quantidade em estoque insuficiente");

        }

        produto.setQuantidade_produto(produto.getQuantidade_produto() - itemDto.getQuantidade());

        produtoDao.save(produto);

        // usando padrão builder do lombok
        Double precoTotalItem = (itemDto.getQuantidade() * produto.getPreco_produto());

        CarrinhoCompra novoItem = CarrinhoCompra.builder()
                .precoTotal(precoTotalItem)
                .quantidade(itemDto.getQuantidade())
                .precoUnitario(produto.getPreco_produto())
                .venda(venda)
                .produto(produto)
                .build();

        venda.getListaItensCarrinho().add(novoItem);
        vendaDao.save(venda);
        return novoItem;

    }

    @Override
    public List<IRelatorioVendaDTO> buscarPorData(String data1, String data2) {
        return vendaDao.findVendaByDate(data1, data2);
    }


}
