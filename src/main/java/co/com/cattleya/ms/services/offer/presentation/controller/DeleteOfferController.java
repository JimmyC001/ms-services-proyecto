package co.com.cattleya.ms.services.offer.presentation.controller;

import co.com.cattleya.ms.services.offer.domain.model.Offer;
import co.com.cattleya.ms.services.offer.domain.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("offer")
public class DeleteOfferController {
    private final OfferService service;
    @Autowired
    public DeleteOfferController(OfferService service){
        this.service = service;
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Offer> deleteOffer(@PathVariable Long id){
        if(id == null)
            return ResponseEntity.badRequest().build();
        Offer deleted = service.deleteOffer(id);
        if(deleted == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(deleted);
    }
}
