package co.com.cattleya.ms.services.service.application.mapper;

import co.com.cattleya.ms.services.service.application.dto.post.PostServiceRequest;
import co.com.cattleya.ms.services.service.application.dto.post.PostServiceResponse;
import co.com.cattleya.ms.services.service.domain.model.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class PostServiceMapper {
    private boolean validateFields(PostServiceRequest request, String ... values){
        for(String value: values)
            if(!request.getVariables().containsKey(value))
                return true;
        return false;
    }
    public Service toService(PostServiceRequest request){
        Service service;
        switch (request.getType().toUpperCase()) {
            case "HOSTING" -> {
                if (validateFields(request, "days", "place"))
                    return null;
                service = Hosting.builder()
                        .place(String.valueOf(request.getVariables().get("place")))
                        .days((Integer) request.getVariables().get("days"))
                        .country(String.valueOf(request.getVariables().get("country")) )
                        .build();
            }
            case "TRANSPORT" -> {
                if (validateFields(request, "company", "vehicle", "idVehicle", "origin", "destination"))
                    return null;
                service = Transport.builder()
                        .company(String.valueOf(request.getVariables().get("company")))
                        .vehicle(String.valueOf(request.getVariables().get("vehicle")))
                        .idVehicle(String.valueOf(request.getVariables().get("idVehicle")))
                        .origin(String.valueOf(request.getVariables().get("origin")))
                        .destination(String.valueOf(request.getVariables().get("destination")))
                        .build();
            }
            case "FOOD" -> {
                if (validateFields(request, "vegan", "kcal"))
                    return null;
                service = Food.builder()
                        .vegan(Boolean.parseBoolean((String) request.getVariables().get("vegan")))
                        .kcal(Double.parseDouble((String) request.getVariables().get("kcal")))
                        .build();
            }
            case "ECOTOUR" -> {
                if (validateFields(request, "origin", "destination", "activities"))
                    return null;
                service = EcoTrip.builder()
                        .origin(String.valueOf(request.getVariables().get("origin")))
                        .destination(String.valueOf(request.getVariables().get("destination")))
                        .activities(String.valueOf(request.getVariables().get("activities")))
                        .build();
            }
            default -> {
                return null;
            }
        }
        service.setName(request.getName());
        service.setPrice(request.getPrice());
        service.setDescription(request.getDescription());
        service.setProviderId(request.getProviderId());
        return service;
    }
    public PostServiceResponse toResponse(Service service, String type){
        return PostServiceResponse.builder()
            .name(service.getName())
            .price(service.getPrice())
            .description(service.getDescription())
            .type(type)
        .build();
    }
}
