package com.example.restapi.service;

import com.example.restapi.classes.AlgoritmoDijkstra;
import com.example.restapi.classes.Grafo;
import com.example.restapi.classes.Resultado;
import com.example.restapi.model.Adjunto;
import com.example.restapi.model.Pueblo;
import com.example.restapi.repository.AdjuntoRepository;
import com.example.restapi.repository.PuebloRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuebloService {

    private Logger LOG = LoggerFactory.getLogger(PuebloService.class);

    private PuebloRepository puebloRepository;
    private AdjuntoRepository adjuntoRepository;

    @Autowired
    public void setPuebloRepository(PuebloRepository puebloRepository) {
        this.puebloRepository = puebloRepository;
    }
    
    @Autowired
    public void setAdjuntoRepository(AdjuntoRepository adjuntoRepository) {
        this.adjuntoRepository = adjuntoRepository;
    }

    public Pueblo getPueblo(Long id) {
        LOG.info("Getting the pueblo with given id:" + id);
        return puebloRepository.findOne(id + "");
    }
    
    public List<Pueblo> getAllPueblos(){
    	LOG.info("Getting all the pueblos in the database");
    	return puebloRepository.findAll();
    }

    public Pueblo savePueblo(Pueblo pueblo) {
        Pueblo puebloToSave;
        try {
            LOG.info("Saving pueblo...");
            puebloToSave = puebloRepository.save(pueblo);
            return puebloToSave;
        } catch (Exception e) {
            LOG.error("An error occurred during pueblo saving:" + e.getMessage());
        }
        return new Pueblo();
    }

    public Pueblo updatePueblo(Pueblo puebloToUpdate, String id) {
    	Pueblo foundPueblo = puebloRepository.findOne(id);
        try {
            foundPueblo.setNombre(puebloToUpdate.getNombre());
            foundPueblo.setDescripcion(puebloToUpdate.getDescripcion());
            foundPueblo.setEstado(puebloToUpdate.getEstado());
            return puebloRepository.save(foundPueblo);
        } catch (Exception e) {
            LOG.error("An error occurred during update of pueblo" + e.getMessage());
        }
        return puebloToUpdate;
    }

    public void deletePueblo(String id) {
        try {
        	puebloRepository.delete(id);
        } catch (Exception e) {
            LOG.error("An error occurred during deleting of pueblo:" + e.getMessage());
        }
    }
    
    public Resultado correrDijkstra(int idOrigen, int idDestino) {
    	ArrayList<Pueblo> misPueblos = new ArrayList<Pueblo>(puebloRepository.findAll());
    	ArrayList<Adjunto> misAdjuntos = new ArrayList<Adjunto>(adjuntoRepository.findAll());
    	for(int i = 0; i < misAdjuntos.size(); i++) {
    		misAdjuntos.get(i).setOrigen(puebloRepository.findOne(misAdjuntos.get(i).getPueblo_id_1()));
    		misAdjuntos.get(i).setDestino(puebloRepository.findOne(misAdjuntos.get(i).getPueblo_id_2()));
    	}
    	Grafo grafo = new Grafo(misPueblos, misAdjuntos);
    	AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(grafo);
    	dijkstra.iniciar(misPueblos.get(idOrigen-1));
    	
    	LinkedList<Pueblo> circuito = dijkstra.obtenerCamino(misPueblos.get(idDestino-1)); //errror
    	System.out.println(circuito.size());
    	for(Pueblo pueblo: circuito) {
    		System.out.println(pueblo);
    	}
    	Resultado resultado = new Resultado();
    	resultado.setCamino(circuito);
    	resultado.calcularDistanciaAcumulada(adjuntoRepository.findAll());
    	return resultado;
     }
}
