package co.com.cattleya.ms.services.service.presentation.controller;

import co.com.cattleya.ms.services.service.application.dto.get.GetServiceResponse;
import co.com.cattleya.ms.services.service.application.mapper.GetServiceMapper;
import co.com.cattleya.ms.services.service.domain.model.*;
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
        MapsInfo mapsInfo;
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
                String countries = hosting.getCountry();
                infoAdc = service.getCountry(countries);
                mapsInfo = service.getMaps(place);

                if (infoAdc == null ){
                    return ResponseEntity.badRequest().build();
                }
                responses.add(GetServiceMapper.toResponse(serv, infoAdc , mapsInfo));
            }

            else if (serv instanceof EcoTrip) {
                EcoTrip ecoTrip = (EcoTrip) serv;
                String place = ecoTrip.getDestination();
                infoAdc = service.getCountry(place);

                if (infoAdc == null ){
                    return ResponseEntity.badRequest().build();
                }
                responses.add(GetServiceMapper.toResponse(serv, infoAdc , null));
            }
            else if (serv instanceof Transport){
                Transport transport = (Transport) serv;
                String destination = transport.getDestination();
                mapsInfo = service.getMaps( destination);

                if (mapsInfo == null ){
                    return ResponseEntity.badRequest().build();
                }
                responses.add(GetServiceMapper.toResponse(serv, null ,mapsInfo));
            }

            else {
                responses.add(GetServiceMapper.toResponse(serv));
            }
        }

        return ResponseEntity.ok(responses);
    }
}