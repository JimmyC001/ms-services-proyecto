package co.com.cattleya.ms.services.service.application.mapper;

import co.com.cattleya.ms.services.service.application.dto.get.GetServiceResponse;
import co.com.cattleya.ms.services.service.domain.model.CountryInfo;
import co.com.cattleya.ms.services.service.domain.model.Service;

public class GetServiceMapper {
    public static GetServiceResponse toResponse(Service service , CountryInfo country){
        return GetServiceResponse.builder()
                .country(country)
                .price(service.getPrice())
                .description(service.getDescription())
                .build();
    }
    public static GetServiceResponse toResponse(Service service) {
        return toResponse(service, null);
    }

}
