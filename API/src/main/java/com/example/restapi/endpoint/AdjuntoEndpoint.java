package com.example.restapi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Adjunto;
import com.example.restapi.service.AdjuntoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/adjuntos/")
@Api(value = "AdjuntosEndpointAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdjuntoEndpoint implements AdjuntoInterface {
	private AdjuntoService adjuntoService;
	
	@Autowired
    public void setAdjuntoService(AdjuntoService adjuntoService) {
		this.adjuntoService = adjuntoService;
	}
	
	@Override
	public Adjunto getAdjunto(Long id) {
        return adjuntoService.getAdjunto(id);
	}
	
	@Override
	public List<Adjunto> getAllAdjuntos() {
        return adjuntoService.getAllAdjuntos();
	}
	
	@Override
	public Adjunto saveAdjunto(Adjunto adjuntoToSave) {
		return adjuntoService.saveAdjunto(adjuntoToSave);
	}
	
	@Override
	public Adjunto updateAdjunto(Adjunto adjuntoToUpdate, String id) {
		return adjuntoService.updateAdjunto(adjuntoToUpdate, id);
	}
	
	@Override
    public void deleteAdjunto(String id) {
		adjuntoService.deleteAdjunto(id);
	}
	
}
