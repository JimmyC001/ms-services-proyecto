package co.com.cattleya.ms.services.offer.domain.repository;

import co.com.cattleya.ms.services.offer.domain.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<Offer> findByName(String name);
}
