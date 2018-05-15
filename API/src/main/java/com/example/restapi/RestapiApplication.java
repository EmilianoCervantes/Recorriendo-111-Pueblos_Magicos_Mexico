package com.example.restapi;

import com.example.restapi.model.Adjunto;
import com.example.restapi.model.Pueblo;
import com.example.restapi.repository.AdjuntoRepository;
import com.example.restapi.repository.PuebloRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

	private PuebloRepository puebloRepository;
	private AdjuntoRepository adjuntoRepository;

	@Autowired
	public void productRepository(PuebloRepository puebloRepository) {
		this.puebloRepository = puebloRepository;
	}
	
	@Autowired
	public void adjuntonRespository(AdjuntoRepository adjuntoRepository) {
		this.adjuntoRepository = adjuntoRepository;
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
				pueblo.setAno(datos[2]);
				pueblo.setImagen(datos[3]);
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
		
		
		try {
			fileReader = new FileReader("conexiones.csv");
			reader = new BufferedReader(fileReader);
			String line = null;
			int index = 1;
			while((line = reader.readLine()) != null) {
				String [] datos = line.split(",");
				Adjunto adjunto = new Adjunto();
				adjunto.setId(index + "");
				adjunto.setPueblo_id_1(datos[0]);
				adjunto.setPueblo_id_2(datos[1]);
				adjunto.setDistancia(datos[2]);
				adjuntoRepository.save(adjunto);				
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
