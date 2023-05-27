package co.com.cattleya.ms.services.service.application.mapper;

import co.com.cattleya.ms.services.service.application.dto.get.GetServiceResponse;
import co.com.cattleya.ms.services.service.domain.model.CountryInfo;
import co.com.cattleya.ms.services.service.domain.model.MapsInfo;
import co.com.cattleya.ms.services.service.domain.model.Service;

public class GetServiceMapper {
    public static GetServiceResponse toResponse(Service service , CountryInfo country , MapsInfo mapsInfo){
        return GetServiceResponse.builder()
                .country(country)
                .mapsInfo(mapsInfo)
                .price(service.getPrice())
                .description(service.getDescription())
                .build();
    }
    public static GetServiceResponse toResponse(Service service) {
        return toResponse(service, null , null);
    }
    public static GetServiceResponse toResponse(Service service , MapsInfo mapsInfo) {
        return toResponse(service,  null , mapsInfo);
    }
    public static GetServiceResponse toResponse(Service service , CountryInfo countryInfo) {
        return toResponse(service,  countryInfo , null);
    }
}
