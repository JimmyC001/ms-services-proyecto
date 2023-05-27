package co.com.cattleya.ms.services.rating.application.mapper;

import co.com.cattleya.ms.services.question.application.dto.post.PostQuestionRequest;
import co.com.cattleya.ms.services.question.domain.model.Question;
import co.com.cattleya.ms.services.rating.application.dto.post.PostRatingRequest;
import co.com.cattleya.ms.services.rating.domain.model.Rating;
import co.com.cattleya.ms.services.service.domain.model.Service;
import co.com.cattleya.ms.services.service.domain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostRatingMapper {

    @Autowired
    private ServiceRepository serviceRepository;
    public Rating toRating(PostRatingRequest request){
        Service service = serviceRepository.findById(request.getService()).orElse(null);
        if(service == null)
            return null;
        return Rating.builder()
                .points(request.getPoints())
                .userid(request.getUserid())
                .description(request.getDescription())
                .service(service)
                .build();
    }
}
