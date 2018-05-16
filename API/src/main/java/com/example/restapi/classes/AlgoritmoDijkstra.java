package com.example.restapi.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.restapi.model.Adjunto;
import com.example.restapi.model.Pueblo;

public class AlgoritmoDijkstra {
	private final List<Pueblo> pueblos;
	private final List<Adjunto> adjuntos;
	private Set<Pueblo> pueblosResueltos;
	private Set<Pueblo> pueblosInestables;
	private Map<Pueblo, Pueblo> predecesores;
	private Map<Pueblo, Float> distancia;
	
	public AlgoritmoDijkstra(Grafo grafo) {
		this.pueblos = new ArrayList<Pueblo>(grafo.getPueblos());
		this.adjuntos = new ArrayList<Adjunto>(grafo.getAdjuntos());
	}
	
	public void iniciar(Pueblo origen) {
		pueblosResueltos = new HashSet<Pueblo>();
		pueblosInestables = new HashSet<Pueblo>();
		distancia = new HashMap<Pueblo, Float>();
		predecesores = new HashMap<Pueblo, Pueblo>();
		distancia.put(origen, (float)0);
		pueblosInestables.add(origen);
		while(pueblosInestables.size() > 0) {
			Pueblo pueblo = obtenerMinimo(pueblosInestables);
			pueblosResueltos.add(pueblo);
			pueblosInestables.remove(pueblo);
			encontrarDistanciaMinima(pueblo);
		}
	}
	
	private void encontrarDistanciaMinima(Pueblo pueblo) {
		List<Pueblo> pueblosAdyacentes = obtenerVecinos(pueblo);
		for(Pueblo objetivo: pueblosAdyacentes) {
			if(obtenerDistanciaCorta(objetivo) > obtenerDistanciaCorta(pueblo) + obtenerDistancia(pueblo, objetivo)) {
				distancia.put(objetivo, obtenerDistanciaCorta(pueblo) + obtenerDistancia(pueblo, objetivo));
				predecesores.put(objetivo, pueblo);
				pueblosInestables.add(objetivo);
			}
		}
	}
	
	private float obtenerDistancia(Pueblo pueblo, Pueblo destino) {
		for(Adjunto adjunto : adjuntos) {
			if(adjunto.getOrigen().equals(pueblo) && adjunto.getDestino().equals(destino)) {
				return Float.parseFloat(adjunto.getDistancia());
			}
		}
		throw new RuntimeException("Should not happen");
	}
	
	private List<Pueblo> obtenerVecinos(Pueblo pueblo){
		List<Pueblo> vecinos = new ArrayList<Pueblo>();
		for(Adjunto adjunto : adjuntos) {
			if(adjunto.getOrigen().equals(pueblo) && !estaResuelto(adjunto.getDestino())) {
				vecinos.add(adjunto.getDestino());
			}
		}
		//System.out.println("Tengo " + vecinos.size() + " vecinos y soy " + pueblo.getId());
		return vecinos;
	}
	
	private Pueblo obtenerMinimo(Set<Pueblo> pueblos) {
		Pueblo minimo = null;
		for(Pueblo pueblo : pueblos) {
			if(minimo == null) {
				minimo = pueblo;
			}else {
				if(obtenerDistanciaCorta(pueblo) < obtenerDistanciaCorta(minimo)) {
					minimo = pueblo;
				}
			}
		}
		return minimo;
	}
	
	private boolean estaResuelto(Pueblo pueblo) {
		return pueblosResueltos.contains(pueblo);
	}
	
	private float obtenerDistanciaCorta(Pueblo destino) {		
		if(distancia.get(destino) == null) {
			return Float.MAX_VALUE;
		}else {
			return distancia.get(destino);
		}
	}
	
	public LinkedList<Pueblo> obtenerCamino(Pueblo destino){
		LinkedList<Pueblo> circuito = new LinkedList<Pueblo>();
		Pueblo camino = destino;
		if(predecesores.get(camino) == null) {
			return null;
		}
		circuito.add(camino);
		while(predecesores.get(camino) != null) {
			camino = predecesores.get(camino);
			circuito.add(camino);
		}
		Collections.reverse(circuito);
		return circuito;
	}
}
