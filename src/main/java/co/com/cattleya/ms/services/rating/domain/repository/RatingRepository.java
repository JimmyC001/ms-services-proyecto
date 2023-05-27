package co.com.cattleya.ms.services.rating.domain.repository;

import co.com.cattleya.ms.services.rating.domain.model.Rating;
import co.com.cattleya.ms.services.service.domain.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating , Long> {
    Optional<Rating> findByUserid(Long id);

    List<Rating> findAllByService(Service service);
}
