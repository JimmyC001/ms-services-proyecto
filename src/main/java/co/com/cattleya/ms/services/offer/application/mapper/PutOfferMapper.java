package co.com.cattleya.ms.services.offer.application.mapper;

import co.com.cattleya.ms.services.offer.application.dto.put.PutOfferRequest;
import co.com.cattleya.ms.services.offer.domain.model.Offer;
import co.com.cattleya.ms.services.service.domain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PutOfferMapper {
    @Autowired
    private ServiceRepository serviceRepository;
    public Offer toOffer(PutOfferRequest request){
        return Offer.builder()
            .name(request.getName())
            .description(request.getDescription())
            .services(request.getServices().stream()
                .map(service -> serviceRepository.findByName(service))
                .filter(Objects::nonNull).toList())
        .build();
    }
}
