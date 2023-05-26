package co.com.cattleya.ms.services.service.presentation.controller;

import co.com.cattleya.ms.services.service.application.dto.get.GetServiceResponse;
import co.com.cattleya.ms.services.service.application.mapper.GetServiceMapper;
import co.com.cattleya.ms.services.service.domain.model.CountryInfo;
import co.com.cattleya.ms.services.service.domain.model.EcoTrip;
import co.com.cattleya.ms.services.service.domain.model.Hosting;
import co.com.cattleya.ms.services.service.domain.model.Service;
import co.com.cattleya.ms.services.service.domain.service.ServiceService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("service")
public class GetServiceController {
    private final ServiceService service;
    @Autowired
    public GetServiceController(ServiceService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<GetServiceResponse>> getServices(@PathParam("provider") Long provider) throws Exception {
        List<Service> services;
        CountryInfo infoAdc;
        if (provider == null) {
            // Get all services
            services = service.getAllServices();
        } else {
            // Get services by providerId
            services = service.getAllByProviderId(provider);
        }
        if(services.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<GetServiceResponse> responses = new ArrayList<>();

        for (Service serv : services) {

            if (serv instanceof Hosting) {
                Hosting hosting = (Hosting) serv;
                String place = hosting.getPlace();
                infoAdc = service.getCountry(place);

                if (infoAdc == null ){
                    return ResponseEntity.badRequest().build();
                }
                responses.add(GetServiceMapper.toResponse(serv, infoAdc));
            }

            else if (serv instanceof EcoTrip) {
                EcoTrip ecoTrip = (EcoTrip) serv;
                String place = ecoTrip.getDestination();
                infoAdc = service.getCountry(place);

                if (infoAdc == null ){
                    return ResponseEntity.badRequest().build();
                }
                responses.add(GetServiceMapper.toResponse(serv, infoAdc));
            }

            else {
                responses.add(GetServiceMapper.toResponse(serv));
            }
        }

        return ResponseEntity.ok(responses);
    }
}