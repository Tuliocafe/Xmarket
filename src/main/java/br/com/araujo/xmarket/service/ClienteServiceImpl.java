package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.ClienteDAO;
import br.com.araujo.xmarket.dao.EnderecoDAO;
import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.model.Cliente;
import br.com.araujo.xmarket.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Primary
public class ClienteServiceImpl implements IClienteService {



    @Autowired
    public ClienteDAO clienteDao;

    @Autowired
    EnderecoDAO enderecoDAO;

    @Override
    public Cliente criaNovo(Cliente cliente) {
        if (cliente != null ) {
            LocalDateTime data = LocalDateTime.now();
            cliente.setStatus(1);
            System.out.println(data);
            cliente.setDataCriacaoUsuario(data.toString());
            return clienteDao.save(cliente);
        }
        return null;
    }

    @Override
    public Cliente atualizarDados(Cliente cliente) {
        if (cliente.getId() != null && cliente.getNome() != null) {
            return clienteDao.save(cliente);
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> buscarTodos() {
        return (ArrayList<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente buscarPeloId(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public ArrayList<Cliente> buscaPorNome(String nome) {
        return clienteDao.findByNomeContaining(nome);
    }

    @Override
    public void excluirCliente(Integer id) {
        clienteDao.deleteById(id);
    }

    @Override
    public ArrayList<IEnderecoDTO> buscaEnderecoPeloIdCliente(Integer id) {
        return clienteDao.buscaEnderecoPeloIdCliente(id);
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente, Integer id) {

        Cliente novoCliente = clienteDao.findById(id).orElse(null);

//        if (clienteDao.existsById(id) ) ;


        if (novoCliente != null) {

            //novoCliente.cloneCliente(cliente);

            novoCliente.setNome(cliente.getNome());
            novoCliente.setCpf(cliente.getCpf());
            novoCliente.setSobrenome(cliente.getSobrenome());
            novoCliente.setDataNascimento(cliente.getDataNascimento());
            novoCliente.setTelefoneUm(cliente.getTelefoneUm());
            novoCliente.setTelefoneDois(cliente.getTelefoneDois());
            novoCliente.setRg(cliente.getRg());
            novoCliente.setDataCriacaoUsuario(cliente.getDataCriacaoUsuario());
            novoCliente.setEmail(cliente.getEmail());
            novoCliente.setSenha(cliente.getSenha());
            novoCliente.setTipoUsuario(cliente.getTipoUsuario());
            novoCliente.setStatus(cliente.getStatus());



//            novoCliente.setListaEnderecos(cliente.getListaEnderecos());
//            novoCliente.setClienteLogin(cliente.getClienteLogin());
            clienteDao.save(novoCliente);

            // TODO
            // Atualizar Enderecos Usuario
            return novoCliente;
        }
        return null;
    }


    //RECEBER UM DTO VIA ENDERECODAO
    @Override
    public Endereco atualizarEnderecoDoCliente(Endereco endereco, Integer idUsuario, Integer idEndereco) {

        Cliente novoCliente = clienteDao.findById(idUsuario).orElse(null);

        Endereco novoEndereco = enderecoDAO.findById(idEndereco).orElse(null);

        novoEndereco.setCidade(endereco.getCidade());
        novoEndereco.setCliente(novoCliente);
        novoEndereco.setBairro(endereco.getBairro());
        novoEndereco.setCep(endereco.getCep());
        novoEndereco.setTipoEndereco(endereco.getTipoEndereco());
        novoEndereco.setComplemento(endereco.getComplemento());
        novoEndereco.setLogradouro(endereco.getLogradouro());
        novoEndereco.setReferencia(endereco.getReferencia());

        if (novoEndereco != null) {

            enderecoDAO.save(novoEndereco);

            return novoEndereco;
        }

    return null;


}

    @Override
    public IEnderecoDTO buscaEnderecoPeloId(Integer idUsuario, Integer idEndereco) {
        return clienteDao.buscaEnderecoPeloId(idUsuario, idEndereco);
    }
}
