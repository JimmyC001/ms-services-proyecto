package co.com.cattleya.ms.services.cart.presentation.controller;

import co.com.cattleya.ms.services.cart.application.dto.post.PostCartRequest;
import co.com.cattleya.ms.services.cart.domain.model.Cart;
import co.com.cattleya.ms.services.cart.domain.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class PostCartController {
    private final CartService service;
    @Autowired
    public PostCartController(CartService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody PostCartRequest request){
        if(request == null)
            return ResponseEntity.badRequest().build();
        Cart newCart = new Cart();
        newCart.setClientId(request.getClientId());
        newCart.setServices(request.getServices());
        Cart saved = service.saveCart(newCart);
        if(saved == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(saved);
    }
}
