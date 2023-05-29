package co.com.cattleya.ms.services.service.application.dto.get;

import co.com.cattleya.ms.services.service.domain.model.CountryInfo;
import co.com.cattleya.ms.services.service.domain.model.MapsInfo;
import co.com.cattleya.ms.services.service.domain.model.WeatherInfo;
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
    private MapsInfo mapsInfo;
    private WeatherInfo weatherInfo;
}
