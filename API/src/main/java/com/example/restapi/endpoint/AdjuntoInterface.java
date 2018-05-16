package com.example.restapi.endpoint;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.restapi.model.Adjunto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@FeignClient(value = "account-service2", fallback = AdjuntoEndpoint.class)
public interface AdjuntoInterface {
	
	@RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation("Ver un adjunto con un id específico")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Adjunto.class)})
	public Adjunto getAdjunto(@PathVariable(name = "id") Long id);
	
	@RequestMapping(method = RequestMethod.GET)
    @ApiOperation("Ver todos los adjuntos del sistema")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Adjunto.class)})
	public List<Adjunto> getAllAdjuntos();
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Agregar un adjunto")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Adjunto.class)})
	public Adjunto saveAdjunto(@RequestBody Adjunto adjuntoToSave);
	
	@RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Modificar un adjunto")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Adjunto.class)})
	public Adjunto updateAdjunto(@RequestBody Adjunto adjuntoToUpdate, @PathVariable(name = "id") String id);
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @ApiOperation("Borrar un adjunto")
    public void deleteAdjunto(@PathVariable(name = "id") String id);

}
