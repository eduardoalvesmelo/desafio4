package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SellerSumDTO;
import com.devsuperior.dsmeta.projections.SellerSumProjection;
import com.devsuperior.dsmeta.repositories.SellerRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SellerService {

    SellerRepository repository;

    @Transactional(readOnly = true)
    public List<SellerSumDTO> findAll(@RequestParam Date dtInicio, Date dtFinal) {
        List<SellerSumProjection> list = repository.search(dtInicio,dtFinal);
        List<SellerSumDTO> result = list.stream().map(x -> new SellerSumDTO(x)).collect(Collectors.toList());
        return result;
    }
}
