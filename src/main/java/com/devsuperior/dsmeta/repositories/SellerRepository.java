package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Seller;
import com.devsuperior.dsmeta.projections.SellerSumProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Long> {

    @Query(nativeQuery = true, value = "SELECT seller.name, SUM(sales.amount) " +
            "FROM tb_seller seller " +
            "INNER JOIN tb_sales sales ON sales.seller_id = seller.id " +
            "WHERE sales.date >= :dtInicio and sales.date <= :dtFinal " +
            "GROUP BY seller.name")
    List<SellerSumProjection> search(Date dtInicio, Date dtFinal);
}
