package com.example.restapi.classes;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.restapi.model.Adjunto;
import com.example.restapi.model.Pueblo;
import com.example.restapi.repository.AdjuntoRepository;

public class Resultado {
	private float distanciaAcumulada;
	private LinkedList<Pueblo> camino;
	
	@Transient
	private AdjuntoRepository adjuntoRepository;
	
	@Autowired
    public void setAdjuntoRepository(AdjuntoRepository adjuntoRepository) {
        this.adjuntoRepository = adjuntoRepository;
    }
	
	public LinkedList<Pueblo> getCamino() {
		return camino;
	}
	public void setCamino(LinkedList<Pueblo> camino) {
		this.camino = camino;
	}
	public float getDistanciaAcumulada() {
		return distanciaAcumulada;
	}
	public void setDistanciaAcumulada(float distanciaAcumulada) {
		this.distanciaAcumulada = distanciaAcumulada;
	}
	public void calcularDistanciaAcumulada(List<Adjunto> adjuntos) {
		float f = 0;
		//ArrayList<Adjunto> conexiones = new ArrayList<>(adjuntos);
		for(int i = 0; i < camino.size()-1; i++) {
			Pueblo pueblo = camino.get(i);
			Pueblo pueblo2 = camino.get(i+1);
			for(int j = 0; j < adjuntos.size(); j++) {
				if(adjuntos.get(j).getPueblo_id_1().equals(pueblo.getId()) && adjuntos.get(j).getPueblo_id_2().equals(pueblo2.getId())) {
					f = f + Float.parseFloat(adjuntos.get(j).getDistancia());
					break;
				}
			}
		}
		
		distanciaAcumulada = f;
	}
}
