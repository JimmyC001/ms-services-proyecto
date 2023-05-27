package co.com.cattleya.ms.services.rating.domain.service;

import co.com.cattleya.ms.services.question.domain.model.Question;
import co.com.cattleya.ms.services.rating.domain.model.Rating;
import co.com.cattleya.ms.services.rating.domain.repository.RatingRepository;
import co.com.cattleya.ms.services.service.domain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private final RatingRepository repository;
    private final ServiceRepository serviceRepository;
    @Autowired
    public RatingService(RatingRepository repository, ServiceRepository serviceRepository) {
        this.repository = repository;
        this.serviceRepository = serviceRepository;
    }

    public Rating saveRating(Rating rating){
        Rating dbRating = repository.findByUserid(rating.getUserid()).orElse(null);
        if(dbRating!=null)
            return dbRating;
        return repository.save(rating);
    }

    public List<Rating> getByService (Long serviceId){
        co.com.cattleya.ms.services.service.domain.model.Service service = serviceRepository.findById(serviceId).orElse(null);
        if(service == null)
            return null;
        return repository.findAllByService(service);
    }

    public Rating deleteRating(Long id){
        Rating dbRating = repository.findById(id).orElse(null);
        if (dbRating == null)
            return null;
        repository.delete(dbRating);
        return dbRating;
    }
}
