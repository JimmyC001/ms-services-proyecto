package co.com.cattleya.ms.services.offer.presentation.controller;

import co.com.cattleya.ms.services.offer.application.dto.put.PutOfferRequest;
import co.com.cattleya.ms.services.offer.application.mapper.PutOfferMapper;
import co.com.cattleya.ms.services.offer.domain.model.Offer;
import co.com.cattleya.ms.services.offer.domain.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("offer")
public class PutOfferController {
    private final OfferService service;
    @Autowired
    public PutOfferController(OfferService service, PutOfferMapper mapper){
        this.service = service;
    }
    @PutMapping("{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable Long id, @RequestBody PutOfferRequest request){
        Offer toUpdate = PutOfferMapper.toOffer(request);
        if(toUpdate == null)
            return ResponseEntity.badRequest().build();
        toUpdate.setId(id);
        Offer updated = service.updateOffer(toUpdate);
        if(updated == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updated);
    }
}
