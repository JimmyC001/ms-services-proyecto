package co.com.cattleya.ms.services.cart.presentation.controller;

import co.com.cattleya.ms.services.cart.domain.model.Cart;
import co.com.cattleya.ms.services.cart.domain.service.CartService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cart")
public class GetCartController {
    private final CartService service;
    @Autowired
    public GetCartController(CartService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Cart>> getCarts(@PathParam("customer") Long id){
        List<Cart> carts;
        //  Verify Customer ID
        if(id == null)
            carts = service.getAll();
        else
            carts = service.getAllCarts(id);
        //  Return Responses
        if(carts == null)
            return ResponseEntity.badRequest().build();
        if(carts.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(carts);
    }
}
