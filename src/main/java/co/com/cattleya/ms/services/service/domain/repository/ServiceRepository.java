package co.com.cattleya.ms.services.service.domain.repository;

import co.com.cattleya.ms.services.service.domain.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Optional<Service> findByName(String name);
    List<Service> findAllByProviderId(Long id);
}
