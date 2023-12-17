package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SellerSumDTO;
import com.devsuperior.dsmeta.dto.ValidacoesEntradaDTO;
import com.devsuperior.dsmeta.projections.SellerSumProjection;
import com.devsuperior.dsmeta.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SellerService {

    @Autowired
    SellerRepository repository;

    public Page<SellerSumDTO> searchVendedor(Pageable pageable, String minDate, String maxDate) {

        if (minDate == null) {
            LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
            LocalDate result = today.minusYears(1L);
            minDate = result.toString();
        }

        if (maxDate == null) {
            LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
            maxDate = today.toString();
        }

        Page<SellerSumProjection> list = repository.searchVendedor(pageable, minDate, maxDate);
        return list.map(x-> new SellerSumDTO(x));
    }
}
