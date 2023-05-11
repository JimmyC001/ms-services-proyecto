package co.com.cattleya.ms.services.service.presentation.controller;

import co.com.cattleya.ms.services.service.domain.model.*;
import co.com.cattleya.ms.services.service.domain.service.ServiceService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("service")
public class GetServiceByTypeController {
    private final ServiceService service;
    @Autowired
    public GetServiceByTypeController(ServiceService service){
        this.service = service;
    }
    @GetMapping("{type}")
    public ResponseEntity<List<? extends Service>> getFromType(@PathVariable String type, @PathParam("provider") Long provider){
        if(type == null)
            return ResponseEntity.badRequest().build();
        List<? extends Service> services = null;
        switch(type){
            case "hosting" -> {
                services = service.getAllOf(provider, Hosting.class);
            }
            case "ecotrip" -> {
                services = service.getAllOf(provider, EcoTrip.class);
            }
            case "food" -> {
                services = service.getAllOf(provider, Food.class);
            }
            case "transport" -> {
                services = service.getAllOf(provider, Transport.class);
            }
            default -> {
                return ResponseEntity.badRequest().build();
            }
        }
        if(services == null)
            return ResponseEntity.badRequest().build();
        if(services.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(services);
    }
}
