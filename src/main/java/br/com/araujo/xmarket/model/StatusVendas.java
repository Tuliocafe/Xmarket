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
    @Enumerated(EnumType.STRING)
    private DescricaoStatus status;

    @OneToMany(mappedBy = "statusVendas", cascade = CascadeType.ALL)
    @JsonIgnoreProperties
    List<Venda> listaVendas;


    public DescricaoStatus getStatus() {
        return status;
    }

    public void setStatus(DescricaoStatus status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



//    public List<Venda> getListaVendas() {
//        return listaVendas;
//    }
//
//    public void setListaVendas(List<Venda> listaVendas) {
//        this.listaVendas = listaVendas;
//    }


}
