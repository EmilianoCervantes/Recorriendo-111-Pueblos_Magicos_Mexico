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
public class AdjuntoEndpoint {
	private AdjuntoService adjuntoService;
	
	@Autowired
    public void setAdjuntoService(AdjuntoService adjuntoService) {
		this.adjuntoService = adjuntoService;
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation("Ver un adjunto con un id específico")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Adjunto.class)})
	public Adjunto getAdjunto(@PathVariable(name = "id") Long id) {
        return adjuntoService.getAdjunto(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
    @ApiOperation("Ver todos los adjuntos del sistema")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Adjunto.class)})
	public List<Adjunto> getAllAdjuntos() {
        return adjuntoService.getAllAdjuntos();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Agregar un adjunto")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Adjunto.class)})
	public Adjunto saveAdjunto(@RequestBody Adjunto adjuntoToSave) {
		return adjuntoService.saveAdjunto(adjuntoToSave);
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Modificar un adjunto")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Adjunto.class)})
	public Adjunto updateAdjunto(@RequestBody Adjunto adjuntoToUpdate, @PathVariable(name = "id") String id) {
		return adjuntoService.updateAdjunto(adjuntoToUpdate, id);
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @ApiOperation("Borrar un adjunto")
    public void deleteAdjunto(@PathVariable(name = "id") String id) {
		adjuntoService.deleteAdjunto(id);
	}
	
}
