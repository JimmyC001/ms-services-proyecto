package co.com.cattleya.ms.services.cart.presentation.controller;

import co.com.cattleya.ms.services.cart.application.dto.post.PostPayCartRequest;
import co.com.cattleya.ms.services.cart.domain.model.Cart;
import co.com.cattleya.ms.services.cart.domain.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("cart")
public class PostPayCartController {
    private final CartService service;
    @Autowired
    public PostPayCartController(CartService service){
        this.service = service;
    }
    @PostMapping("pay")
    public ResponseEntity<Cart> payCart(@RequestBody PostPayCartRequest request){
        if(request == null)
            return ResponseEntity.badRequest().build();
        try {
            Cart payed = service.payCart(request.getClient());
            if(payed == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(payed);
        } catch (IOException exception){
            return ResponseEntity.badRequest().build();
        }
    }
}
