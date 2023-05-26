package co.com.cattleya.ms.services.service.application.dto.get;

import co.com.cattleya.ms.services.service.domain.model.CountryInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetServiceResponse {
    private Double price;
    private String description;
    private CountryInfo country;
}
