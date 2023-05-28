package co.com.cattleya.ms.services.cart.application.dto.post;

import lombok.Data;

@Data
public class PostCartOfferRequest {
    private Long offerId;
    private Long providerId;
}
