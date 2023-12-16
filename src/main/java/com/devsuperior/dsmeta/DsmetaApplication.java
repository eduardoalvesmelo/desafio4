package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.dto.SellerSumDTO;
import com.devsuperior.dsmeta.projections.SellerSumProjection;
import com.devsuperior.dsmeta.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DsmetaApplication implements CommandLineRunner {

	@Autowired
	private SellerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		List<SellerSumProjection> list = repository.search("2022-01-01","2022-06-30");
		List<SellerSumDTO> result = list.stream().map(SellerSumDTO::new).toList();

		System.out.println("\n***RESULTADO SQL RAIZ:");
		for (SellerSumDTO obj : result) {
			System.out.println(obj);
		}
		System.out.println("\n\n");


	}
}
