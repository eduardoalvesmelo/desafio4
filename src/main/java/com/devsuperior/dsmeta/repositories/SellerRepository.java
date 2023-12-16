package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Seller;
import com.devsuperior.dsmeta.projections.SellerSumProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SellerRepository extends JpaRepository<Seller,Long> {

    @Query(nativeQuery = true, value = "SELECT tb_seller.name, SUM(tb_sales.amount) AS Sum "+
            "FROM tb_seller "+
            "INNER JOIN tb_sales ON tb_sales.seller_id = tb_seller.id "+
            "WHERE tb_sales.date >= :dtInicio and tb_sales.date <= :dtFinal "+
            "GROUP BY tb_seller.name")
    List<SellerSumProjection> search(String dtInicio, String dtFinal);
}
