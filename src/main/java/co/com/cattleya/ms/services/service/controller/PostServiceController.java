package co.com.cattleya.ms.services.service.controller;

import co.com.cattleya.ms.services.service.dto.rest.ServiceRequest;
import co.com.cattleya.ms.services.service.dto.rest.ServiceResponse;
import co.com.cattleya.ms.services.service.entity.*;
import co.com.cattleya.ms.services.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
public class PostServiceController {
    private final ServiceService service;

    @Autowired
    public PostServiceController(ServiceService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<ServiceResponse> create(@RequestBody ServiceRequest request) {
        if (request == null)
            return ResponseEntity.badRequest().build();
        Service toSave;
        switch (request.getType().toUpperCase()) {
            case "HOSTING" -> {
                if (validateFields(request, "days", "place"))
                    return ResponseEntity.badRequest().build();
                toSave = Hosting.builder()
                        .place(String.valueOf(request.getVariables().get("place")))
                        .days(Integer.parseInt((String) request.getVariables().get("days")))
                        .build();
            }
            case "TRANSPORT" -> {
                if (validateFields(request, "company", "vehicle", "idVehicle", "origin", "destination"))
                    return ResponseEntity.badRequest().build();
                toSave = Transport.builder()
                        .company(String.valueOf(request.getVariables().get("company")))
                        .vehicle(String.valueOf(request.getVariables().get("vehicle")))
                        .idVehicle(String.valueOf(request.getVariables().get("idVehicle")))
                        .origin(String.valueOf(request.getVariables().get("origin")))
                        .destination(String.valueOf(request.getVariables().get("destination")))
                        .build();
            }
            case "FOOD" -> {
                if (validateFields(request, "vegan", "kcal"))
                    return ResponseEntity.badRequest().build();
                toSave = Food.builder()
                        .vegan(Boolean.parseBoolean((String) request.getVariables().get("vegan")))
                        .kcal(Double.parseDouble((String) request.getVariables().get("kcal")))
                        .build();
            }
            case "ECOTOUR" -> {
                if (validateFields(request, "origin", "destination", "activities"))
                    return ResponseEntity.badRequest().build();
                toSave = EcoTour.builder()
                        .origin(String.valueOf(request.getVariables().get("origin")))
                        .destination(String.valueOf(request.getVariables().get("destination")))
                        .activities(String.valueOf(request.getVariables().get("activities")))
                        .build();
            }
            default -> {
                return ResponseEntity.badRequest().build();
            }
        }
        toSave.setName(request.getName());
        toSave.setPrice(request.getPrice());
        toSave.setDescription(request.getDescription());
        toSave.setProviderId(request.getProviderId());
        Service founded = service.saveService(toSave);
        return ResponseEntity.ok(new ServiceResponse(founded.getName(), founded.getPrice(), founded.getDescription()));
    }
    private boolean validateFields(ServiceRequest request, String ... values){
        for(String value: values){
            if(!request.getVariables().containsKey(value))
                return true;
        }
        return false;
    }
}
