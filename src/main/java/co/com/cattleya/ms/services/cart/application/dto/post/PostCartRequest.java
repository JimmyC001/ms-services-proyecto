package co.com.cattleya.ms.services.cart.application.dto.post;

import co.com.cattleya.ms.services.offer.domain.model.Offer;
import lombok.Data;

import java.util.List;

@Data
public class PostCartRequest {
    private Long clientId;
    private List<Offer> services;
}
