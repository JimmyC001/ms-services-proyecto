package co.com.cattleya.ms.services.offer.application.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostOfferResponse {
    private String name;
    private String description;
    private Double price;
}
