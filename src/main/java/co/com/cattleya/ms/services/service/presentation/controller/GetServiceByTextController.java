package co.com.cattleya.ms.services.service.presentation.controller;

import co.com.cattleya.ms.services.service.application.dto.get.GetFromTextRequest;
import co.com.cattleya.ms.services.service.domain.model.Service;
import co.com.cattleya.ms.services.service.domain.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ws/service")
public class GetServiceByTextController {
    private final ServiceService service;
    @Autowired
    public GetServiceByTextController(ServiceService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<List<Service>> getFromText(@RequestBody GetFromTextRequest request){
        if(request == null)
            return ResponseEntity.badRequest().build();
        List<Service> result = service.getFromText(request.getText());
        if(result.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }
}
