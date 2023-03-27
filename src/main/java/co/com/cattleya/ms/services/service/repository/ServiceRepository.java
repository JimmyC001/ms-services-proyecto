package co.com.cattleya.ms.services.service.repository;

import co.com.cattleya.ms.services.service.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByName(String name);
}
