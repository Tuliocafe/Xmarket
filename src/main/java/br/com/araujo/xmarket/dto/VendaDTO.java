package br.com.araujo.xmarket.dto;

public class VendaDTO {

private Integer idCliente;
private Integer statusVenda;


    public Integer getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(Integer statusVenda) {
        this.statusVenda = statusVenda;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public VendaDTO(Integer idCliente, Integer statusVenda) {
        this.idCliente = idCliente;
        this.statusVenda = statusVenda;
    }

    public VendaDTO() {
    }
}
