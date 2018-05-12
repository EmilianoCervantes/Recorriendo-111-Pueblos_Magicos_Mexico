package com.example.restapi;

import com.example.restapi.repository.PuebloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

	private PuebloRepository puebloRepository;

	@Autowired
	public void productRepository(PuebloRepository puebloRepository) {
		this.puebloRepository = puebloRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		/*
		Pueblo testProduct = new Pueblo();
		testProduct.setNombre("Patzcuaro");
		testProduct.setDescripcion("Pueblo Mégico Hermoso");
		testProduct.setEstado("Michoacán");
		productRepository.save(testProduct);*/

	}
}
