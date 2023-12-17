package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.dto.SaleSumDTO;
import com.devsuperior.dsmeta.dto.SellerSumDTO;
import com.devsuperior.dsmeta.projections.SaleSumProjection;
import com.devsuperior.dsmeta.projections.SellerSumProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.devsuperior.dsmeta.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class DsmetaApplication implements CommandLineRunner {

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private SaleRepository saleRepository;

	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Pageable pageable = PageRequest.of(0, 5);
//		Page<SellerSumProjection> list1 = sellerRepository.searchVendedor(pageable,"2022-01-01","2022-06-30");
//		Page<SellerSumDTO> result1 = list1.map(x -> new SellerSumDTO(x));
//
//		System.out.println("\n***RESULTADO SQL RAIZ:");
//		for (SellerSumDTO obj1 : result1) {
//			System.out.println(obj1);
//		}
//		System.out.println("\n\n");
//
//		Pageable pageable1 = PageRequest.of(0, 50);
//		Page<SaleSumProjection> list = saleRepository.searchVendas(pageable1, "2022-05-01", "2022-05-31", "Odinson");
//		Page<SaleSumDTO> result = list.map(x-> new SaleSumDTO(x));
//
//		System.out.println("\n***RESULTADO SQL RAIZ:");
//		for (SaleSumDTO obj : result) {
//			System.out.println(obj);
//		}
//		System.out.println("\n\n");
	}
}
