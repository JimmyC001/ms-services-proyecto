package co.com.cattleya.ms.services.service.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {
    private String name;
    private Double price;
    private String description;
    private Long providerId;
    private String type;
    private Map<String, Object> variables;
}
