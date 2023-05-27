package co.com.cattleya.ms.services.service.domain.service;

import co.com.cattleya.ms.services.service.domain.model.CountryInfo;
import co.com.cattleya.ms.services.service.domain.model.MapsInfo;
import co.com.cattleya.ms.services.service.domain.repository.ServiceRepository;
import co.com.cattleya.ms.services.service.infrastructure.persistence.CountryServiceAPI;
import co.com.cattleya.ms.services.service.infrastructure.persistence.MapsServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository repository;
    private final CountryServiceAPI repositoryCountry;
    private final MapsServiceAPI repositoryMaps;

    @Autowired
    public ServiceService(ServiceRepository repository, CountryServiceAPI repositoryCountry, MapsServiceAPI repositoryMaps) {
        this.repository = repository;
        this.repositoryCountry = repositoryCountry;
        this.repositoryMaps = repositoryMaps;
    }

    public CountryInfo getCountry(String countryName) throws Exception {
        return repositoryCountry.getCountryInfo(countryName);
    }
    public MapsInfo getMaps( String destination) throws Exception {
        return repositoryMaps.getMapsRout( destination);
    }

    public co.com.cattleya.ms.services.service.domain.model.Service findById(Long id) {
        return repository.findById(id).orElse(null);
    }


    public co.com.cattleya.ms.services.service.domain.model.Service saveService(co.com.cattleya.ms.services.service.domain.model.Service service) {
        co.com.cattleya.ms.services.service.domain.model.Service dbService = repository.findByName(service.getName());
        if (dbService != null)
            return dbService;
        return repository.save(service);
    }

    public List<co.com.cattleya.ms.services.service.domain.model.Service> getAllServices() {
        return repository.findAll();
    }


    public List<co.com.cattleya.ms.services.service.domain.model.Service> getAllByProviderId(Long id) {
        return repository.findAllByProviderId(id);
    }

    public <T extends co.com.cattleya.ms.services.service.domain.model.Service> List<T> getAllOf(Long id, Class<T> tClass) {
        List<T> result = new ArrayList<>();
        if (id != null) {
            for (co.com.cattleya.ms.services.service.domain.model.Service service : repository.findAll()) {
                if (tClass.isInstance(service) && service.getProviderId().equals(id)) {
                    result.add(tClass.cast(service));
                }
            }
        } else {
            for (co.com.cattleya.ms.services.service.domain.model.Service service : repository.findAll()) {
                if (tClass.isInstance(service)) {
                    result.add(tClass.cast(service));
                }
            }
        }
        return result;
    }

    public co.com.cattleya.ms.services.service.domain.model.Service updateService(Long id, String name, Double price, String description) {
        co.com.cattleya.ms.services.service.domain.model.Service service = findById(id);
        if(service == null)
            return null;
        service.setName(name);
        service.setPrice(price);
        service.setDescription(description);
        return repository.save(service);
    }

    private boolean validateText(co.com.cattleya.ms.services.service.domain.model.Service service, String text){
        if(text.isEmpty())
            return true;
        return service.getName().toUpperCase().contains(text.toUpperCase()) || service.getDescription().toUpperCase().contains(text.toUpperCase());
    }

    public List<co.com.cattleya.ms.services.service.domain.model.Service> getFromText(String text){
        if(text == null)
            return null;
        return getAllServices().stream().filter(service -> validateText(service, text)).toList();
    }

    public co.com.cattleya.ms.services.service.domain.model.Service deleteService(Long id){
        co.com.cattleya.ms.services.service.domain.model.Service service = repository.findById(id).orElse(null);
        if(service == null)
            return null;
        repository.delete(service);
        return service;
    }



}
