package com.example.restapi.endpoint;

import com.example.restapi.model.Pueblo;
import com.example.restapi.service.PuebloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/pueblos/")
@Api(value = "PueblosEndpointAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class PuebloEndpoint {

    private PuebloService puebloService;

    @Autowired
    public void setProductsService(PuebloService productsService) {
        this.puebloService = productsService;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation("Ver un pueblo con un id específico")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Pueblo.class)})
    public Pueblo getPueblo(@PathVariable(name = "id") Long id) {
        return puebloService.getPueblo(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Agregar un pueblo")
    public Pueblo saveProduct(@RequestBody Pueblo productToSave) {
        return puebloService.savePueblo(productToSave);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Modificar un pueblo")
    public Pueblo updateProduct(@RequestBody Pueblo productToUpdate, @PathVariable(name = "id") String id) {
        return puebloService.updatePueblo(productToUpdate, id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @ApiOperation("Borrar un pueblo")
    public void deleteProduct(@PathVariable(name = "id") String id) {
    	puebloService.deletePueblo(id);
    }
}
