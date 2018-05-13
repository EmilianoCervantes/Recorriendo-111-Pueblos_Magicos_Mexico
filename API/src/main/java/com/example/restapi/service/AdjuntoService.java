package com.example.restapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Adjunto;
import com.example.restapi.repository.AdjuntoRepository;

@Service
public class AdjuntoService {
	private Logger LOG = LoggerFactory.getLogger(AdjuntoService.class);
	private AdjuntoRepository adjuntoRepository;
	
	@Autowired
    public void setAdjuntoRepository(AdjuntoRepository adjuntoRepository) {
		this.adjuntoRepository = adjuntoRepository;
	}
	
	public Adjunto getAdjunto(long id) {
		LOG.info("Getting the adjunto with given id:" + id);
		return adjuntoRepository.findOne(id + "");
	}
	
	public List<Adjunto> getAllAdjuntos(){
		LOG.info("Getting all adjuntos in the DB");
		return adjuntoRepository.findAll();
	}
	
	public Adjunto saveAdjunto(Adjunto adjunto) {
		Adjunto adjuntoToSave;
		try {
			LOG.info("Sabing adjunto...");
			adjuntoToSave = adjuntoRepository.save(adjunto);
			return adjuntoToSave;
		} catch (Exception e) {
			LOG.error("An error ocurred during adjunto saving:" + e.getMessage());
		}
		return new Adjunto();
	}
	
	public Adjunto updateAdjunto(Adjunto adjuntoToUpdate, String id) {
		Adjunto foundAdjunto = adjuntoRepository.findOne(id);
		try {
			foundAdjunto.setDistancia(adjuntoToUpdate.getDistancia());
			foundAdjunto.setPueblo_id_1(adjuntoToUpdate.getPueblo_id_1());
			foundAdjunto.setPueblo_id_2(adjuntoToUpdate.getPueblo_id_2());
			return adjuntoRepository.save(foundAdjunto);
		} catch (Exception e) {
			LOG.error("An error occurred during update of adjunto" + e.getMessage());
		}
		return adjuntoToUpdate;
	}
	
	public void deleteAdjunto(String id) {
		try {
			adjuntoRepository.delete(id);
		} catch (Exception e) {
			LOG.error("An error occurred during deleting of adjunto:" + e.getMessage());
		}
	}

}
