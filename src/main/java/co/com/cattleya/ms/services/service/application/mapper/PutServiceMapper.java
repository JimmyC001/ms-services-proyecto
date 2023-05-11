package co.com.cattleya.ms.services.service.application.mapper;

import co.com.cattleya.ms.services.service.application.dto.put.PutServiceResponse;
import co.com.cattleya.ms.services.service.domain.model.Service;

public class PutServiceMapper {
    public static PutServiceResponse toResponse(Service service){
        return PutServiceResponse.builder()
                .name(service.getName())
                .price(service.getPrice())
                .description(service.getDescription())
        .build();
    }
}
