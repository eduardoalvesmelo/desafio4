package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleSumDTO;
import com.devsuperior.dsmeta.dto.SellerSumDTO;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SellerService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SellerService sellerService;

	@Autowired
	private SaleService saleService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = saleService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public Page<SaleSumDTO> searchVendas(@RequestParam(required = false) Pageable pageable, @RequestParam(required = false) String minDate, @RequestParam(required = false) String maxDate, @RequestParam(required = false) String name) {
		return saleService.searchVendas(pageable, minDate, maxDate, name);
	}

	@GetMapping(value = "/summary")
	public Page<SellerSumDTO> searchVendedor(@RequestParam(required = false) Pageable pageable, @RequestParam(required = false) String minDate, @RequestParam(required = false) String maxDate) {
        return sellerService.searchVendedor(pageable, minDate, maxDate);
	}

}
