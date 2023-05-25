package co.com.cattleya.ms.services.offer.application.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostOfferRequest {
    private String name;
    private String description;
    private Double price;
    private Long providerId;
}
