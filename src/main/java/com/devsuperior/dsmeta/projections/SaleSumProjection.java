package com.devsuperior.dsmeta.projections;

import java.util.Date;

public interface SaleSumProjection {
    String getNomeVendedor();
    Long getId();
    String getDate();
    Double getSum();
}
