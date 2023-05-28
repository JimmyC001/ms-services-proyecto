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
public class DeleteOfferServiceController {
    private final OfferService service;
    @Autowired
    public DeleteOfferServiceController(OfferService service){
        this.service = service;
    }
    @DeleteMapping("{oId}/service/{sId}")
    public ResponseEntity<Offer> deleteServiceToOffer(@PathVariable Long oId, @PathVariable Long sId){
        if(oId == null || sId == null)
            return ResponseEntity.badRequest().build();
        Offer deleted = service.deleteServiceToOffer(oId, sId);
        if(deleted == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(deleted);
    }
}
