package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.projections.SaleSumProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true, value = "SELECT TB_SELLER.NAME AS nomeVendedor, TB_SALES.ID AS id, TB_SALES.DATE AS date, SUM(TB_SALES.AMOUNT) AS Sum " +
                                       "FROM TB_SELLER "+
                                       "INNER JOIN TB_SALES ON TB_SELLER.ID = TB_SALES.SELLER_ID "+
                                       "WHERE TB_SELLER.NAME LIKE CONCAT('%',:name, '%') AND TB_SALES.DATE BETWEEN :minDate AND :maxDate "+
                                       "GROUP BY nomeVendedor, id, date")
    Page<SaleSumProjection> searchVendas(Pageable pageable, String minDate, String maxDate, String name);
}
