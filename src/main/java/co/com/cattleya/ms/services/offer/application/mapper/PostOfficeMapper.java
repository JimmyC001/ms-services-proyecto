package co.com.cattleya.ms.services.offer.application.mapper;

import co.com.cattleya.ms.services.offer.application.dto.post.PostOfferRequest;
import co.com.cattleya.ms.services.offer.application.dto.post.PostOfferResponse;
import co.com.cattleya.ms.services.offer.domain.model.Offer;

public class PostOfficeMapper {
    public static Offer toOffer(PostOfferRequest request){
        return Offer.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .providerId(request.getProviderId())
        .build();
    }
    public static PostOfferResponse toResponse(Offer offer){
        return PostOfferResponse.builder()
                .name(offer.getName())
                .description(offer.getDescription())
                .price(offer.getPrice())
        .build();
    }
}
