package co.com.cattleya.ms.services.cart.presentation.controller;

import co.com.cattleya.ms.services.cart.domain.model.Cart;
import co.com.cattleya.ms.services.cart.domain.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class DeleteCartOfferController {
    private final CartService service;
    @Autowired
    public DeleteCartOfferController(CartService service){
        this.service = service;
    }
    @DeleteMapping("{cId}/offer/{oId}")
    public ResponseEntity<Cart> deleteOfferFromCart(@PathVariable Long cId, @PathVariable Long oId){
        if(cId == null || oId == null)
            return ResponseEntity.badRequest().build();
        Cart deleted = service.deleteOfferToCart(cId, oId);
        if(deleted == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(deleted);
    }
}
