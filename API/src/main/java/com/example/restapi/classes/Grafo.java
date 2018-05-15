package com.example.restapi.classes;

import java.util.List;

import com.example.restapi.model.Adjunto;
import com.example.restapi.model.Pueblo;

public class Grafo {
	private final List<Pueblo> pueblos;
	private final List<Adjunto> adjuntos;
	
	public Grafo(List<Pueblo> pueblos, List<Adjunto> adjuntos) {
		super();
		this.pueblos = pueblos;
		this.adjuntos = adjuntos;
	}
	
	public List<Pueblo> getPueblos() {
        return pueblos;
    }

    public List<Adjunto> getAdjuntos() {
        return adjuntos;
    }
    
}
