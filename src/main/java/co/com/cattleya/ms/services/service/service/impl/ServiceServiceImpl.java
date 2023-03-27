package co.com.cattleya.ms.services.service.service.impl;

import co.com.cattleya.ms.services.service.repository.ServiceRepository;
import co.com.cattleya.ms.services.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository repository;
    @Autowired
    public ServiceServiceImpl(ServiceRepository repository){
        this.repository = repository;
    }
    @Override
    public co.com.cattleya.ms.services.service.entity.Service saveService(co.com.cattleya.ms.services.service.entity.Service service) {
        co.com.cattleya.ms.services.service.entity.Service dbService = repository.findByName(service.getName());
        if(dbService != null)
            return dbService;
        return repository.save(service);
    }
}
