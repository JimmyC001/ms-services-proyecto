package co.com.cattleya.ms.services.cart.presentation.controller;

import co.com.cattleya.ms.services.cart.application.dto.post.PostCartOfferRequest;
import co.com.cattleya.ms.services.cart.domain.model.Cart;
import co.com.cattleya.ms.services.cart.domain.service.CartService;
import co.com.cattleya.ms.services.offer.domain.model.Offer;
import co.com.cattleya.ms.services.offer.domain.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class PostCartOfferController {
    private final CartService service;
    @Autowired
    public PostCartOfferController(CartService service) {
        this.service = service;
    }
    @PostMapping("{id}/offer")
    public ResponseEntity<Cart> addOfferToCart(@PathVariable Long id, @RequestBody PostCartOfferRequest request){
        if(id == null)
            return ResponseEntity.badRequest().build();
        Cart updated = service.addOfferToCart(id, request.getProviderId(), request.getOfferId());
        if(updated == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updated);
    }
}
