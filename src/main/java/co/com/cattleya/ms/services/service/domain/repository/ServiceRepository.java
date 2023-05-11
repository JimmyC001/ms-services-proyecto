package co.com.cattleya.ms.services.service.domain.repository;

import co.com.cattleya.ms.services.service.domain.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByName(String name);
    List<Service> findAllByProviderId(Long id);
}
