package co.com.cattleya.ms.services.offer.application.dto.put;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PutOfferRequest {
    private String name;
    private String description;
    private Double price;
    private List<String> services;
}
