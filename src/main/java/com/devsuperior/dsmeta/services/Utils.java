package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.ValidacoesEntradaDTO;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class Utils {

    public static ValidacoesEntradaDTO validacoesEntrada(ValidacoesEntradaDTO validacoesEntradaDTO, String minDate, String maxDate) {

        if (minDate == "") {
            LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
            LocalDate result = today.minusYears(1L);
            validacoesEntradaDTO.setMinDate(result.toString());
        }

        if (maxDate == "") {
            LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
            validacoesEntradaDTO.setMaxDate(today.toString());
        }

        return validacoesEntradaDTO;
    }

}
