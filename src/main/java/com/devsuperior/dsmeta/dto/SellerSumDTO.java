package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SellerSumProjection;

public class SellerSumDTO {

    private String name;
    private Long sum;

    public SellerSumDTO() { }

    public SellerSumDTO(String name, Long sum) {
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

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
}
