package co.com.cattleya.ms.services.offer.presentation.controller;

import co.com.cattleya.ms.services.offer.domain.model.Offer;
import co.com.cattleya.ms.services.offer.domain.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("offer")
public class GetOfferController {
    private final OfferService service;
    @Autowired
    public GetOfferController(OfferService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Offer>> getAllServices(){
        List<Offer> offers = service.getAllOffers();
        if (offers.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(offers);
    }
}
