package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dto.IRelatorioVendaDTO;
import br.com.araujo.xmarket.dto.ItemDTO;
import br.com.araujo.xmarket.dto.VendaDTO;
import br.com.araujo.xmarket.model.CarrinhoCompra;
import br.com.araujo.xmarket.model.Venda;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public interface IVendaService {

    public Venda criaNova (VendaDTO novo);
    public Venda atualizarDados (Venda dados);
    public ArrayList<Venda> buscarTodas();
    public Venda buscarPeloId(Integer id);
    public void excluirVenda(Integer id);
    public CarrinhoCompra incluirItemNaVenda( ItemDTO itemDto);
    public List<IRelatorioVendaDTO> buscarPorData(String data1, String data2);

    ArrayList<Venda> buscaIdUsuarioQuere(Integer id);


    boolean fecharVenda(Integer venda);

    ArrayList<Venda> buscarTudoPeloIdUsuario(Integer id);
}
