package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SellerSumProjection;

public class SellerSumDTO {

    private String name;
    private Double sum;

    public SellerSumDTO() { }

    public SellerSumDTO(String name, Double sum) {
        this.name = name;
        this.sum = sum;
    }

    public SellerSumDTO(SellerSumProjection projection) {
        name = projection.getName();
        sum = projection.getSum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "SellerSumDTO{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
