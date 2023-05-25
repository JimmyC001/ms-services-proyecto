package co.com.cattleya.ms.services.offer.presentation.controller;

import co.com.cattleya.ms.services.offer.application.dto.post.PostOfferRequest;
import co.com.cattleya.ms.services.offer.application.dto.post.PostOfferResponse;
import co.com.cattleya.ms.services.offer.application.mapper.PostOfficeMapper;
import co.com.cattleya.ms.services.offer.domain.model.Offer;
import co.com.cattleya.ms.services.offer.domain.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("offer")
public class PostOfferController {
    private final OfferService service;
    @Autowired
    public PostOfferController(OfferService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<PostOfferResponse> createOffer(@RequestBody PostOfferRequest request){
        if(request == null)
            return ResponseEntity.badRequest().build();
        Offer saved = service.saveOffer(PostOfficeMapper.toOffer(request));
        if(saved == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(PostOfficeMapper.toResponse(saved));
    }
}
