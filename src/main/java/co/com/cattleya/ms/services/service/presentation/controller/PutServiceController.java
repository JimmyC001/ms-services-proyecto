package co.com.cattleya.ms.services.service.presentation.controller;

import co.com.cattleya.ms.services.service.application.dto.put.PutServiceRequest;
import co.com.cattleya.ms.services.service.application.dto.put.PutServiceResponse;
import co.com.cattleya.ms.services.service.application.mapper.PutServiceMapper;
import co.com.cattleya.ms.services.service.domain.model.Service;
import co.com.cattleya.ms.services.service.domain.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("service")
public class PutServiceController {
    private final ServiceService service;
    @Autowired
    public PutServiceController(ServiceService service){
        this.service = service;
    }
    @PutMapping("{id}")
    public ResponseEntity<PutServiceResponse> updateEcoTrip(@PathVariable Long id, @RequestBody PutServiceRequest request){
        if(request == null)
            return ResponseEntity.badRequest().build();
        Service result = service.updateService(id, request.getName(), request.getPrice(), request.getDescription());
        if(result == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(PutServiceMapper.toResponse(result));
    }
}
