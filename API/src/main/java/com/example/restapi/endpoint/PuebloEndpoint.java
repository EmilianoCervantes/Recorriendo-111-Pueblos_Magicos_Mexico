package com.example.restapi.endpoint;

import com.example.restapi.classes.Resultado;
import com.example.restapi.model.Pueblo;
import com.example.restapi.service.PuebloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/pueblos/")
@Api(value = "PueblosEndpointAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class PuebloEndpoint implements PuebloInterface {

    private PuebloService puebloService;

    @Autowired
    public void setPuebloService(PuebloService puebloService) {
        this.puebloService = puebloService;
    }
    
    @Override
    public Pueblo getPueblo(Long id) {
        return puebloService.getPueblo(id);
    }
    
    @Override
    public List<Pueblo> getAllPueblos() {
        return puebloService.getAllPueblos();
    }
    
    @Override
    public Resultado getMejorRuta(int id, int id2) {
        return puebloService.correrDijkstra(id, id2);
    }

    @Override
    public Pueblo saveProduct(Pueblo productToSave) {
        return puebloService.savePueblo(productToSave);
    }

    @Override
    public Pueblo updateProduct(@RequestBody Pueblo productToUpdate, @PathVariable(name = "id") String id) {
        return puebloService.updatePueblo(productToUpdate, id);
    }

    @Override
    public void deleteProduct(String id) {
    	puebloService.deletePueblo(id);
    }
}
