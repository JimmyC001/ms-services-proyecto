package co.com.cattleya.ms.services.service.presentation.controller;

import co.com.cattleya.ms.services.service.domain.model.Service;
import co.com.cattleya.ms.services.service.domain.service.ServiceService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("service")
public class GetServiceController {
    private final ServiceService service;
    @Autowired
    public GetServiceController(ServiceService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Service>> getServices(@PathParam("provider") Long provider) {
        List<Service> services;
        if (provider == null) {
            // Get all services
            services = service.getAllServices();
        } else {
            // Get services by providerId
            services = service.getAllByProviderId(provider);
        }
        if(services.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(services);
    }
}
