package co.com.cattleya.ms.services.service.presentation.controller;

import co.com.cattleya.ms.services.service.domain.model.Service;
import co.com.cattleya.ms.services.service.domain.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
public class DeleteServiceController {
    private final ServiceService service;
    @Autowired
    public DeleteServiceController(ServiceService service){
        this.service = service;
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Service> deleteService(@PathVariable Long id){
        Service deleted = service.deleteService(id);
        if(deleted == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(deleted);
    }
}
