package co.com.cattleya.ms.services.service.application.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostServiceResponse {
    private String name;
    private Double price;
    private String description;
    private String type;
}
