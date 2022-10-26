package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.CidadeDao;
import br.com.araujo.xmarket.dao.ClienteDAO;
import br.com.araujo.xmarket.dao.EnderecoDAO;
import br.com.araujo.xmarket.dto.ClienteDTO;
import br.com.araujo.xmarket.dto.EnderecoSalvarDTO;
import br.com.araujo.xmarket.dto.IEnderecoDTO;
import br.com.araujo.xmarket.dto.LoginDTO;
import br.com.araujo.xmarket.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

@Service
@Primary
public class ClienteServiceImpl implements IClienteService {


    @Autowired
    EnderecoDAO enderecoDAO;

    @Autowired
    public CidadeDao cidadeDao;

    @Autowired
    public ClienteDAO clienteDao;


    @Override
    public Cliente criaNovo(ClienteDTO cliente) {

        if (cliente != null ) {


            Cliente novoCliente = Cliente.builder()
            .nome(cliente.getNome())
            .cpf(cliente.getCpf())
            .sobrenome(cliente.getSobrenome())
            .dataNascimento(cliente.getDataNascimento())
            .telefoneUm(cliente.getTelefoneUm())
            .telefoneDois(cliente.getTelefoneDois())
            .rg(cliente.getRg())
            .dataCriacaoUsuario(cliente.getDataCriacaoUsuario())
            .email(cliente.getEmail())
            .senha(cliente.getSenha())
            .build();

            clienteDao.save(novoCliente);
            return novoCliente;
        }
        return null;
    }

    @Override
    public Cliente atualizarDados(Cliente cliente) {
        if (cliente.getId() != null && cliente.getNome() != null) {
            return clienteDao.save(cliente);
        }
        return cliente;
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


            clienteDao.save(novoCliente);

            return novoCliente;
        }
        return null;
    }



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

    @Override
    public Cliente logar(LoginDTO loginUsuario) {

       Cliente cliente =  clienteDao.getByEmail(loginUsuario.getEmail());

       if (cliente == null)
       {
           return null;
       }

      if (Objects.equals(cliente.getSenha(), loginUsuario.getSenha())) {
            return cliente;
        }

        return null;
    }


    @Override
    public boolean verificaEmail(String email) {
        return clienteDao.existsByEmail(email);
    }

    @Override
    public Endereco criaNovoEndereco(EnderecoSalvarDTO endereco) {

        Cidade cidade = cidadeDao.findById(endereco.getCidade()).orElse(null);

        Cliente cliente = clienteDao.findById(endereco.getIdUsuario()).orElse(null);

        if (cidade == null) {return null;}
        if(cliente == null) {return null;}


        Endereco novoEndereco = Endereco.builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .cep(endereco.getCep())
                .bairro(endereco.getBairro())
                .complemento(endereco.getComplemento())
                .referencia(endereco.getReferencia())
                .tipoEndereco(endereco.getTipo())
                .cidade(cidade)
                .cliente(cliente)
                .build();

       enderecoDAO.save(novoEndereco);

        return novoEndereco;

    }
    @Override
    public String toString() {
        return super.toString();
    }


}
