package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SellerSumDTO;
import com.devsuperior.dsmeta.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	private SellerService sellerService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<?> getReport() {
		// TODO
		return null;
	}

	@GetMapping(value = "/summary")
	@ResponseBody
	public ResponseEntity<List<SellerSumDTO>> findAll(@RequestParam Date minDate, Date maxDate) {
		List<SellerSumDTO> dto = sellerService.findAll(minDate,maxDate);
		return ResponseEntity.ok(dto);
	}
}
