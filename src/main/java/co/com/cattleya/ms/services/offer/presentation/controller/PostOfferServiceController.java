package co.com.cattleya.ms.services.offer.presentation.controller;

import co.com.cattleya.ms.services.offer.application.dto.post.PostOfferServiceRequest;
import co.com.cattleya.ms.services.offer.domain.model.Offer;
import co.com.cattleya.ms.services.offer.domain.service.OfferService;
import co.com.cattleya.ms.services.service.domain.model.Service;
import co.com.cattleya.ms.services.service.domain.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("offer")
public class PostOfferServiceController {
    private final OfferService service;
    private final ServiceService serviceService;
    @Autowired
    public PostOfferServiceController(OfferService service, ServiceService serviceService){
        this.service = service;
        this.serviceService = serviceService;
    }
    @PostMapping("{id}/service")
    public ResponseEntity<Offer> addServiceToOffer(@PathVariable Long id, @RequestBody PostOfferServiceRequest request){
        if(id == null || request==null)
            return ResponseEntity.badRequest().build();
        Service dbService = serviceService.findByName(request.getService());
        if(dbService == null)
            return ResponseEntity.badRequest().build();
        Offer updated = service.addServiceToOffer(id, dbService);
        if(updated == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updated);
    }
}
