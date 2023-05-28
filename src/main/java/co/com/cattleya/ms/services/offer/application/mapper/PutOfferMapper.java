package co.com.cattleya.ms.services.offer.application.mapper;

import co.com.cattleya.ms.services.offer.application.dto.put.PutOfferRequest;
import co.com.cattleya.ms.services.offer.domain.model.Offer;
import org.springframework.stereotype.Component;

@Component
public class PutOfferMapper {
    public static Offer toOffer(PutOfferRequest request){
        return Offer.builder()
            .name(request.getName())
            .description(request.getDescription())
            .price(request.getPrice())
        .build();
    }
}
