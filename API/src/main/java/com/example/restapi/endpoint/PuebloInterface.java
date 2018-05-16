package com.example.restapi.endpoint;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.restapi.classes.Resultado;
import com.example.restapi.model.Pueblo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@FeignClient(value = "account-service", fallback = PuebloEndpoint.class)
public interface PuebloInterface {
	
	@RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation("Ver un pueblo con un id específico")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Pueblo.class)})
    public Pueblo getPueblo(@PathVariable(name = "id") Long id);
	
	@RequestMapping(method = RequestMethod.GET)
    @ApiOperation("Ver todos los pueblos del sistema")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Pueblo.class)})
    public List<Pueblo> getAllPueblos();
	
	@RequestMapping(path = "{id}/{id2}", method = RequestMethod.GET)
    @ApiOperation("Ver la mejor ruta entre pueblos")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Pueblo.class)})
    public Resultado getMejorRuta(@PathVariable(name = "id") int id, @PathVariable(name = "id2") int id2);
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Agregar un pueblo")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Pueblo.class)})
    public Pueblo saveProduct(@RequestBody Pueblo productToSave);
	
	@RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Modificar un pueblo")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Pueblo.class)})
    public Pueblo updateProduct(@RequestBody Pueblo productToUpdate, @PathVariable(name = "id") String id);
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @ApiOperation("Borrar un pueblo")
    public void deleteProduct(@PathVariable(name = "id") String id);

}
