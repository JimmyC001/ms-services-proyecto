package co.com.cattleya.ms.services.offer.application.dto.put;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PutOfferRequest {
    private String name;
    private String description;
    private Double price;
}
