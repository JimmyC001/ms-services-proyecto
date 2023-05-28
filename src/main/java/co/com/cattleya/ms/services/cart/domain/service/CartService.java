package co.com.cattleya.ms.services.cart.domain.service;

import co.com.cattleya.ms.services.cart.domain.model.Cart;
import co.com.cattleya.ms.services.cart.domain.repository.CartRepository;
import co.com.cattleya.ms.services.cart.infrastructure.persistence.PaymentAPI;
import co.com.cattleya.ms.services.offer.domain.model.Offer;
import co.com.cattleya.ms.services.offer.domain.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository repository;
    private final OfferRepository offerRepository;
    private final PaymentAPI paymentAPI;
    @Autowired
    public CartService(CartRepository repository, OfferRepository offerRepository, PaymentAPI paymentAPI){
        this.repository = repository;
        this.offerRepository = offerRepository;
        this.paymentAPI = paymentAPI;
    }
    public Cart saveCart(Cart cart){
        Cart dbCart = repository.findByClientId(cart.getClientId()).orElse(null);
        if(dbCart != null)
            return dbCart;
        cart.setStatus("PENDING");
        cart.setPrice(0.0);
        return repository.save(cart);
    }
    public List<Cart> getAll(){
        return repository.findAll();
    }
    public List<Cart> getAllCarts(Long clientId){
        Cart dbCart = repository.findByClientId(clientId).orElse(null);
        if(dbCart == null)
            return Collections.emptyList();
        return List.of(dbCart).stream()
                .filter(offer -> offer.getStatus().equals("PENDING"))
                .toList();
    }
    public Cart deleteCart(Long id){
        Cart dbCart = repository.findById(id).orElse(null);
        if(dbCart == null)
            return null;
        repository.delete(dbCart);
        return dbCart;
    }
    private Cart updateCartPrice(Cart cart){
        double finalPrice = 0;
        for(Offer offer: cart.getServices()){
            finalPrice += offer.getPrice();
        }
        cart.setPrice(finalPrice);
        return cart;
    }
    public Cart addOfferToCart(Long id, Long provider, Long offer){
        Cart dbCart = repository.findById(id).orElse(null);
        if(dbCart == null)
            return null;
        Offer newOffer = offerRepository.findById(offer).orElse(null);
        if(newOffer == null){
            newOffer = Offer.builder()
                .name("Pack " + dbCart.getServices().size())
                .description("Pack of provider "+ provider)
                .providerId(provider)
            .build();
            offerRepository.save(newOffer);
        }
        dbCart.getServices().add(newOffer);
        updateCartPrice(dbCart);
        return repository.save(dbCart);
    }
    public Cart deleteOfferToCart(Long id, Long offer){
        Cart dbCart = repository.findById(id).orElse(null);
        if(dbCart == null)
            return null;
        Optional<Offer> founded = dbCart.getServices().stream().filter(s -> s.getId().equals(offer)).findFirst();
        if(founded.isEmpty())
            return null;
        dbCart.getServices().remove(founded.get());
        updateCartPrice(dbCart);
        return repository.save(dbCart);
    }
    public Cart payCart(Long client) throws IOException {
        Cart dbCart = repository.findByClientId(client).orElse(null);
        if(dbCart == null)
            return null;
        // Call API
        updateCartPrice(dbCart);
        if(paymentAPI.pay(client, dbCart.getPrice()))
            dbCart.setStatus("PAYED");
        return repository.save(dbCart);
    }
}
