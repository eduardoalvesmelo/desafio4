package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SaleSumProjection;

import java.time.LocalDate;
import java.util.Date;

public class SaleSumDTO {

    private Long id;
    private String data;
    private Double quantiaVendida;
    private String nomeVendedor;

    public SaleSumDTO() { }

    public SaleSumDTO(Long id, String data, Double quantiaVendida, String nomeVendedor) {
        this.id = id;
        this.data = data;
        this.quantiaVendida = quantiaVendida;
        this.nomeVendedor = nomeVendedor;
    }

    public SaleSumDTO(SaleSumProjection projection) {
        id = projection.getId();
        data = projection.getDate();
        quantiaVendida = projection.getSum();
        nomeVendedor = projection.getNomeVendedor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getQuantiaVendida() {
        return quantiaVendida;
    }

    public void setQuantiaVendida(Double quantiaVendida) {
        this.quantiaVendida = quantiaVendida;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    @Override
    public String toString() {
        return "SaleRelDTO{" +
                "id=" + id +
                ", data=" + data +
                ", quantiaVendida=" + quantiaVendida +
                ", nomeVendedor='" + nomeVendedor + '\'' +
                '}';
    }
}
