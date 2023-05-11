package co.com.cattleya.ms.services.service.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("transport")
public class Transport extends Service{
    private String company;
    private String vehicle;
    private String idVehicle;
    private String origin;
    private String destination;
}
