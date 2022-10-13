package br.com.araujo.xmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status_vendas")
public class StatusVendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status_vendas")
    private Integer id;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "statusVendas", cascade = CascadeType.ALL)
    @JsonIgnoreProperties
    List<Venda> listaVendas;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Venda> getListaVendas() {
        return listaVendas;
    }

    public void setListaVendas(List<Venda> listaVendas) {
        this.listaVendas = listaVendas;
    }
}
