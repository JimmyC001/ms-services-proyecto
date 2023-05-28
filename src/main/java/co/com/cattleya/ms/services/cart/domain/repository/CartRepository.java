package co.com.cattleya.ms.services.cart.domain.repository;

import co.com.cattleya.ms.services.cart.domain.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByClientId(Long clientId);
}
