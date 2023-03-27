package co.com.cattleya.ms.services.service.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse {
    private String name;
    private Double price;
    private String description;
}
