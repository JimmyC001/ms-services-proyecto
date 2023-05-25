package co.com.cattleya.ms.services.service.domain.repository;

import co.com.cattleya.ms.services.service.domain.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByName(String name);
    List<Service> findAllByProviderId(Long id);
}
