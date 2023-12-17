package com.devsuperior.dsmeta.dto;

public class ValidacoesEntradaDTO {

    private String minDate;
    private String maxDate;
    private String name;

    public ValidacoesEntradaDTO() { }

    public ValidacoesEntradaDTO(String minDate, String maxDate, String name) {
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.name = name;
    }

    public String getMinDate() {
        return minDate;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public String getName() {
        return name;
    }

    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public void setName(String name) {
        this.name = name;
    }
}
