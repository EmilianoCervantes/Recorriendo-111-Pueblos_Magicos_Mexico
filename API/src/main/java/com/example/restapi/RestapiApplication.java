package com.example.restapi;

import com.example.restapi.model.Pueblo;
import com.example.restapi.repository.PuebloRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		
		FileReader fileReader;
		BufferedReader reader;
		try {
			fileReader = new FileReader("pueblosmagicos.csv");
			reader = new BufferedReader(fileReader);
			String line = null;
			int index = 1;
			while((line = reader.readLine()) != null) {
				String [] datos = line.split(",");
				Pueblo pueblo = new Pueblo();
				pueblo.setId(index + "");
				pueblo.setNombre(datos[1]);
				pueblo.setEstado(datos[0]);
				pueblo.setDescripcion("Sin Descripcion");
				puebloRepository.save(pueblo);
				//System.out.println(datos[0] + " " + datos[1]);
				index++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
