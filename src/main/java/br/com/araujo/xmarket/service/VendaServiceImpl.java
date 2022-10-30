package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.ClienteDAO;
import br.com.araujo.xmarket.dao.ProdutoDao;
import br.com.araujo.xmarket.dao.StatusVendasDao;
import br.com.araujo.xmarket.dao.VendaDao;
import br.com.araujo.xmarket.dto.IRelatorioVendaDTO;
import br.com.araujo.xmarket.dto.ItemDTO;
import br.com.araujo.xmarket.dto.VendaDTO;
import br.com.araujo.xmarket.model.*;
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

        Cliente cliente = clienteDao.findById(novaVendaDTO.getIdCliente()).orElseThrow(
                () -> {
                    throw new RuntimeException("Esse usuário não existe");
                }
        );

        LocalDateTime dataAgora = LocalDateTime.now();

        Venda novaVenda = Venda.builder()
                .cliente(cliente)
                .statusVendas(statusVendasDao.findById(novaVendaDTO.getStatusVenda()).orElseThrow(
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

        LocalDateTime dataAgora = LocalDateTime.now();
        dados.setDataVenda(String.valueOf(dataAgora));
        if (dados.getId() != null) {
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
        ) {
            return null;
        }

        for (int i = 0; i < venda.getListaItensCarrinho().size(); i++) {

            if (itemDto.getIdProduto() == venda.getListaItensCarrinho().get(i).getProduto().getId_produto() )
            {
                return null;
            }

        }


        Produto produto = produtoDao.findById(itemDto.getIdProduto()).orElse(null);

        assert produto != null;
        if (produto.getQuantidade_produto() < itemDto.getQuantidade()) {
            return null;
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

    @Override
    public ArrayList<Venda> buscaIdUsuarioQuere(Integer id) {
        return vendaDao.buscarPeloIdUsuario(id);
    }

    @Override
    public ArrayList<Venda> buscarTudoPeloIdUsuario(Integer id){return vendaDao.buscarTudoPeloIdUsuario(id);}

    @Override
    public boolean fecharVenda(Integer id) {

        Venda venda = vendaDao.findById(id).orElse(null);

        if (venda.getStatusVendas().getStatus().name().equals("cancelada"))
            return false;

        assert venda != null;

        for (int i = 0; i < venda.getListaItensCarrinho().size(); i++) {

            Integer quantidadeItemCarrinho = venda.getListaItensCarrinho().get(i).getQuantidade();
            Integer idProduto = venda.getListaItensCarrinho().get(i).getProduto().getId_produto();

            Produto produto = produtoDao.findById(idProduto).orElse(null);
            assert produto != null;

            Integer novaQuantidadeProduto = venda.getListaItensCarrinho().get(i).getQuantidade() + produto.getQuantidade_produto();

            produto.setQuantidade_produto(novaQuantidadeProduto);

            produtoDao.save(produto);

        }

        //Muda o status da venda
        StatusVendas statusVendaCancelada = statusVendasDao.findById(1).orElse(null);
        venda.setStatusVendas(statusVendaCancelada);
        vendaDao.save(venda);


        return true;

    }

}
