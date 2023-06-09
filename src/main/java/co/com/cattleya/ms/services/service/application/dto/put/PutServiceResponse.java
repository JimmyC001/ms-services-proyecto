package co.com.cattleya.ms.services.service.application.dto.put;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutServiceResponse {
    private String name;
    private Double price;
    private String description;
}
