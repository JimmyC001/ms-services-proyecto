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
public class DeleteCartController {
    private final CartService service;
    @Autowired
    public DeleteCartController(CartService service){
        this.service = service;
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable Long id){
        if(id == null)
            return ResponseEntity.badRequest().build();
        Cart deleted = service.deleteCart(id);
        if(deleted == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(deleted);
    }
}
