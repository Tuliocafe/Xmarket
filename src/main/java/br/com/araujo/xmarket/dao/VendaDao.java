package br.com.araujo.xmarket.dao;

import br.com.araujo.xmarket.dto.IRelatorioVendaDTO;
import br.com.araujo.xmarket.model.Venda;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface VendaDao extends CrudRepository <Venda, Integer> {
    @Query(value = """
            select v.id_venda, v.data_venda, v.preco_total_vendas, u.nome_usuario, s.status 
            from venda as v 
            inner join usuario_cadastro as u  on v.id_usuario = u.id_usuario
            inner join status_vendas as s on v.id_status_vendas = s.id_status_vendas
            where v.data_venda between :date1 and  :date2""", nativeQuery = true)
    List<IRelatorioVendaDTO> findVendaByDate(@Param("date1") String date1, @Param("date2") String date2);


    @Query(value = """
                select *
                from venda
                where id_usuario = :id and id_status_vendas = 2 order by id_venda desc limit 1""", nativeQuery = true)
    ArrayList<Venda> buscarPeloIdUsuario(@Param("id") Integer id);

    @Query(value = """
                select *
                from venda
                where id_usuario = :id""", nativeQuery = true)
    ArrayList<Venda> buscarTudoPeloIdUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value ="select v.data_venda from venda v", nativeQuery = true)
    List<String> findDataInicio();

    @Modifying
    @Transactional
    @Query(value ="select v.data_venda from venda v", nativeQuery = true)
    List<String> findDataFinal();
}